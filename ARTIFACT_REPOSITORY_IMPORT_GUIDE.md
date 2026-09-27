# 盒子IM (Box-IM & Box-IM-Admin) 企业内部制品库导入与分发实操手册

本文档专为企业架构师、DevOps 运维工程师及内网环境管理员编写，详细指导如何将 **Box-IM**（IM通信中枢）与 **Box-IM-Admin**（综合管理运营后台）的全套离线开发依赖，完整导入至企业内部私有制品库（如 **Sonatype Nexus 3**、**JFrog Artifactory**、**Harbor** 等），实现团队级高速、统一、合规的内网依赖分发。

---

## 1. 制品分类与目标制品库映射表

| 依赖类别 | 离线包源文件 | 目标企业制品库 | 仓库类型 (Repository Type) | 目标仓库名称示例 |
| :--- | :--- | :--- | :--- | :--- |
| **Java / 后端组件** | `maven-repository.tar.gz` | **Sonatype Nexus 3** 或 **JFrog Artifactory** | Maven (Hosted / 本地宿主库) | `maven-releases` 或 `3rd_party` |
| **前端 NPM 依赖** | `im-web-node_modules.tar.gz`<br>`im-admin-ui-node_modules.tar.gz` | **Nexus 3** 或 **Verdaccio** | NPM (Hosted / 本地宿主库) | `npm-hosted` / `npm-private` |
| **容器基础镜像** | MySQL 8.0, Redis 6.2 (Docker) | **Harbor** 或 **Nexus 3** | Docker / OCI 镜像仓库 | `harbor.corp.com/im/...` |

---

## 2. 后端 Maven 依赖导入企业制品库 (Nexus 3 / Artifactory)

### 2.1 方案 A：Nexus 宿主机任务导入（速度最快，官方强烈推荐）
如果运维人员拥有 Nexus 3 服务器宿主机的操作权限，该方案可在数分钟内瞬间完成数千个 jar 包的批量入库，无需消耗 HTTP 上传带宽。

1. **解压仓库至 Nexus 服务器临时目录**：
   ```bash
   mkdir -p /tmp/im-maven-repo
   tar -xzf maven-repository.tar.gz -C /tmp/im-maven-repo --strip-components=1
   ```
2. **在 Nexus 3 管理界面创建导入任务**：
   - 登录 Nexus Web 管理界面（拥有管理员权限）；
   - 点击顶部齿轮 **System (设置)** -> **Tasks** -> 点击 **Create task**；
   - 任务类型选择：**`Repository - Import`**；
   - 任务参数配置：
     - **Task name**: `Import-Box-IM-Dependencies`
     - **Source directory**: 输入宿主机上的解压路径 `/tmp/im-maven-repo`
     - **Repository**: 选择内部目标宿主仓库（例如 `maven-releases` 或 `3rd_party`）
   - 点击 **Create task** 并手动点击 **Run** 执行任务；
3. **查看进度**：
   - 在 **Tasks** 列表中查看任务状态为 `DONE`，此时进入 **Browse** 即可查看到所有 Spring Boot、Netty、Redisson、OBS 等组件已全量注册入库。

---

### 2.2 方案 B：客户端脚本批量发布（开发机/跳板机执行）
若运维仅分配了 Nexus 发布账号（账号密码）且无法访问服务器文件系统，可使用我们提供的自动化批量上传脚本。

#### 步骤 1：在开发机 `settings.xml` 中配置发布认证凭据
打开 `~/.m2/settings.xml`（或安装包内的 `settings.xml`），在 `<servers>` 节点中添加对应目标仓库的认证权限：
```xml
<servers>
  <server>
    <id>nexus-releases</id>
    <username>your-nexus-admin</username>
    <password>your-nexus-password</password>
  </server>
</servers>
```

#### 步骤 2：解压 Maven 离线仓库
```bash
mkdir -p /tmp/repository
tar -xzf maven-repository.tar.gz -C /tmp/repository --strip-components=1
```

#### 步骤 3：运行批量推送脚本
离线套件中已预置批量上传脚本 [`upload_to_nexus.sh`](file:///Users/lizonglun/code/box-im-offline-bundle/upload_to_nexus.sh)（Windows 下对应 [`upload_to_nexus.bat`](file:///Users/lizonglun/code/box-im-offline-bundle/upload_to_nexus.bat)）：

- **Linux / macOS 执行**：
  ```bash
  cd box-im-offline-bundle
  chmod +x upload_to_nexus.sh
  
  # 参数1: 解压的repository路径
  # 参数2: 目标Nexus hosted仓库的上传URL
  # 参数3: settings.xml中配置的server id
  ./upload_to_nexus.sh /tmp/repository http://nexus.corp.intranet:8081/repository/maven-releases/ nexus-releases
  ```

- **Windows 执行**：
  ```cmd
  upload_to_nexus.bat D:\temp\repository http://nexus.corp.intranet:8081/repository/maven-releases/ nexus-releases
  ```

> [!TIP]
> 脚本会自动过滤源码包（`-sources.jar`）与文档包（`-javadoc.jar`），严格匹配 `.pom` 元数据并调用 `mvn deploy:deploy-file` 快速发布，遇到已存在的 jar 会自动记录并跳过。

---

### 2.3 方案 C：导入 JFrog Artifactory
如果企业使用的是 JFrog Artifactory：
1. **控制台 ZIP 一键导入**：
   - 登录 Artifactory 管理控制台；
   - 点击 **Administration** -> **Repositories** -> **Import & Export** -> **Repositories**；
   - 在 **Import Repository from Zip** 中选择目标本地仓库（如 `libs-release-local`），上传 `maven-repository.tar.gz`（可转为 `.zip` 格式）即可完成自动导入。
2. **使用 JFrog CLI 导入**：
   ```bash
   jf rt upload "/tmp/repository/*" "libs-release-local/" --flat=false
   ```

---

## 3. 前端 NPM 依赖导入内部制品库 (Nexus / Verdaccio)

### 3.1 方案选择说明
前端工程包含庞大深层的依赖链（两个项目累计包含数千个微小依赖包）。在大型内网环境中：
- **方案 A（企业最推崇实践，零失误）**：直接在代码工作目录解压提供的 `im-web-node_modules.tar.gz` 和 `im-admin-ui-node_modules.tar.gz` 作为项目内置 Vendor，免去走网络私服下载环节，启动耗时 0 延迟，且绝对避免版本漂移；
- **方案 B（推入内部 NPM 私服）**：若内网安全审计要求必须走 NPM Hosted 私服并统一由 `npm install` 拉取，按以下步骤导入。

### 3.2 导入 Nexus NPM Hosted 宿主仓库步骤
1. **在内网机器配置 NPM 登录私服**：
   ```bash
   npm config set registry http://nexus.corp.intranet:8081/repository/npm-hosted/
   npm login --registry=http://nexus.corp.intranet:8081/repository/npm-hosted/
   ```
2. **提取并批量发布离线 Tarball**：
   在联网环境或通过离线缓存提取 `.tgz` 包后，使用通用循环命令推送到内网私服：
   ```bash
   find ./npm-packages -name "*.tgz" -exec npm publish {} --registry=http://nexus.corp.intranet:8081/repository/npm-hosted/ \;
   ```

---

## 4. Docker 基础设施镜像导入企业 Harbor 镜像仓库

针对 `docker-compose.yml` 中的基础设施镜像（`mysql:8.0` 与 `redis:6.2`）：

### 4.1 导出镜像 (外网工作机)
```bash
docker pull mysql:8.0
docker pull redis:6.2
docker save -o im-docker-images.tar mysql:8.0 redis:6.2
```

### 4.2 导入并推送到内部 Harbor (内网跳板机)
```bash
# 1. 加载镜像
docker load -i im-docker-images.tar

# 2. 登录内网 Harbor
docker login harbor.corp.intranet

# 3. 重新打标并推送
docker tag mysql:8.0 harbor.corp.intranet/im/mysql:8.0
docker tag redis:6.2 harbor.corp.intranet/im/redis:6.2

docker push harbor.corp.intranet/im/mysql:8.0
docker push harbor.corp.intranet/im/redis:6.2
```

### 4.3 适配项目 `docker-compose.yml`
将 `box-im/docker-compose.yml` 中的镜像名调整为内网 Harbor 地址：
```yaml
services:
  mysql:
    image: harbor.corp.intranet/im/mysql:8.0
    ...
  redis:
    image: harbor.corp.intranet/im/redis:6.2
    ...
```

---

## 5. 项目开发人员对接内部私服配置指南

一旦管理员将 Maven 依赖导入企业内部 Nexus / Artifactory，团队开发人员只需在内网电脑的 `~/.m2/settings.xml` 中将镜像地址指向内部私服：

### 5.1 配置 `~/.m2/settings.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">

  <mirrors>
    <mirror>
      <id>internal-nexus</id>
      <name>企业内部统一制品库</name>
      <!-- 拦截所有仓库请求，全部走内网私服 -->
      <mirrorOf>*</mirrorOf>
      <url>http://nexus.corp.intranet:8081/repository/maven-public/</url>
    </mirror>
  </mirrors>

  <!-- 如果私服访问需要鉴权，添加认证 -->
  <servers>
    <server>
      <id>internal-nexus</id>
      <username>developer</username>
      <password>developer_password</password>
    </server>
  </servers>

</settings>
```

### 5.2 验证编译（无需离线 `-o` 参数）
```bash
cd box-im
mvn clean package -DskipTests

cd box-im-admin/im-admin
mvn clean package -DskipTests
```
*所有依赖将会以千兆/万兆内网带宽极速从企业制品库下载并完成编译打包。*

---

## 6. 常见排错与常见问题 (FAQ)

### Q1: 批量推送提示 `400 Repository does not allow updating assets`？
- **原因**：Nexus 目标仓库设置了“不允许覆盖已有版本（Disable Redeploy）”。
- **解决**：在 Nexus 管理端编辑对应 Hosted 仓库，在 **Deployment policy** 中将策略由 `Disable redeploy` 临时调整为 `Allow redeploy`，导入完成后可再切换回来。

### Q2: 上传提示 `401 Unauthorized`？
- **原因**：`settings.xml` 中 `<server><id>` 与执行命令传参的 `repositoryId` 不一致，或者账号密码权限不足（缺少 `nx-repository-view-*-*-add` 或 `edit` 权限）。
- **解决**：核对 `settings.xml` 中的 `<id>` 确保严格一致，确认账号具有该仓库的 Write / Upload 权限。

### Q3: 某些 POM 导入时报 `Checksum validation failed`？
- **原因**：部分历史 jar 自带旧的 sha1/md5 校验码与新生成的哈希不匹配。
- **解决**：使用脚本提供的 `mvn deploy:deploy-file` 参数自动重新计算 checksum，避免直接复制损坏的文件。

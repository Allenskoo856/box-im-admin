# 盒子IM (Box-IM & Box-IM-Admin) 内网纯离线二次开发与部署指南

本文档专为在**金融、涉密、专网、离线隔离内网**环境下进行 **Box-IM**（IM通信中枢）与 **Box-IM-Admin**（综合管理运营后台）二次开发的工程师编写。

依托我们已打包的离线依赖套件，系统可以在**物理完全断网、无外网 Maven 镜像源、无外网 NPM 官方镜像**的环境下，实现**解压即构建、零网络请求、完全自主可控**的二次开发与运行。

---

## 1. 离线依赖资源包清单与结构

离线开发套件目录位于 `box-im-offline-bundle/`，结构如下：

```text
box-im-offline-bundle/
├── OpenJDK17U-jdk_x64_linux.tar.gz  # [环境] OpenJDK 17 LTS (Linux x64 免安装版, ~184MB, Eclipse Temurin 17.0.20.1)
├── maven-repository.tar.gz          # [后端] 全量离线 Maven 本地仓库包 (~735MB，已预清理 lastUpdated 与远程校验)
├── im-web-node_modules.tar.gz       # [前端] box-im Web 前端完整 node_modules 依赖包 (~38MB)
├── im-admin-ui-node_modules.tar.gz  # [前端] box-im-admin 管理后台完整 node_modules 依赖包 (~146MB)
├── settings.xml                     # [配置] 纯离线专用的 Maven settings 配置文件 (强制 offline 模式)
├── install_offline.sh               # [脚本] Linux / macOS 内网一键解压安装脚本
├── install_offline.bat              # [脚本] Windows 内网一键解压安装脚本
├── upload_to_nexus.sh               # [脚本] 批量推送 Maven 依赖至内部私服脚本 (Linux/macOS)
├── upload_to_nexus.bat              # [脚本] 批量推送 Maven 依赖至内部私服脚本 (Windows)
├── ARTIFACT_REPOSITORY_IMPORT_GUIDE.md # [文档] 企业内部制品库导入与分发实操手册
└── OFFLINE_DEV_GUIDE.md             # [文档] 本二次开发与离线部署指南
```

> [!NOTE]
> - 本离线包已预先下载并固化了两个项目全量编译所需要的 **所有 Spring Boot 插件、MyBatis-Plus、Redisson、Netty、Sa-Token、华为云 OBS SDK、MapStruct、Knife4j、前端 Element Plus、Vite、TypeScript** 等所有依赖项。
> - 删除了 `*.lastUpdated` 与 `_remote.repositories` 文件，避免在内网机器因缺少原远程仓库元数据而发生拦截。

---

## 2. 内网环境一键还原步骤

将 `box-im`、`box-im-admin` 代码库及 `box-im-offline-bundle` 拷贝至内网工作站后，推荐放置在同级目录下：
```text
your-code-dir/
├── box-im/
├── box-im-admin/
└── box-im-offline-bundle/
```

### 2.1 Linux / macOS 一键安装
在终端执行：
```bash
cd box-im-offline-bundle
chmod +x install_offline.sh
./install_offline.sh
```
该脚本会自动：
1. 解压 `maven-repository.tar.gz` 到当前用户的 `~/.m2/repository`；
2. 检测并自动配置离线 `~/.m2/settings.xml`；
3. 将前端依赖解压到 `box-im/im-web/node_modules` 与 `box-im-admin/im-admin-ui/node_modules`；
4. 若系统尚未配置 Java 17，自动解压 `OpenJDK17U-jdk_x64_linux.tar.gz` 到 `~/.local/jdk-17` 并输出环境变量配置提示。

### 2.2 Windows 一键安装
双击执行 `install_offline.bat`，或在命令行中运行：
```cmd
cd box-im-offline-bundle
install_offline.bat
```

### 2.3 手动解压（可选，灵活定制路径）
如果希望自定义 Maven 仓库存储路径或因权限原因无法使用脚本：
1. **解压 Maven 仓库**：
   ```bash
   # 解压到你指定的仓库路径，例如 /opt/maven/repository
   mkdir -p ~/.m2/repository
   tar -xzf maven-repository.tar.gz -C ~/.m2/repository --strip-components=1
   ```
2. **复制 settings.xml**：
   ```bash
   cp settings.xml ~/.m2/settings.xml
   ```
3. **解压前端 node_modules**：
   ```bash
   tar -xzf im-web-node_modules.tar.gz -C ../box-im/im-web
   tar -xzf im-admin-ui-node_modules.tar.gz -C ../box-im-admin/im-admin-ui
   ```

---

## 3. IDE 离线开发环境配置 (IntelliJ IDEA)

在内网打开 IntelliJ IDEA 时，必须设置 Maven 为离线模式，避免 IDE 尝试连接外网中央仓库导致超时卡死。

1. 打开 **Settings / Preferences** -> **Build, Execution, Deployment** -> **Build Tools** -> **Maven**。
2. 关键配置项勾选与设置：
   - **Work offline**：✅ **必须勾选**（强制离线工作模式）；
   - **Maven home path**：选择系统自带或内置 Maven 3.8+；
   - **User settings file**：指向解压后的 `settings.xml`（例如 `~/.m2/settings.xml`）；
   - **Local repository**：指向解压后的离线仓库目录（例如 `~/.m2/repository`）。
3. 点击 **Apply** 并刷新 Maven 工程。

---

## 4. 离线构建与验证 (全命令行)

在完全拔掉网线或断开外网的环境下，可执行以下命令验证：

### 4.1 离线编译与打包后端
> [!IMPORTANT]
> 命令行执行 Maven 构建时，务必携带 **`-o`**（即 `--offline` 离线参数）：

- **编译 Box-IM**：
  ```bash
  cd box-im
  mvn clean package -DskipTests -o
  ```
  *预期输出：`Reactor Summary ... BUILD SUCCESS`，产出 `im-platform.jar` 和 `im-server.jar`。*

- **编译 Box-IM-Admin**：
  ```bash
  cd box-im-admin/im-admin
  mvn clean package -DskipTests -o
  ```
  *预期输出：29 个子模块全部 SUCCESS，产出 `ruoyi-admin/target/im-admin.jar`。*

### 4.2 离线启动前端开发服务器
内网已内置完整 `node_modules`，**严禁执行 `npm install`**（外网不可达会报错），直接启动开发或构建：

- **启动 Box-IM 前端**：
  ```bash
  cd box-im/im-web
  npm run dev
  ```
- **启动 Box-IM-Admin 前端**：
  ```bash
  cd box-im-admin/im-admin-ui
  npm run dev
  ```
- **前端离线生产打包**：
  ```bash
  cd box-im/im-web && npm run build
  cd box-im-admin/im-admin-ui && npm run build
  ```

---

## 5. 内网基础设施与配置适配

### 5.1 数据库初始化 (GoldenDB / MySQL 8.0)
系统完全剔除了任何后端启动自动建表/插库的逻辑，必须由运维或 DBA 执行一次性脚本：
1. **Box-IM 业务库初始化**：
   - 数据库名：`im_platform_open`（或企业自定义库名，如 `im_platform`）；
   - 脚本：[`box-im/db/init_goldendb_mysql.sql`](file:///Users/lizonglun/code/box-im/db/init_goldendb_mysql.sql)；
   - 包含 9 张表结构（无外键、字段小写）及 468 条敏感词种子数据。
2. **Box-IM-Admin 管理库初始化**：
   - 数据库名：`im_admin`；
   - 脚本：[`box-im-admin/db/init_goldendb_mysql.sql`](file:///Users/lizonglun/code/box-im-admin/db/init_goldendb_mysql.sql)；
   - 包含 21 张管理台基础表及默认权限角色数据。

### 5.2 核心配置文件修改清单

#### A. Box-IM 配置适配 (`im-platform` & `im-server`)
- 文件路径：
  - `box-im/im-platform/src/main/resources/application-dev.yml`
  - `box-im/im-server/src/main/resources/application-dev.yml`
- 关键项：
  - **数据库**：修改 `spring.datasource.url`、`username`、`password` 指向内网 GoldenDB/MySQL；
  - **Redis**：修改 `spring.data.redis.host`、`port`、`password`（支持单机与集群）；
  - **OBS**：修改 `obs.endpoint`（内网 VPC OBS 终端节点，例如 `obs.内网域.com`）、`access-key`、`secret-key`、`bucket-name`；
  - **JWT 秘钥**：确保 `im-platform` 与 `im-server` 中的 `jwt.accessToken.secret` 保持完全一致！

#### B. Box-IM-Admin 配置适配 (`im-admin`)
- 文件路径：`box-im-admin/im-admin/ruoyi-admin/src/main/resources/application-dev.yml`
- 关键项：
  - **多数据源 `dynamic.datasource`**：
    - `admin`：指向 `im_admin` 管理库；
    - `platform`：指向 `im_platform_open` 业务库；
  - **Redis**：`spring.data.redis` 节点；
  - **OBS**：`obs:` 节点配置华为云 OBS 终端与桶信息。

---

## 6. 二次开发最佳实践与编码指南

### 6.1 去 Lombok 纯净 POJO 编码规范 (全系统通用)
为了彻底规避 IDE 插件版本冲突、字节码隐式注入异常及团队开发环境差异，两个项目已**全量彻底剥离 Lombok**。在后续二次开发新增代码时，必须严格遵守原生标准：

1. **实体类与传输对象 (Entity / DTO / VO / BO)**：
   - **禁止**使用 `@Data`、`@Getter`、`@Setter`、`@Slf4j`、`@AllArgsConstructor`、`@NoArgsConstructor`、`@RequiredArgsConstructor` 等注解；
   - **必须**使用标准原生 Java 显式编写 Getter、Setter、构造方法及 `toString()`；
   - 工具类必须显式声明私有构造方法：`private MyUtils() {}`。
2. **日志标准**：
   - 统一声明原生 SLF4J 门面，底层由 `Log4j2` 驱动：
     ```java
     private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(YourService.class);
     ```

### 6.2 扩展全新消息类型流程 (业务扩展示例)
若需要在 IM 中新增一种消息类型（例如：地理位置消息、业务审批卡片）：

1. **第 1 步：定义枚举类型**
   - 文件：`im-common/src/main/java/com/bx/imcommon/enums/MessageType.java`
   - 新增类型枚举项，例如：`LOCATION(20, "位置消息")` 或 `CARD(21, "业务卡片")`。
2. **第 2 步：定义业务 Payload DTO**
   - 在 `im-platform/src/main/java/com/bx/implatform/dto/` 下新建对应的数据结构；
   - 发送时由前端序列化为 JSON 字符串存入 `content` 字段。
3. **第 3 步：前端消息组件与渲染适配**
   - 在 `box-im/im-web/src/components/chat/` 下增加新消息的渲染卡片组件；
   - 在 `chatBox.vue` 的类型分发判断中，引入并挂载新组件。

### 6.3 管理端访问 IM 业务多数据源 (Dynamic-Datasource)
在 `box-im-admin` 中，需要操作或监控 IM 业务库（如审计聊天记录、封禁群组）时：
- 默认数据源为系统管理库 `admin`；
- 在 Mapper 或 Service 方法/类上标注 `@DS("platform")`，Dynamic-Datasource 即可自动切换到 IM 业务库执行查询：
  ```java
  @Service
  @DS("platform") // 自动路由至 im_platform 业务库
  public class ImUserAuditServiceImpl implements ImUserAuditService {
      @Autowired
      private ImUserMapper imUserMapper;
      
      public List<ImUserVO> listActiveUsers() {
          return imUserMapper.selectList(null);
      }
  }
  ```

### 6.4 编译期对象转换 (MapStruct-Plus)
在 `box-im-admin` 中，实体与 VO 之间转换采用纯原生兼容的 `mapstruct-plus`：
```java
// 声明在实体或 VO 上
@AutoMapper(target = SysUserVo.class)
public class SysUser { ... }

// 业务中一行代码高性能转换，无反射损耗：
SysUserVo userVo = MapstructUtils.convert(user, SysUserVo.class);
```

---

## 7. 内网常见排错速查手册 (FAQ)

### Q1: 命令行执行 `mvn clean package` 报错 `Network is unreachable` 或无法解析插件？
- **原因**：没有添加 `-o` 离线参数，Maven 默认会尝试连接外网仓库检查插件更新。
- **解决**：
  1. 必须始终携带 `-o` 参数：`mvn clean package -DskipTests -o`；
  2. 确认 `~/.m2/settings.xml` 中已设置 `<offline>true</offline>`。

### Q2: 前端执行 `npm run dev` 报错或无法识别依赖？
- **原因**：前端依赖包未完整解压到对应目录，或执行了 `npm install` 覆盖了本地安装。
- **解决**：
  1. 重新从 `im-web-node_modules.tar.gz` 和 `im-admin-ui-node_modules.tar.gz` 解压；
  2. 确认 Node.js 版本推荐为 18+ 或 20+。本项目完全剥离了 `node-sass` 等依赖 C++ 原生构建的过时模块，纯 Dart Sass + 原生 TypeScript，零原生编译风险。

### Q3: 华为云 OBS 在内网无法连通或提示 403 / UnknownHostException？
- **原因**：内网环境无法解析公网域名，或者未使用内网 VPC Endpoint。
- **解决**：
  1. 向企业云平台管理员索取内网专用 OBS Endpoint（如 `obs.corp.intranet.com`）；
  2. 在 `application-dev.yml` 中将 `obs.endpoint` 与 `obs.domain` 配置为内网直连地址；
  3. 确认服务器配置了内网 DNS 或在 `/etc/hosts` 中添加了解析。

### Q4: 数据库连接报编码或时区错误？
- **解决**：确保 JDBC URL 包含标准参数：
  `jdbc:mysql://host:port/dbname?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true`

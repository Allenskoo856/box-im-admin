# 盒子IM管理后台 (Box-IM-Admin) - 架构与开发智能指南 (AGENTS.md)

本文档专为开发者与 AI 智能体（Agents）编写，系统梳理了 **Box-IM-Admin**（盒子IM综合运营管理后台）的项目架构、模块职责、技术选型、环境搭建、启动调试、运维排错及二次开发规范。

---

## 1. 项目定位与核心特性

**Box-IM-Admin** 是配合 **Box-IM** 即时通讯系统打造的企业级运营监控与多租户权限管理平台。基于现代化主流架构构建：
- **双库协同与多数据源动态路由**：默认配置 `master`（系统管理库 `im_admin`）与 `im_platform`（IM 业务中枢库 `im_platform_open`），实现对用户账户、群组管理、聊天记录审计、敏感词监控、实时连接状态等业务数据的透明管理。
- **现代化中后台前端**：采用 Vue 3.4+、Vite 5、Element Plus、Pinia、TypeScript，开箱即用，支持多端自适应与动态路由鉴权。
- **高安全多租户权限体系**：集成 Sa-Token 权限鉴权引擎，支持 JWT 状态存储、租户数据隔离、动态数据权限（DataScope）与操作日志审计。
- **华为云 OBS 原生集成**：对象存储全面采用华为云 OBS（彻底废弃并剥离 MinIO），无缝支撑系统头像、多媒体文件、聊天附件预览等场景。
- **高性能去 Lombok 纯净架构**：严格遵循纯原生 Java 17 规范开发，全库完全剔除 Lombok 依赖，采用标准 POJO 与 MapStruct-Plus，保证跨 IDE 与构建工具的高兼容性。
- **企业级 Log4j2 异步日志**：替换 Spring Boot 默认 Logback，基于 Log4j2 提供控制台彩色高亮、每天/每100MB滚动文件归档与60天历史留存。
- **信创与金融级数据库兼容**：提供标准 GoldenDB / MySQL 8.0 初始化脚本，完全摒弃代码自启建表插库，适配信创金融合规要求。

---

## 2. 技术栈清单

| 层次 | 技术选型 | 说明 |
| :--- | :--- | :--- |
| **基础语言与框架** | Java 17, Spring Boot 3.2.11 | 后端核心运行环境（严禁使用 Lombok，采用标准原生 POJO） |
| **安全与鉴权中心** | Sa-Token 1.38.0 | 轻量级高性能鉴权框架，支持 Token、角色权限、多租户 |
| **持久层与 ORM** | MyBatis-Plus 3.5.7, Dynamic-Datasource 4.3.1 | 分页插件、多数据源动态切换、SQL 防注入 |
| **连接池** | Alibaba Druid 1.2.23 | 高性能数据库连接池，自带监控与防御规则 |
| **日志框架** | Log4j2 2.21+ (`spring-boot-starter-log4j2`) | 替代 Logback，统一 SLF4J 门面与异步/滚动日志输出 |
| **缓存与分布式锁**| Redis 6.2+, Redisson 3.29.0 | 缓存管理、分布式锁、延时队列 |
| **对象存储** | 华为云 OBS (Huawei Cloud OBS) 3.26+ | 统一对象存储，支持预签名、缩略图、直链分发 |
| **对象映射** | MapStruct-Plus 1.4.5 | 编译期高性能对象转换，原生适配纯净 POJO |
| **接口文档** | SpringDoc (OpenAPI 3), Knife4j 4.5.0 | 自动生成标准化 Swagger/OpenAPI 接口文档 |
| **Web 前端** | Vue 3.4, Vite 5.1, TypeScript, Element Plus, Pinia | 响应式后台前端，支持暗黑模式、标签页导航 |

---

## 3. 仓库结构与各模块职责

```text
box-im-admin/
├── db/                                # 数据库脚本（GoldenDB / MySQL 全量初始化脚本）
│   └── init_goldendb_mysql.sql       # 包含系统表与业务表的规范全量 DDL 与初始数据
├── im-admin/                          # 后端 Maven 多模块工程根目录
│   ├── ruoyi-admin/                   # 应用程序主入口模块 (端口: 8889)
│   ├── ruoyi-common/                  # 公共组件通用基础库
│   │   ├── ruoyi-common-core/         # 核心常量、枚举、工具类、基础实体
│   │   ├── ruoyi-common-mybatis/      # MyBatis-Plus 与多数据源封装、BaseMapper
│   │   ├── ruoyi-common-obs/          # 华为云 OBS 客户端与文件多媒体服务
│   │   ├── ruoyi-common-redis/        # Redis & Redisson 缓存工具与分布式锁
│   │   ├── ruoyi-common-satoken/      # Sa-Token 权限鉴权与会话管理
│   │   ├── ruoyi-common-security/     # 安全拦截与白名单配置
│   │   ├── ruoyi-common-log/          # 操作日志与审计注解拦截
│   │   ├── ruoyi-common-web/          # Web MVC 配置、全局异常处理器 (Log4j2 绑定)
│   │   └── ...                        # excel, websocket, sensitive, translation 等
│   └── ruoyi-modules/                 # 业务功能模块
│       ├── ruoyi-system/              # 系统基础业务（用户、角色、部门、字典、菜单、租户）
│       ├── ruoyi-im/                  # IM 业务监控与运营管理（群组、私聊、聊天记录、状态）
│       └── ruoyi-generator/           # 代码生成器模块
└── im-admin-ui/                       # 前端工程源码 (Vue 3 + Vite + Element Plus)
```

---

## 4. 核心架构与关键机制

### 4.1 多数据源架构与动态路由
系统配置有两个核心数据源，均由 `dynamic-datasource-spring-boot-starter` 自动管理：
1. **`master` (`im_admin`)**：负责系统管理自身体系（如管理员用户 `sys_user`、系统角色 `sys_role`、系统菜单 `sys_menu`、操作日志等）。
2. **`im_platform` (`im_platform_open`)**：直连即时通讯服务端业务数据库，管理用户账户、好友关系、群聊会话、聊天消息审计等。
- **切换方式**：在 Service 或 Mapper 方法上标注 `@DS("im_platform")` 即可自动无缝路由到 IM 业务库，缺省为 `master`。

### 4.2 华为云 OBS 对象存储集成
- 统一在 `ruoyi-common-obs` 中封装 `ObsService` 与 `FileService`。
- 上传逻辑支持文件 MD5 去重、自动分年月目录归档、图片等比例/固定宽高缩略图生成。
- 业务系统无需关心底层细节，直接注入 `FileService`：
  ```java
  UploadImageVO uploadImage = fileService.uploadImage(file, true);
  String originUrl = uploadImage.getOriginUrl();
  String thumbUrl = uploadImage.getThumbUrl();
  ```
- **配置属性**（统一在 `application-*.yml` 中的 `obs:` 节点配置）：
  ```yaml
  obs:
    endpoint: obs.cn-south-1.myhuaweicloud.com
    access-key: YOUR_AK
    secret-key: YOUR_SK
    bucket-name: your-bucket-name
    domain: https://your-bucket-name.obs.cn-south-1.myhuaweicloud.com
  ```

### 4.3 纯原生 Java 17 (No Lombok) 规范
- 全模块完全剔除 Lombok 依赖及编译插件（`git grep -rn "lombok"` 为 0）。
- 所有实体类、VO、BO、DTO 严格使用标准原生 Java 17 编写：显式私有属性、Getter/Setter、构造器与 `toString()`。
- 工具类强制使用私有构造器 `private ClassName() {}` 防实例化。
- 日志统一使用原生 SLF4J Logger：
  ```java
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(YourClass.class);
  ```

### 4.4 生产级 Log4j2 日志体系
- 全局排除 `spring-boot-starter-logging`，使用 `spring-boot-starter-log4j2`。
- 核心配置文件位于 `im-admin/ruoyi-admin/src/main/resources/log4j2.xml`。
- **特性**：
  - 控制台彩色格式化打印；
  - 自动滚动日志文件归档至 `logs/im-admin/`；
  - 触发策略：按天滚动 + 单文件达 100MB 自动分卷；
  - 保留周期：自动清理 60 天以上或单目录累计超 30GB 的历史日志。

---

## 5. 本地环境依赖与快速启动

### 5.1 环境要求
- **JDK**：OpenJDK 17+
- **Maven**：3.8+ / 3.9+
- **Node.js**：v18+ (推荐 v20)
- **数据库**：MySQL 8.0+ 或 GoldenDB
- **缓存**：Redis 6.2+

### 5.2 步骤一：数据库初始化 (GoldenDB / MySQL)
系统彻底剔除了自启建表逻辑。请手动导入初始化脚本：
1. 创建数据库（若尚未创建）：
   ```sql
   CREATE DATABASE IF NOT EXISTS `im_admin` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```
2. 执行全量初始化脚本：
   - 脚本路径：[`db/init_goldendb_mysql.sql`](file:///Users/lizonglun/code/box-im-admin/db/init_goldendb_mysql.sql)
   - 该脚本包含全量 21 张管理台基础表及默认管理员角色、菜单权限数据。

### 5.3 步骤二：后端编译与启动

```bash
# 1. 切换至后端工程根目录
cd im-admin

# 2. 编译并打包所有子模块 (不依赖任何外部 IDE 插件)
mvn clean package -DskipTests

# 3. 启动管理后台服务 (端口: 8889)
java -jar ./ruoyi-admin/target/im-admin.jar
```

### 5.4 步骤三：前端编译与启动

```bash
# 1. 切换至前端工程目录
cd im-admin-ui

# 2. 安装依赖并启动本地开发服务
npm install --registry=https://registry.npmmirror.com
npm run dev

# 3. 前端生产打包 (可选)
npm run build
```

### 5.5 系统访问与默认凭据
- **管理后台前端页面**：[http://localhost:80](http://localhost:80)（根据 `vite.config.ts` 默认端口）
- **管理后台后端接口**：[http://localhost:8889](http://localhost:8889)
- **Swagger / Knife4j 接口文档**：[http://localhost:8889/doc.html](http://localhost:8889/doc.html)
- **超级管理员账号**：`admin`
- **超级管理员初始密码**：`admin123`

---

## 6. 二次开发规范与注意事项

### 6.1 新增模块与代码生成
- 使用后台内置的“代码生成”功能时，模板已全部适配**无 Lombok** 原生 Java 代码标准。
- 新增 Controller、Service、Domain 时，禁止在类上增加 `@Data`、`@Slf4j` 等注解，务必使用标准 Getter/Setter 与显式 Logger。

### 6.2 MapStruct-Plus 对象转换
- 实体与 VO/BO 转换采用 `io.github.linpeilie:mapstruct-plus`。
- 在类上标注 `@AutoMapper(target = SysUserVo.class)` 即可在编译期自动生成转换实现类，通过 `MapstructUtils.convert(source, Target.class)` 直接完成深度拷贝转换。

### 6.3 数据库字段与 GoldenDB 规范
- 金融级/信创 GoldenDB 环境要求表名与字段名统一小写，禁止使用保留字。
- 时间字段统一使用 `datetime`，主键统一为 `bigint not null auto_increment` 或雪花 ID。
- 修改或新增 DDL 需同步更新 `db/init_goldendb_mysql.sql`。

### 6.4 Git 提交与协同
- 统一在 `dev` 分支上进行二次开发与功能提交；
- 遵循 Conventional Commits 规范（如 `feat:`, `fix:`, `refactor:`, `docs:` 等）。

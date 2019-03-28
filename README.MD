### FEBS后台权限管理系统
![https://img.shields.io/badge/build-success-brightgreen.svg?longCache=true&style=flat-square](https://img.shields.io/badge/build-success-brightgreen.svg?longCache=true&style=flat-square)
![https://img.shields.io/badge/license-Apache%202-blue.svg?longCache=true&style=flat-square](https://img.shields.io/badge/license-Apache%202-blue.svg?longCache=true&style=flat-square)
![https://img.shields.io/badge/download-1k-green.svg?longCache=true&style=flat-square](https://img.shields.io/badge/download-1k-green.svg?longCache=true&style=flat-square)
![https://img.shields.io/badge/springboot-2.0.4-yellow.svg?longCache=true&style=popout-square](https://img.shields.io/badge/springboot-2.0.4-yellow.svg?longCache=true&style=popout-square)
![https://img.shields.io/badge/apache%20shiro-1.4.0-green.svg?longCache=true&style=flat-square](https://img.shields.io/badge/apache%20shiro-1.4.0-green.svg?longCache=true&style=flat-square)

FEBS是一个简单高效的后台权限管理系统。项目基础框架采用全新的Java Web开发框架 —— Spring Boot2.0.4，消除了繁杂的XML配置，使得二次开发更为简单；数据访问层采用Mybatis，同时引入了通用Mapper和PageHelper插件，可快速高效的对单表进行增删改查操作，消除了大量传统XML配置SQL的代码；安全框架采用时下流行的Apache Shiro，可实现对按钮级别的权限控制；前端页面使用Bootstrap构建，主题风格为时下Google最新设计语言Material Design，并提供多套配色以供选择。FEBS意指：Fast，Easy use，Beautiful和Safe。
<!--more-->
### 功能模块
系统功能模块组成如下所示：
```
|-------------------------------------------|
|    ______ ______ ____   _____             |
|   |  ____|  ____|  _ \ / ____|            |
|   | |__  | |__  | |_) | (___              |
|   |  __| |  __| |  _ < \___ \             |
|   | |    | |____| |_) |____) |            |
|   |_|    |______|____/|_____/             |
|   Spring-Boot-Version: 2.0.4.RELEASE      |
|-------------------------------------------|
|
├─系统管理
│  ├─用户管理
│  ├─角色管理
│  ├─菜单管理
│  ├─部门管理
│  ├─字典管理
│  ├─属性管理
│  ├─区域管理
│  └─人员管理
├─系统监控
│  ├─在线用户
│  ├─系统日志
│  ├─Redis监控
│  └─Redis终端
│─商务楼宇
│  ├─楼宇管理
│  ├─客户管理
│  ├─楼宇客户信息维护
│  ├─竞争产品管理
│  ├─客户到期管理
│  ├─商机楼宇管理
│  └─商机客户管理
│─空间资源
│  ├─综合接入区管理
│  ├─机房管理
│  └─标准地址管理
└─任务调度
   ├─定时任务
   └─调度日志
```
### 技术选型
#### 后端
- 基础框架：Spring Boot 2.0.4.RELEASE

- 持久层框架：Mybatis 3.4.5

- 安全框架：Apache Shiro 1.4.0

- 摸板引擎：Thymeleaf 3.0.9.RELEASE

- 数据库连接池：阿里巴巴Druid 1.1.10

- 缓存框架：Redis

- 日志打印：logback

- 其他：fastjson，poi，javacsv，quartz等。

#### 前端
 
- 基础框架：Bootstrap 4

- JavaScript框架：jQuery

- 消息组件：Bootstrap notify

- 提示框插件：SweetAlert2

- 树形插件：jsTree

- 树形表格插件：jqTreeGrid

- 表格插件：BootstrapTable

- 表单校验插件：jQuery-validate

- 多选下拉框插件：multiple-select

- 图表插件：Chart.js

- 时间插件：daterangepicker

#### 开发环境

- 语言：Java 8

- IDE：Eclipse Oxygen & IDEA 2018.1.4(Ultimate Edition)

- 依赖管理：Maven

- 数据库：Oracle 11g & MySQL5.7

- 版本管理：SVN，git
/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : mrbird
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : MRBIRD

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2018-04-02 17:10:34
*/


-- ----------------------------
-- Table structure for T_DEPT
-- ----------------------------
DROP TABLE "MRBIRD"."T_DEPT";
CREATE TABLE "MRBIRD"."T_DEPT" (
"DEPT_ID" NUMBER NOT NULL ,
"PARENT_ID" NUMBER NOT NULL ,
"DEPT_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"ORDER_NUM" NUMBER NULL ,
"CREATE_TIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_DEPT"."DEPT_ID" IS '部门ID';
COMMENT ON COLUMN "MRBIRD"."T_DEPT"."PARENT_ID" IS '上级部门ID';
COMMENT ON COLUMN "MRBIRD"."T_DEPT"."DEPT_NAME" IS '部门名称';
COMMENT ON COLUMN "MRBIRD"."T_DEPT"."ORDER_NUM" IS '排序';
COMMENT ON COLUMN "MRBIRD"."T_DEPT"."CREATE_TIME" IS '创建时间';

-- ----------------------------
-- Records of T_DEPT
-- ----------------------------
INSERT INTO "MRBIRD"."T_DEPT" VALUES ('1', '0', '开发部', null, TO_DATE('2018-01-04 15:42:26', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_DEPT" VALUES ('3', '1', '开发二部', null, TO_DATE('2018-01-04 15:42:29', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_DEPT" VALUES ('5', '0', '人事部', null, TO_DATE('2018-01-04 15:42:32', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_DEPT" VALUES ('2', '1', '开发一部', null, TO_DATE('2018-01-04 15:42:34', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_DEPT" VALUES ('4', '0', '市场部', null, TO_DATE('2018-01-04 15:42:36', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_DEPT" VALUES ('6', '0', '测试部', null, TO_DATE('2018-01-04 15:42:38', 'YYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Table structure for T_DICT
-- ----------------------------
DROP TABLE "MRBIRD"."T_DICT";
CREATE TABLE "MRBIRD"."T_DICT" (
"DICT_ID" NUMBER NOT NULL ,
"KEY" NUMBER NOT NULL ,
"VALUE" VARCHAR2(100 BYTE) NOT NULL ,
"FIELD_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"TABLE_NAME" VARCHAR2(100 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_DICT"."DICT_ID" IS '字典ID';
COMMENT ON COLUMN "MRBIRD"."T_DICT"."KEY" IS '键';
COMMENT ON COLUMN "MRBIRD"."T_DICT"."VALUE" IS '值';
COMMENT ON COLUMN "MRBIRD"."T_DICT"."FIELD_NAME" IS '字段名';
COMMENT ON COLUMN "MRBIRD"."T_DICT"."TABLE_NAME" IS '表名';

-- ----------------------------
-- Records of T_DICT
-- ----------------------------
INSERT INTO "MRBIRD"."T_DICT" VALUES ('2', '1', '女', 'ssex', 't_user');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('6', '0', '菜单', 'type', 't_menu');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('3', '2', '保密', 'ssex', 't_user');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('4', '1', '有效', 'status', 't_user');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('5', '0', '锁定', 'status', 't_user');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('1', '0', '男', 'ssex', 't_user');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('7', '1', '按钮', 'type', 't_menu');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('30', '0', '正常', 'status', 't_job');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('31', '1', '暂停', 'status', 't_job');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('32', '0', '成功', 'status', 't_job_log');
INSERT INTO "MRBIRD"."T_DICT" VALUES ('33', '1', '失败', 'status', 't_job_log');

-- ----------------------------
-- Table structure for T_JOB
-- ----------------------------
DROP TABLE "MRBIRD"."T_JOB";
CREATE TABLE "MRBIRD"."T_JOB" (
"JOB_ID" NUMBER NOT NULL ,
"BEAN_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"METHOD_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"PARAMS" VARCHAR2(200 BYTE) NULL ,
"CRON_EXPRESSION" VARCHAR2(100 BYTE) NOT NULL ,
"STATUS" CHAR(2 BYTE) NOT NULL ,
"REMARK" VARCHAR2(200 BYTE) NULL ,
"CREATE_TIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_JOB"."JOB_ID" IS '任务id';
COMMENT ON COLUMN "MRBIRD"."T_JOB"."BEAN_NAME" IS 'spring bean名称';
COMMENT ON COLUMN "MRBIRD"."T_JOB"."METHOD_NAME" IS '方法名';
COMMENT ON COLUMN "MRBIRD"."T_JOB"."PARAMS" IS '参数';
COMMENT ON COLUMN "MRBIRD"."T_JOB"."CRON_EXPRESSION" IS 'cron表达式';
COMMENT ON COLUMN "MRBIRD"."T_JOB"."STATUS" IS '任务状态  0：正常  1：暂停';
COMMENT ON COLUMN "MRBIRD"."T_JOB"."REMARK" IS '备注';
COMMENT ON COLUMN "MRBIRD"."T_JOB"."CREATE_TIME" IS '创建时间';

-- ----------------------------
-- Records of T_JOB
-- ----------------------------
INSERT INTO "MRBIRD"."T_JOB" VALUES ('3', 'testTask', 'test', 'hello world', '0/1 * * * * ?', '1 ', '有参任务调度测试,每隔一秒触发', TO_DATE('2018-02-26 09:28:26', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_JOB" VALUES ('1', 'testTask', 'test', 'mrbird', '0/1 * * * * ?', '1 ', '有参任务调度测试', TO_DATE('2018-02-24 16:26:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_JOB" VALUES ('2', 'testTask', 'test1', null, '0/10 * * * * ?', '1 ', '无参任务调度测试', TO_DATE('2018-02-24 17:06:23', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_JOB" VALUES ('11', 'testTask', 'test2', null, '0/5 * * * * ?', '1 ', '测试异常', TO_DATE('2018-02-26 11:15:30', 'YYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Table structure for T_JOB_LOG
-- ----------------------------
DROP TABLE "MRBIRD"."T_JOB_LOG";
CREATE TABLE "MRBIRD"."T_JOB_LOG" (
"LOG_ID" NUMBER NOT NULL ,
"JOB_ID" NUMBER NOT NULL ,
"BEAN_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"METHOD_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"PARAMS" VARCHAR2(200 BYTE) NULL ,
"STATUS" CHAR(2 BYTE) NOT NULL ,
"ERROR" VARCHAR2(2000 BYTE) NULL ,
"TIMES" NUMBER(11) NULL ,
"CREATE_TIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_JOB_LOG"."LOG_ID" IS '任务日志id';
COMMENT ON COLUMN "MRBIRD"."T_JOB_LOG"."JOB_ID" IS '任务id';
COMMENT ON COLUMN "MRBIRD"."T_JOB_LOG"."BEAN_NAME" IS 'spring bean名称';
COMMENT ON COLUMN "MRBIRD"."T_JOB_LOG"."METHOD_NAME" IS '方法名';
COMMENT ON COLUMN "MRBIRD"."T_JOB_LOG"."PARAMS" IS '参数';
COMMENT ON COLUMN "MRBIRD"."T_JOB_LOG"."STATUS" IS '任务状态    0：成功    1：失败';
COMMENT ON COLUMN "MRBIRD"."T_JOB_LOG"."ERROR" IS '失败信息';
COMMENT ON COLUMN "MRBIRD"."T_JOB_LOG"."TIMES" IS '耗时(单位：毫秒)';
COMMENT ON COLUMN "MRBIRD"."T_JOB_LOG"."CREATE_TIME" IS '创建时间';

-- ----------------------------
-- Records of T_JOB_LOG
-- ----------------------------
INSERT INTO "MRBIRD"."T_JOB_LOG" VALUES ('2394', '3', 'testTask', 'test', 'hello world', '0 ', null, '1', TO_DATE('2018-03-19 10:07:38', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_JOB_LOG" VALUES ('2395', '3', 'testTask', 'test', 'hello world', '0 ', null, '1', TO_DATE('2018-03-19 10:07:39', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_JOB_LOG" VALUES ('2396', '3', 'testTask', 'test', 'hello world', '0 ', null, '2', TO_DATE('2018-03-19 10:07:40', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_JOB_LOG" VALUES ('2398', '3', 'testTask', 'test', 'hello world', '0 ', null, '1', TO_DATE('2018-03-19 10:07:42', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_JOB_LOG" VALUES ('2392', '3', 'testTask', 'test', 'hello world', '0 ', null, '29', TO_DATE('2018-03-19 10:07:36', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_JOB_LOG" VALUES ('2393', '3', 'testTask', 'test', 'hello world', '0 ', null, '1', TO_DATE('2018-03-19 10:07:37', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_JOB_LOG" VALUES ('2397', '3', 'testTask', 'test', 'hello world', '0 ', null, '1', TO_DATE('2018-03-19 10:07:41', 'YYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Table structure for T_LOG
-- ----------------------------
DROP TABLE "MRBIRD"."T_LOG";
CREATE TABLE "MRBIRD"."T_LOG" (
"ID" NUMBER(20) NOT NULL ,
"USERNAME" VARCHAR2(50 BYTE) NULL ,
"OPERATION" VARCHAR2(500 BYTE) NULL ,
"TIME" NUMBER(11) NULL ,
"METHOD" VARCHAR2(4000 BYTE) NULL ,
"PARAMS" VARCHAR2(4000 BYTE) NULL ,
"IP" VARCHAR2(64 BYTE) NULL ,
"CREATE_TIME" DATE NULL ,
"LOCATION" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_LOG"."ID" IS '日志ID';
COMMENT ON COLUMN "MRBIRD"."T_LOG"."USERNAME" IS '操作用户';
COMMENT ON COLUMN "MRBIRD"."T_LOG"."OPERATION" IS '操作内容';
COMMENT ON COLUMN "MRBIRD"."T_LOG"."TIME" IS '耗时';
COMMENT ON COLUMN "MRBIRD"."T_LOG"."METHOD" IS '操作方法';
COMMENT ON COLUMN "MRBIRD"."T_LOG"."PARAMS" IS '方法参数';
COMMENT ON COLUMN "MRBIRD"."T_LOG"."IP" IS '操作人IP';
COMMENT ON COLUMN "MRBIRD"."T_LOG"."CREATE_TIME" IS '操作时间';
COMMENT ON COLUMN "MRBIRD"."T_LOG"."LOCATION" IS '操作地点';

-- ----------------------------
-- Records of T_LOG
-- ----------------------------
INSERT INTO "MRBIRD"."T_LOG" VALUES ('737', 'MrBird', '暂停任务', '11', 'cc.mrbird.job.controller.JobController.pauseJob()', 'jobIds: 1', '127.0.0.1', TO_DATE('2018-03-19 10:08:27', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_LOG" VALUES ('738', 'MrBird', '执行任务', '14', 'cc.mrbird.job.controller.JobController.runJob()', 'jobIds: 11', '127.0.0.1', TO_DATE('2018-03-19 10:08:34', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_LOG" VALUES ('745', 'MrBird', '删除用户', '117', 'cc.mrbird.system.controller.UserController.deleteUsers()', 'ids: 69,87,90,163', '127.0.0.1', TO_DATE('2018-03-19 10:38:19', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_LOG" VALUES ('746', 'MrBird', '删除用户', '8', 'cc.mrbird.system.controller.UserController.deleteUsers()', 'ids: 64', '127.0.0.1', TO_DATE('2018-03-19 10:38:25', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_LOG" VALUES ('769', 'MrBird', '新增菜单/按钮', '60', 'cc.mrbird.system.controller.MenuController.addMenu()', 'menu: cc.mrbird.system.domain.Menu@666d0d4e', '127.0.0.1', TO_DATE('2018-03-28 14:59:43', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('770', 'MrBird', '新增菜单/按钮', '3', 'cc.mrbird.system.controller.MenuController.addMenu()', 'menu: cc.mrbird.system.domain.Menu@16f7a296', '127.0.0.1', TO_DATE('2018-03-28 14:59:51', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('771', 'MrBird', '执行任务', '127', 'cc.mrbird.job.controller.JobController.runJob()', 'jobIds: 11', '127.0.0.1', TO_DATE('2018-03-28 15:00:06', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('772', 'MrBird', '删除用户', '12', 'cc.mrbird.system.controller.UserController.deleteUsers()', 'ids: 41,68,92,125,161,162,182,183', '127.0.0.1', TO_DATE('2018-04-02 17:05:50', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('773', 'MrBird', '删除角色', '51', 'cc.mrbird.system.controller.RoleController.deleteRoles()', 'ids: 84', '127.0.0.1', TO_DATE('2018-04-02 17:05:58', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('774', 'MrBird', '新增角色', '9', 'cc.mrbird.system.controller.RoleController.addRole()', 'role: cc.mrbird.system.domain.Role@3fbd43c3  menuId: [Ljava.lang.Long;@22abd7e6', '127.0.0.1', TO_DATE('2018-04-02 17:06:07', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('775', 'MrBird', '删除角色', '7', 'cc.mrbird.system.controller.RoleController.deleteRoles()', 'ids: 85', '127.0.0.1', TO_DATE('2018-04-02 17:06:13', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('776', 'MrBird', '删除菜单', '17', 'cc.mrbird.system.controller.MenuController.deleteMenus()', 'ids: 123,124', '127.0.0.1', TO_DATE('2018-04-02 17:07:29', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('767', 'MrBird', '新增用户', '10', 'cc.mrbird.system.controller.UserController.addUser()', 'user: cc.mrbird.system.domain.User@388a2201  roles: [Ljava.lang.Long;@74be8ca6', '127.0.0.1', TO_DATE('2018-03-28 14:49:58', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('768', 'MrBird', '新增角色', '32', 'cc.mrbird.system.controller.RoleController.addRole()', 'role: cc.mrbird.system.domain.Role@5de21ef7  menuId: [Ljava.lang.Long;@285f1a48', '127.0.0.1', TO_DATE('2018-03-28 14:59:33', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('777', 'MrBird', '新增菜单/按钮', '7', 'cc.mrbird.system.controller.MenuController.addMenu()', 'menu: cc.mrbird.system.domain.Menu@432c22c8', '127.0.0.1', TO_DATE('2018-04-02 17:08:19', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('778', 'MrBird', '删除菜单', '13', 'cc.mrbird.system.controller.MenuController.deleteMenus()', 'ids: 125', '127.0.0.1', TO_DATE('2018-04-02 17:08:24', 'YYYY-MM-DD HH24:MI:SS'), 'XX内网IP');
INSERT INTO "MRBIRD"."T_LOG" VALUES ('730', 'MrBird', '恢复任务', '55', 'cc.mrbird.job.controller.JobController.resumeJob()', 'jobIds: 3', '127.0.0.1', TO_DATE('2018-03-19 10:07:32', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_LOG" VALUES ('731', 'MrBird', '执行任务', '40', 'cc.mrbird.job.controller.JobController.runJob()', 'jobIds: 3', '127.0.0.1', TO_DATE('2018-03-19 10:07:36', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_LOG" VALUES ('733', 'MrBird', '暂停任务', '10', 'cc.mrbird.job.controller.JobController.pauseJob()', 'jobIds: 3', '127.0.0.1', TO_DATE('2018-03-19 10:07:53', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_LOG" VALUES ('734', 'MrBird', '恢复任务', '17', 'cc.mrbird.job.controller.JobController.resumeJob()', 'jobIds: 1', '127.0.0.1', TO_DATE('2018-03-19 10:08:02', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_LOG" VALUES ('735', 'MrBird', '执行任务', '13', 'cc.mrbird.job.controller.JobController.runJob()', 'jobIds: 1', '127.0.0.1', TO_DATE('2018-03-19 10:08:05', 'YYYY-MM-DD HH24:MI:SS'), null);

-- ----------------------------
-- Table structure for T_MENU
-- ----------------------------
DROP TABLE "MRBIRD"."T_MENU";
CREATE TABLE "MRBIRD"."T_MENU" (
"MENU_ID" NUMBER NOT NULL ,
"PARENT_ID" NUMBER NOT NULL ,
"MENU_NAME" VARCHAR2(50 BYTE) NOT NULL ,
"URL" VARCHAR2(100 BYTE) NULL ,
"PERMS" VARCHAR2(500 BYTE) NULL ,
"ICON" VARCHAR2(50 BYTE) NULL ,
"TYPE" CHAR(2 BYTE) NOT NULL ,
"ORDER_NUM" NUMBER NULL ,
"CREATE_TIME" DATE NOT NULL ,
"MODIFY_TIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_MENU"."MENU_ID" IS '菜单/按钮ID';
COMMENT ON COLUMN "MRBIRD"."T_MENU"."PARENT_ID" IS '上级菜单ID';
COMMENT ON COLUMN "MRBIRD"."T_MENU"."MENU_NAME" IS '菜单/按钮名称';
COMMENT ON COLUMN "MRBIRD"."T_MENU"."URL" IS '菜单URL';
COMMENT ON COLUMN "MRBIRD"."T_MENU"."PERMS" IS '权限标识';
COMMENT ON COLUMN "MRBIRD"."T_MENU"."ICON" IS '图标';
COMMENT ON COLUMN "MRBIRD"."T_MENU"."TYPE" IS '类型 0菜单 1按钮';
COMMENT ON COLUMN "MRBIRD"."T_MENU"."ORDER_NUM" IS '排序';
COMMENT ON COLUMN "MRBIRD"."T_MENU"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "MRBIRD"."T_MENU"."MODIFY_TIME" IS '修改时间';

-- ----------------------------
-- Records of T_MENU
-- ----------------------------
INSERT INTO "MRBIRD"."T_MENU" VALUES ('101', '0', '任务调度', null, null, 'zmdi zmdi-alarm', '0 ', null, TO_DATE('2018-02-24 15:52:57', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('86', '58', 'One 一个', null, null, null, '0 ', null, TO_DATE('2018-01-26 09:42:41', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-01-26 09:43:46', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('87', '86', '绘画', 'one/painting', 'one:painting', null, '0 ', null, TO_DATE('2018-01-26 09:47:14', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:39:31', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('88', '86', '语文', 'one/yuwen', 'one:yuwen', null, '0 ', null, TO_DATE('2018-01-26 09:47:40', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:39:40', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('89', '86', '散文', 'one/essay', 'one:essay', null, '0 ', null, TO_DATE('2018-01-26 09:48:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:39:50', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('81', '58', '影视资讯', null, null, null, '0 ', null, TO_DATE('2018-01-22 14:12:59', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('82', '81', '正在热映', 'movie/hot', 'movie:hot', null, '0 ', null, TO_DATE('2018-01-22 14:13:47', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:35:21', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('83', '81', '即将上映', 'movie/coming', 'movie:coming', null, '0 ', null, TO_DATE('2018-01-22 14:14:36', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:39:12', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('6', '1', '部门管理', 'dept', 'dept:list', null, '0 ', '4', TO_DATE('2017-12-27 16:57:33', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:34:17', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('8', '2', '在线用户', 'session', 'session:list', null, '0 ', '1', TO_DATE('2017-12-27 16:59:33', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:34:36', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('10', '2', '系统日志', 'log', 'log:list', null, '0 ', '3', TO_DATE('2017-12-27 17:00:50', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:34:46', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('20', '6', '新增部门', null, 'dept:add', null, '1 ', null, TO_DATE('2017-12-27 17:09:24', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('21', '6', '修改部门', null, 'dept:update', null, '1 ', null, TO_DATE('2017-12-27 17:09:24', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('22', '6', '删除部门', null, 'dept:delete', null, '1 ', null, TO_DATE('2017-12-27 17:09:24', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('24', '10', '删除日志', null, 'log:delete', null, '1 ', null, TO_DATE('2017-12-27 17:11:45', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('14', '4', '新增角色', null, 'role:add', null, '1 ', null, TO_DATE('2017-12-27 17:06:38', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('15', '4', '修改角色', null, 'role:update', null, '1 ', null, TO_DATE('2017-12-27 17:06:38', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('16', '4', '删除角色', null, 'role:delete', null, '1 ', null, TO_DATE('2017-12-27 17:06:38', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('1', '0', '系统管理', null, null, 'zmdi zmdi-settings', '0 ', '1', TO_DATE('2017-12-27 16:39:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('2', '0', '系统监控', null, null, 'zmdi zmdi-shield-security', '0 ', '2', TO_DATE('2017-12-27 16:45:51', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-01-17 17:08:28', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('3', '1', '用户管理', 'user', 'user:list', null, '0 ', '1', TO_DATE('2017-12-27 16:47:13', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:33:51', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('4', '1', '角色管理', 'role', 'role:list', null, '0 ', '2', TO_DATE('2017-12-27 16:48:09', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:34:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('5', '1', '菜单管理', 'menu', 'menu:list', null, '0 ', '3', TO_DATE('2017-12-27 16:48:57', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:34:09', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('11', '3', '新增用户', null, 'user:add', null, '1 ', null, TO_DATE('2017-12-27 17:02:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('12', '3', '修改用户', null, 'user:update', null, '1 ', null, TO_DATE('2017-12-27 17:04:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('13', '3', '删除用户', null, 'user:delete', null, '1 ', null, TO_DATE('2017-12-27 17:04:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('17', '5', '新增菜单', null, 'menu:add', null, '1 ', null, TO_DATE('2017-12-27 17:08:02', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('18', '5', '修改菜单', null, 'menu:update', null, '1 ', null, TO_DATE('2017-12-27 17:08:02', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('19', '5', '删除菜单', null, 'menu:delete', null, '1 ', null, TO_DATE('2017-12-27 17:08:02', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('23', '8', '踢出用户', null, 'user:kickout', null, '1 ', null, TO_DATE('2017-12-27 17:11:13', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('59', '58', '天气查询', 'weather', 'weather:list', null, '0 ', null, TO_DATE('2018-01-12 15:40:02', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:34:59', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('61', '58', '每日一文', 'article', 'article:list', null, '0 ', null, TO_DATE('2018-01-15 17:17:14', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:35:10', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('58', '0', '网络资源', null, null, 'zmdi zmdi-globe-alt', '0 ', null, TO_DATE('2018-01-12 15:28:48', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-01-22 19:49:26', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('65', '64', '新增字典', null, 'dict:add', null, '1 ', null, TO_DATE('2018-01-18 19:10:08', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('66', '64', '修改字典', null, 'dict:update', null, '1 ', null, TO_DATE('2018-01-18 19:10:27', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('67', '64', '删除字典', null, 'dict:delete', null, '1 ', null, TO_DATE('2018-01-18 19:10:47', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('64', '1', '字典管理', 'dict', 'dict:list', null, '0 ', null, TO_DATE('2018-01-18 10:38:25', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:34:25', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('102', '101', '定时任务', 'job', 'job:list', null, '0 ', null, TO_DATE('2018-02-24 15:53:53', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:40:01', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('103', '102', '新增任务', null, 'job:add', null, '1 ', null, TO_DATE('2018-02-24 15:55:10', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('104', '102', '修改任务', null, 'job:update', null, '1 ', null, TO_DATE('2018-02-24 15:55:53', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('105', '102', '删除任务', null, 'job:delete', null, '1 ', null, TO_DATE('2018-02-24 15:56:18', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('106', '102', '暂停任务', null, 'job:pause', null, '1 ', null, TO_DATE('2018-02-24 15:57:08', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('107', '102', '恢复任务', null, 'job:resume', null, '1 ', null, TO_DATE('2018-02-24 15:58:21', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('108', '102', '立即执行任务', null, 'job:run', null, '1 ', null, TO_DATE('2018-02-24 15:59:45', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_MENU" VALUES ('109', '101', '调度日志', 'jobLog', 'jobLog:list', null, '0 ', null, TO_DATE('2018-02-24 16:00:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-25 09:40:16', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_MENU" VALUES ('110', '109', '删除日志', null, 'jobLog:delete', null, '1 ', null, TO_DATE('2018-02-24 16:01:21', 'YYYY-MM-DD HH24:MI:SS'), null);

-- ----------------------------
-- Table structure for T_ROLE
-- ----------------------------
DROP TABLE "MRBIRD"."T_ROLE";
CREATE TABLE "MRBIRD"."T_ROLE" (
"ROLE_ID" NUMBER NOT NULL ,
"ROLE_NAME" VARCHAR2(100 BYTE) NOT NULL ,
"REMARK" VARCHAR2(100 BYTE) NULL ,
"CREATE_TIME" DATE NOT NULL ,
"MODIFY_TIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_ROLE"."ROLE_ID" IS '角色ID';
COMMENT ON COLUMN "MRBIRD"."T_ROLE"."ROLE_NAME" IS '角色名称';
COMMENT ON COLUMN "MRBIRD"."T_ROLE"."REMARK" IS '角色描述';
COMMENT ON COLUMN "MRBIRD"."T_ROLE"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "MRBIRD"."T_ROLE"."MODIFY_TIME" IS '修改时间';

-- ----------------------------
-- Records of T_ROLE
-- ----------------------------
INSERT INTO "MRBIRD"."T_ROLE" VALUES ('23', '用户管理员', '负责用户的增删改操作', TO_DATE('2018-01-09 15:32:41', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_ROLE" VALUES ('1', '管理员', '管理员', TO_DATE('2017-12-27 16:23:11', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-02-24 16:01:45', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_ROLE" VALUES ('2', '测试账号', '测试账号', TO_DATE('2017-12-27 16:25:09', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-01-23 09:11:11', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_ROLE" VALUES ('3', '注册账户', '注册账户，只可查看，不可操作', TO_DATE('2017-12-29 16:00:15', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-02-24 17:33:45', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_ROLE" VALUES ('24', '系统监控员', '可查看系统监控信息，但不可操作', TO_DATE('2018-01-09 15:52:01', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-07 19:05:33', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_ROLE" VALUES ('25', '用户查看', '查看用户，无相应操作权限', TO_DATE('2018-01-09 15:56:30', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_ROLE" VALUES ('63', '影院工作者', '可查看影视信息', TO_DATE('2018-02-06 08:48:28', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-07 19:05:26', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "MRBIRD"."T_ROLE" VALUES ('64', '天气预报员', '可查看天气预报信息', TO_DATE('2018-02-27 08:47:04', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "MRBIRD"."T_ROLE" VALUES ('65', '文章审核', '文章类', TO_DATE('2018-02-27 08:48:01', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-13 11:20:34', 'YYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Table structure for T_ROLE_MENU
-- ----------------------------
DROP TABLE "MRBIRD"."T_ROLE_MENU";
CREATE TABLE "MRBIRD"."T_ROLE_MENU" (
"ROLE_ID" NUMBER NOT NULL ,
"MENU_ID" NUMBER NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_ROLE_MENU"."ROLE_ID" IS '角色ID';
COMMENT ON COLUMN "MRBIRD"."T_ROLE_MENU"."MENU_ID" IS '按钮ID';

-- ----------------------------
-- Records of T_ROLE_MENU
-- ----------------------------
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '58');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '59');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '61');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '81');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '82');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '83');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '86');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '87');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '88');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '89');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '1');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '3');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '4');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '5');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '6');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '64');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '2');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '8');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '10');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '101');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '102');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('3', '109');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('63', '58');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('63', '81');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('63', '82');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('63', '83');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('24', '8');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('24', '2');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('24', '10');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('65', '86');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('65', '88');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('65', '89');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('65', '58');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('65', '61');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '81');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '61');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '24');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '82');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '83');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '58');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '59');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '2');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '8');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('2', '10');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('23', '11');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('23', '12');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('23', '13');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('23', '3');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('23', '1');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('25', '1');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('25', '3');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '59');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '2');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '3');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '67');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '1');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '4');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '5');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '6');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '20');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '21');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '22');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '10');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '8');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '58');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '66');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '11');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '12');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '64');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '13');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '14');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '65');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '15');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '16');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '17');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '18');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '23');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '81');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '82');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '83');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '19');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '24');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '61');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '86');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '87');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '88');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '89');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '101');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '102');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '103');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '104');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '105');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '106');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '107');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '108');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '109');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('1', '110');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('64', '59');
INSERT INTO "MRBIRD"."T_ROLE_MENU" VALUES ('64', '58');

-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
DROP TABLE "MRBIRD"."T_USER";
CREATE TABLE "MRBIRD"."T_USER" (
"USER_ID" NUMBER NOT NULL ,
"USERNAME" VARCHAR2(50 BYTE) NOT NULL ,
"PASSWORD" VARCHAR2(128 BYTE) NOT NULL ,
"DEPT_ID" NUMBER NULL ,
"EMAIL" VARCHAR2(128 BYTE) NULL ,
"MOBILE" VARCHAR2(20 BYTE) NULL ,
"STATUS" CHAR(1 BYTE) NOT NULL ,
"CRATE_TIME" DATE NOT NULL ,
"MODIFY_TIME" DATE NULL ,
"LAST_LOGIN_TIME" DATE NULL ,
"SSEX" CHAR(1 BYTE) NULL ,
"THEME" VARCHAR2(10 BYTE) NULL ,
"AVATAR" VARCHAR2(100 BYTE) NULL ,
"DESCRIPTION" VARCHAR2(100 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_USER"."USER_ID" IS '用户ID';
COMMENT ON COLUMN "MRBIRD"."T_USER"."USERNAME" IS '用户名称';
COMMENT ON COLUMN "MRBIRD"."T_USER"."PASSWORD" IS '密码';
COMMENT ON COLUMN "MRBIRD"."T_USER"."DEPT_ID" IS '部门ID';
COMMENT ON COLUMN "MRBIRD"."T_USER"."EMAIL" IS '邮箱';
COMMENT ON COLUMN "MRBIRD"."T_USER"."MOBILE" IS '联系电话';
COMMENT ON COLUMN "MRBIRD"."T_USER"."STATUS" IS '状态 0锁定 1有效';
COMMENT ON COLUMN "MRBIRD"."T_USER"."CRATE_TIME" IS '创建时间';
COMMENT ON COLUMN "MRBIRD"."T_USER"."MODIFY_TIME" IS '修改时间';
COMMENT ON COLUMN "MRBIRD"."T_USER"."LAST_LOGIN_TIME" IS '最近访问时间';
COMMENT ON COLUMN "MRBIRD"."T_USER"."SSEX" IS '性别 0男 1女';
COMMENT ON COLUMN "MRBIRD"."T_USER"."THEME" IS '主题';
COMMENT ON COLUMN "MRBIRD"."T_USER"."AVATAR" IS '头像';
COMMENT ON COLUMN "MRBIRD"."T_USER"."DESCRIPTION" IS '描述';

-- ----------------------------
-- Records of T_USER
-- ----------------------------
INSERT INTO "MRBIRD"."T_USER" VALUES ('4', 'MrBird', '42ee25d1e43e9f57119a00d0a39e5250', '1', '852252812@qq.com', '17720888889', '1', TO_DATE('2017-12-27 15:47:19', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-01 16:07:39', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-04-02 17:05:11', 'YYYY-MM-DD HH24:MI:SS'), '2', 'green', 'default.jpg', '我就是我 颜色不一样的烟火...');
INSERT INTO "MRBIRD"."T_USER" VALUES ('6', 'tester', '243e29429b340192700677d48c09d992', '6', 'tester@qq.com', '13888888888', '1', TO_DATE('2017-12-27 17:35:14', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-01 16:52:30', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-01-23 09:17:27', 'YYYY-MM-DD HH24:MI:SS'), '1', 'teal', 'default.jpg', null);
INSERT INTO "MRBIRD"."T_USER" VALUES ('23', 'scott', 'ac3af72d9f95161a502fd326865c2f15', '6', 'scott@qq.com', '15134627389', '1', TO_DATE('2017-12-29 16:16:39', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-01 16:11:33', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-19 14:14:35', 'YYYY-MM-DD HH24:MI:SS'), '1', 'blue-grey', 'default.jpg', '我是scott');
INSERT INTO "MRBIRD"."T_USER" VALUES ('24', 'smith', '228208eafc74e48c44619cc543fc0efe', '3', 'smith@qq.com', '13364754932', '1', TO_DATE('2017-12-29 16:21:31', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-02-27 08:48:16', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-02-27 08:48:27', 'YYYY-MM-DD HH24:MI:SS'), '1', 'teal', 'default.jpg', null);
INSERT INTO "MRBIRD"."T_USER" VALUES ('25', 'allen', '83baac97928a113986054efacaeec1d2', '3', 'allen@qq.com', '13427374857', '0', TO_DATE('2017-12-29 16:21:54', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-01-17 11:28:16', 'YYYY-MM-DD HH24:MI:SS'), null, '1', 'indigo', 'default.jpg', null);
INSERT INTO "MRBIRD"."T_USER" VALUES ('26', 'martin', 'b26c9edca9a61016bca1f6fb042e679e', '4', 'martin@qq.com', '15562736678', '1', TO_DATE('2017-12-29 16:22:24', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-01-25 09:23:15', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-01-25 17:24:50', 'YYYY-MM-DD HH24:MI:SS'), '1', 'teal', 'default.jpg', null);
INSERT INTO "MRBIRD"."T_USER" VALUES ('27', 'ford', '0448f0dcfd856b0e831842072b532141', '6', 'ford@qq.com', '15599998373', '0', TO_DATE('2017-12-29 16:22:52', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-13 11:19:56', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-08 16:31:59', 'YYYY-MM-DD HH24:MI:SS'), '0', 'cyan', 'default.jpg', null);
INSERT INTO "MRBIRD"."T_USER" VALUES ('91', '系统监控员', '7c28d1cd33414ac15832f7be92668b7a', '6', 'xtjk@qq.com', '18088736652', '1', TO_DATE('2018-01-09 15:52:56', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2018-01-09 15:53:12', 'YYYY-MM-DD HH24:MI:SS'), '0', 'cyan', 'default.jpg', null);

-- ----------------------------
-- Table structure for T_USER_ROLE
-- ----------------------------
DROP TABLE "MRBIRD"."T_USER_ROLE";
CREATE TABLE "MRBIRD"."T_USER_ROLE" (
"USER_ID" NUMBER NOT NULL ,
"ROLE_ID" NUMBER NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MRBIRD"."T_USER_ROLE"."USER_ID" IS '用户ID';
COMMENT ON COLUMN "MRBIRD"."T_USER_ROLE"."ROLE_ID" IS '角色ID';

-- ----------------------------
-- Records of T_USER_ROLE
-- ----------------------------
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('27', '3');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('24', '65');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('4', '1');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('23', '3');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('23', '24');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('23', '25');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('26', '3');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('26', '23');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('26', '24');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('25', '3');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('91', '24');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('165', '3');
INSERT INTO "MRBIRD"."T_USER_ROLE" VALUES ('6', '2');

-- ----------------------------
-- Indexes structure for table T_DEPT
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_DEPT
-- ----------------------------
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DEPT" ADD CHECK ("DEPT_NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_DEPT
-- ----------------------------
ALTER TABLE "MRBIRD"."T_DEPT" ADD PRIMARY KEY ("DEPT_ID");

-- ----------------------------
-- Indexes structure for table T_DICT
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_DICT
-- ----------------------------
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("DICT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("KEY" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("VALUE" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("FIELD_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("TABLE_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("DICT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("KEY" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("VALUE" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("FIELD_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("TABLE_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("DICT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("KEY" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("VALUE" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("FIELD_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_DICT" ADD CHECK ("TABLE_NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_DICT
-- ----------------------------
ALTER TABLE "MRBIRD"."T_DICT" ADD PRIMARY KEY ("DICT_ID");

-- ----------------------------
-- Indexes structure for table T_JOB
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_JOB
-- ----------------------------
ALTER TABLE "MRBIRD"."T_JOB" ADD CHECK ("JOB_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_JOB" ADD CHECK ("BEAN_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_JOB" ADD CHECK ("METHOD_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_JOB" ADD CHECK ("CRON_EXPRESSION" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_JOB" ADD CHECK ("STATUS" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_JOB
-- ----------------------------
ALTER TABLE "MRBIRD"."T_JOB" ADD PRIMARY KEY ("JOB_ID");

-- ----------------------------
-- Indexes structure for table T_JOB_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_JOB_LOG
-- ----------------------------
ALTER TABLE "MRBIRD"."T_JOB_LOG" ADD CHECK ("LOG_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_JOB_LOG" ADD CHECK ("JOB_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_JOB_LOG" ADD CHECK ("BEAN_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_JOB_LOG" ADD CHECK ("METHOD_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_JOB_LOG" ADD CHECK ("STATUS" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_JOB_LOG
-- ----------------------------
ALTER TABLE "MRBIRD"."T_JOB_LOG" ADD PRIMARY KEY ("LOG_ID");

-- ----------------------------
-- Indexes structure for table T_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_LOG
-- ----------------------------
ALTER TABLE "MRBIRD"."T_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_LOG" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_LOG
-- ----------------------------
ALTER TABLE "MRBIRD"."T_LOG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table T_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_MENU
-- ----------------------------
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("MENU_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("TYPE" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("CREATE_TIME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("MENU_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("TYPE" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("CREATE_TIME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("MENU_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("TYPE" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("CREATE_TIME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("MENU_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("TYPE" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("CREATE_TIME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_MENU
-- ----------------------------
ALTER TABLE "MRBIRD"."T_MENU" ADD PRIMARY KEY ("MENU_ID");

-- ----------------------------
-- Indexes structure for table T_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_ROLE
-- ----------------------------
ALTER TABLE "MRBIRD"."T_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_ROLE" ADD CHECK ("ROLE_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_ROLE" ADD CHECK ("CREATE_TIME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_ROLE" ADD CHECK ("ROLE_NAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_ROLE" ADD CHECK ("CREATE_TIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_ROLE
-- ----------------------------
ALTER TABLE "MRBIRD"."T_ROLE" ADD PRIMARY KEY ("ROLE_ID");

-- ----------------------------
-- Checks structure for table T_ROLE_MENU
-- ----------------------------
ALTER TABLE "MRBIRD"."T_ROLE_MENU" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_ROLE_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_ROLE_MENU" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_ROLE_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);

-- ----------------------------
-- Indexes structure for table T_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_USER
-- ----------------------------
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("USERNAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("CRATE_TIME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("USERNAME" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER" ADD CHECK ("CRATE_TIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_USER
-- ----------------------------
ALTER TABLE "MRBIRD"."T_USER" ADD PRIMARY KEY ("USER_ID");

-- ----------------------------
-- Checks structure for table T_USER_ROLE
-- ----------------------------
ALTER TABLE "MRBIRD"."T_USER_ROLE" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER_ROLE" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "MRBIRD"."T_USER_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);

-- ----------------------------
-- Sequence structure for SEQ_DEPT
-- ----------------------------
DROP SEQUENCE "MRBIRD"."SEQ_DEPT";
CREATE SEQUENCE "MRBIRD"."SEQ_DEPT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 163
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_DICT
-- ----------------------------
DROP SEQUENCE "MRBIRD"."SEQ_DICT";
CREATE SEQUENCE "MRBIRD"."SEQ_DICT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 50
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_JOB
-- ----------------------------
DROP SEQUENCE "MRBIRD"."SEQ_JOB";
CREATE SEQUENCE "MRBIRD"."SEQ_JOB"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 21
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_JOB_LOG
-- ----------------------------
DROP SEQUENCE "MRBIRD"."SEQ_JOB_LOG";
CREATE SEQUENCE "MRBIRD"."SEQ_JOB_LOG"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 2441
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_LOG
-- ----------------------------
DROP SEQUENCE "MRBIRD"."SEQ_LOG";
CREATE SEQUENCE "MRBIRD"."SEQ_LOG"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 795
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_MENU
-- ----------------------------
DROP SEQUENCE "MRBIRD"."SEQ_MENU";
CREATE SEQUENCE "MRBIRD"."SEQ_MENU"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 141
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_ROLE
-- ----------------------------
DROP SEQUENCE "MRBIRD"."SEQ_ROLE";
CREATE SEQUENCE "MRBIRD"."SEQ_ROLE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 104
 CACHE 20;

-- ----------------------------
-- Sequence structure for SEQ_USER
-- ----------------------------
DROP SEQUENCE "MRBIRD"."SEQ_USER";
CREATE SEQUENCE "MRBIRD"."SEQ_USER"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 202
 CACHE 20;


delete from qrtz_fired_triggers;
delete from qrtz_simple_triggers;
delete from qrtz_simprop_triggers;
delete from qrtz_cron_triggers;
delete from qrtz_blob_triggers;
delete from qrtz_triggers;
delete from qrtz_job_details;
delete from qrtz_calendars;
delete from qrtz_paused_trigger_grps;
delete from qrtz_locks;
delete from qrtz_scheduler_state;

drop table qrtz_calendars;
drop table qrtz_fired_triggers;
drop table qrtz_blob_triggers;
drop table qrtz_cron_triggers;
drop table qrtz_simple_triggers;
drop table qrtz_simprop_triggers;
drop table qrtz_triggers;
drop table qrtz_job_details;
drop table qrtz_paused_trigger_grps;
drop table qrtz_locks;
drop table qrtz_scheduler_state;


CREATE TABLE qrtz_job_details
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    JOB_NAME  VARCHAR2(200) NOT NULL,
    JOB_GROUP VARCHAR2(200) NOT NULL,
    DESCRIPTION VARCHAR2(250) NULL,
    JOB_CLASS_NAME   VARCHAR2(250) NOT NULL, 
    IS_DURABLE VARCHAR2(1) NOT NULL,
    IS_NONCONCURRENT VARCHAR2(1) NOT NULL,
    IS_UPDATE_DATA VARCHAR2(1) NOT NULL,
    REQUESTS_RECOVERY VARCHAR2(1) NOT NULL,
    JOB_DATA BLOB NULL,
    CONSTRAINT QRTZ_JOB_DETAILS_PK PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
);
CREATE TABLE qrtz_triggers
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    JOB_NAME  VARCHAR2(200) NOT NULL, 
    JOB_GROUP VARCHAR2(200) NOT NULL,
    DESCRIPTION VARCHAR2(250) NULL,
    NEXT_FIRE_TIME NUMBER(13) NULL,
    PREV_FIRE_TIME NUMBER(13) NULL,
    PRIORITY NUMBER(13) NULL,
    TRIGGER_STATE VARCHAR2(16) NOT NULL,
    TRIGGER_TYPE VARCHAR2(8) NOT NULL,
    START_TIME NUMBER(13) NOT NULL,
    END_TIME NUMBER(13) NULL,
    CALENDAR_NAME VARCHAR2(200) NULL,
    MISFIRE_INSTR NUMBER(2) NULL,
    JOB_DATA BLOB NULL,
    CONSTRAINT QRTZ_TRIGGERS_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT QRTZ_TRIGGER_TO_JOBS_FK FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP) 
      REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP) 
);
CREATE TABLE qrtz_simple_triggers
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    REPEAT_COUNT NUMBER(7) NOT NULL,
    REPEAT_INTERVAL NUMBER(12) NOT NULL,
    TIMES_TRIGGERED NUMBER(10) NOT NULL,
    CONSTRAINT QRTZ_SIMPLE_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT QRTZ_SIMPLE_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
	REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_cron_triggers
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    CRON_EXPRESSION VARCHAR2(120) NOT NULL,
    TIME_ZONE_ID VARCHAR2(80),
    CONSTRAINT QRTZ_CRON_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT QRTZ_CRON_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
      REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_simprop_triggers
  (          
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    STR_PROP_1 VARCHAR2(512) NULL,
    STR_PROP_2 VARCHAR2(512) NULL,
    STR_PROP_3 VARCHAR2(512) NULL,
    INT_PROP_1 NUMBER(10) NULL,
    INT_PROP_2 NUMBER(10) NULL,
    LONG_PROP_1 NUMBER(13) NULL,
    LONG_PROP_2 NUMBER(13) NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR2(1) NULL,
    BOOL_PROP_2 VARCHAR2(1) NULL,
    CONSTRAINT QRTZ_SIMPROP_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT QRTZ_SIMPROP_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
      REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_blob_triggers
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    BLOB_DATA BLOB NULL,
    CONSTRAINT QRTZ_BLOB_TRIG_PK PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    CONSTRAINT QRTZ_BLOB_TRIG_TO_TRIG_FK FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) 
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_calendars
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    CALENDAR_NAME  VARCHAR2(200) NOT NULL, 
    CALENDAR BLOB NOT NULL,
    CONSTRAINT QRTZ_CALENDARS_PK PRIMARY KEY (SCHED_NAME,CALENDAR_NAME)
);
CREATE TABLE qrtz_paused_trigger_grps
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    TRIGGER_GROUP  VARCHAR2(200) NOT NULL, 
    CONSTRAINT QRTZ_PAUSED_TRIG_GRPS_PK PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP)
);
CREATE TABLE qrtz_fired_triggers 
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    ENTRY_ID VARCHAR2(95) NOT NULL,
    TRIGGER_NAME VARCHAR2(200) NOT NULL,
    TRIGGER_GROUP VARCHAR2(200) NOT NULL,
    INSTANCE_NAME VARCHAR2(200) NOT NULL,
    FIRED_TIME NUMBER(13) NOT NULL,
    SCHED_TIME NUMBER(13) NOT NULL,
    PRIORITY NUMBER(13) NOT NULL,
    STATE VARCHAR2(16) NOT NULL,
    JOB_NAME VARCHAR2(200) NULL,
    JOB_GROUP VARCHAR2(200) NULL,
    IS_NONCONCURRENT VARCHAR2(1) NULL,
    REQUESTS_RECOVERY VARCHAR2(1) NULL,
    CONSTRAINT QRTZ_FIRED_TRIGGER_PK PRIMARY KEY (SCHED_NAME,ENTRY_ID)
);
CREATE TABLE qrtz_scheduler_state 
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    INSTANCE_NAME VARCHAR2(200) NOT NULL,
    LAST_CHECKIN_TIME NUMBER(13) NOT NULL,
    CHECKIN_INTERVAL NUMBER(13) NOT NULL,
    CONSTRAINT QRTZ_SCHEDULER_STATE_PK PRIMARY KEY (SCHED_NAME,INSTANCE_NAME)
);
CREATE TABLE qrtz_locks
  (
    SCHED_NAME VARCHAR2(120) NOT NULL,
    LOCK_NAME  VARCHAR2(40) NOT NULL, 
    CONSTRAINT QRTZ_LOCKS_PK PRIMARY KEY (SCHED_NAME,LOCK_NAME)
);

create index idx_qrtz_j_req_recovery on qrtz_job_details(SCHED_NAME,REQUESTS_RECOVERY);
create index idx_qrtz_j_grp on qrtz_job_details(SCHED_NAME,JOB_GROUP);

create index idx_qrtz_t_j on qrtz_triggers(SCHED_NAME,JOB_NAME,JOB_GROUP);
create index idx_qrtz_t_jg on qrtz_triggers(SCHED_NAME,JOB_GROUP);
create index idx_qrtz_t_c on qrtz_triggers(SCHED_NAME,CALENDAR_NAME);
create index idx_qrtz_t_g on qrtz_triggers(SCHED_NAME,TRIGGER_GROUP);
create index idx_qrtz_t_state on qrtz_triggers(SCHED_NAME,TRIGGER_STATE);
create index idx_qrtz_t_n_state on qrtz_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE);
create index idx_qrtz_t_n_g_state on qrtz_triggers(SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE);
create index idx_qrtz_t_next_fire_time on qrtz_triggers(SCHED_NAME,NEXT_FIRE_TIME);
create index idx_qrtz_t_nft_st on qrtz_triggers(SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME);
create index idx_qrtz_t_nft_misfire on qrtz_triggers(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME);
create index idx_qrtz_t_nft_st_misfire on qrtz_triggers(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE);
create index idx_qrtz_t_nft_st_misfire_grp on qrtz_triggers(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE);

create index idx_qrtz_ft_trig_inst_name on qrtz_fired_triggers(SCHED_NAME,INSTANCE_NAME);
create index idx_qrtz_ft_inst_job_req_rcvry on qrtz_fired_triggers(SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY);
create index idx_qrtz_ft_j_g on qrtz_fired_triggers(SCHED_NAME,JOB_NAME,JOB_GROUP);
create index idx_qrtz_ft_jg on qrtz_fired_triggers(SCHED_NAME,JOB_GROUP);
create index idx_qrtz_ft_t_g on qrtz_fired_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
create index idx_qrtz_ft_tg on qrtz_fired_triggers(SCHED_NAME,TRIGGER_GROUP);




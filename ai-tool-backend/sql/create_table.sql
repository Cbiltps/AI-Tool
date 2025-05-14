# 数据库初始化
# @author
# @from

-- 创建库
create database if not exists ai_tool;

-- 切换库
use ai_tool;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    unionId      varchar(256)                           null comment '微信开放平台id',
    mpOpenId     varchar(256)                           null comment '公众号openId',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    index idx_unionId (unionId)
) comment '用户' collate = utf8mb4_unicode_ci;

-- 应用表
create table if not exists app
(
    id            bigint auto_increment comment 'id' primary key,
    appName       varchar(128)                       not null comment '应用名',
    appDesc       varchar(2048)                      null comment '应用描述',
    appIcon       varchar(1024)                      null comment '应用图标',
    appType       tinyint  default 0                 not null comment '应用类型',
    appLink       varchar(1024)                      null null comment '应用地址',
    reviewStatus  int      default 0                 not null comment '审核状态：0-待审核, 1-通过, 2-拒绝',
    reviewMessage varchar(512)                       null comment '审核信息',
    reviewerId    bigint                             null comment '审核人 id',
    reviewTime    datetime                           null comment '审核时间',
    userId        bigint                             not null comment '创建用户 id',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除',
    index idx_appName (appName)
) comment '应用' collate = utf8mb4_unicode_ci;

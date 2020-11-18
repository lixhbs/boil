-- drop table task
CREATE TABLE task
(
    id            INT NOT NULL AUTO_INCREMENT COMMENT 'id',
    created_by    VARCHAR(32) COMMENT '创建人',
    created_time  DATETIME COMMENT '创建时间',
    updated_by    VARCHAR(32) COMMENT '更新人',
    updated_time  DATETIME COMMENT '更新时间',
    untitled      VARCHAR(32) COMMENT '发布人',
    receiver_wxid VARCHAR(32) COMMENT '执行人微信id',
    name          VARCHAR(32) COMMENT '执行人',
    content       VARCHAR(3072) COMMENT '内容',
    deadline      DATE COMMENT '截止日期',
    status        INT COMMENT '状态',
    PRIMARY KEY (id)
) COMMENT = ' ';

CREATE TABLE robot
(
    id           INT NOT NULL AUTO_INCREMENT COMMENT 'id',
    created_by   VARCHAR(32) COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   VARCHAR(32) COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    wxid         VARCHAR(32) COMMENT 'wxid',
    headimgurl   VARCHAR(1024) COMMENT '头像',
    wx_num       VARCHAR(32) COMMENT '微信号',
    PRIMARY KEY (id)
) COMMENT = ' ';

CREATE TABLE timedtask
(
    id           INT NOT NULL AUTO_INCREMENT COMMENT 'id',
    created_by   VARCHAR(32) COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    updated_by   VARCHAR(32) COMMENT '更新人',
    updated_time DATETIME COMMENT '更新时间',
    name         VARCHAR(32) COMMENT '名称',
    cycletype    INT DEFAULT 1 COMMENT '循环类型 1、天；2、周；3、月；4、年',
    datetype     INT DEFAULT 2 COMMENT '日期类型 1、每天；2、工作日',
    someday      INT DEFAULT 5 COMMENT '每周的哪一天 1234567',
    startingtime INT DEFAULT 18 COMMENT '开始时间 1~24',
    groupnum     VARCHAR(32) COMMENT '群号',
    lasttime     VARCHAR(32) COMMENT '最后一次执行时间',
    success      INT COMMENT '执行成功次数',
    failed       INT COMMENT '执行失败次数',
    PRIMARY KEY (id)
) COMMENT = ' ';
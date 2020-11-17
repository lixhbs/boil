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
/*webservice_invoke_failure_log加字段internal_requestbody_class */
alter table webservice_invoke_failure_log
    add internal_requestbody_class varchar(255) DEFAULT NULL COMMENT '内部请求真实body类名全称';
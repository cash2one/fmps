/*webservice_invoke_failure_log���ֶ�internal_requestbody_class */
alter table webservice_invoke_failure_log
    add internal_requestbody_class varchar(255) DEFAULT NULL COMMENT '�ڲ�������ʵbody����ȫ��';
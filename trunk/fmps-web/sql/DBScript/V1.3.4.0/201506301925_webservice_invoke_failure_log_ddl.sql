/*webservice_invoke_failure_logɾ�ֶ� internal_requestbody_class */
alter table webservice_invoke_failure_log drop column internal_requestbody_class;

/*webservice_invoke_failure_log���ֶ� internal_request_obj */
alter table webservice_invoke_failure_log
    add internal_request_obj blob DEFAULT NULL COMMENT '���л��ڲ���';
--扩充报文字段长度
alter table weixin_transaction_record modify column internalResponse varchar(5100);
alter table weixin_transaction_record modify column externalResponse varchar(5100);
alter table webservice_invoke_failure_log modify column internal_response varchar(5100);
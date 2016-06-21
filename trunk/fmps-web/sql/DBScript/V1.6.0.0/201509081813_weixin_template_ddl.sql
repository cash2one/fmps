alter table weixin_template CHANGE weixin_template_id template_id varchar(50)
comment '微信端下发的模板ID，删除微信端模板后会变更';

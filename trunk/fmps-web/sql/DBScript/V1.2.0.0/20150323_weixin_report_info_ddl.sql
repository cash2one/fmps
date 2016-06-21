/**weixin_report_info表加claimConsumeTime理赔耗时字段**/
alter table weixin_report_info
    add claimConsumeTime int NULL DEFAULT NULL COMMENT '理赔耗时(核赔结束时间减报案时间 单位:秒)';


/**修改weixin_report_info表的caseStatus字段备注**/
ALTER TABLE weixin_report_info 
MODIFY COLUMN caseStatus varchar(3) NOT NULL 
COMMENT '案件状态 1:未结案;2:已结案,缺材料;100:查看调度改派修改理赔方式;110:核赔提交;';

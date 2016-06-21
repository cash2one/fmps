CREATE TABLE `weixin_notcar_report_info` (
	`ID` VARCHAR(32) NOT NULL COMMENT '主键',
	`registNo` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '报案号',
	`policyNo` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '保单号',
	`insuredName` VARCHAR(50) NULL DEFAULT NULL COMMENT '被保险人名称 ',
	`reportorName` VARCHAR(50) NULL DEFAULT NULL COMMENT '报案人名称 ',
	`reportDate` VARCHAR(20) NULL DEFAULT NULL COMMENT '报案日期 YYYY-MM-DD',
	`reportTime` VARCHAR(20) NULL DEFAULT NULL COMMENT '报案时间 HH24:MM:SS',
	`startDate` VARCHAR(20) NULL DEFAULT NULL COMMENT '起保日期 YYYY-MM-DD',
	`endDate` VARCHAR(20) NULL DEFAULT NULL COMMENT '终保日期 YYYY-MM-DD',
	`remark` VARCHAR(500) NULL DEFAULT NULL COMMENT '出险摘要',
	`caseStatus` TINYINT(3) NOT NULL COMMENT '1:未结案;2:已结案，缺材料;100:查看调度改派修改理赔方式;110:核赔提交;111-案件注销;112-案件零结',
	PRIMARY KEY (`ID`),
	INDEX `registNo` (`registNo`)
)
COMMENT='微信非车报案信息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

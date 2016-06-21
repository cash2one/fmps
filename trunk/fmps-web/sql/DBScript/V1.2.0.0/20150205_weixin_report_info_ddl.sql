CREATE TABLE `weixin_report_info` (
	`ID` VARCHAR(32) NOT NULL COMMENT '主键',
	`registNo` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '报案号',
	`reportorName` VARCHAR(50) NULL DEFAULT NULL COMMENT '报案人名称 ',
	`licenseNo` VARCHAR(20) NULL DEFAULT NULL COMMENT '车牌号',
	`reportDate` VARCHAR(20) NULL DEFAULT NULL COMMENT '报案日期 YYYY-MM-DD',
	`reportTime` VARCHAR(20) NULL DEFAULT NULL COMMENT '报案时间 HH24:MM:SS',
	`operatorCode` VARCHAR(15) NULL DEFAULT NULL COMMENT '理赔人员工号',
	`certiMaterialType` VARCHAR(200) NULL DEFAULT NULL COMMENT '欠缺材料类型',
	`remark` VARCHAR(500) NULL DEFAULT NULL COMMENT '出险摘要',
	`caseStatus` VARCHAR(3) NOT NULL COMMENT '案件状态 1:未结案;2:已结案,缺材料;100:查看调度改派修改理赔方式;110:核赔提交;',
	`newCarFlag` VARCHAR(5) NULL DEFAULT NULL COMMENT '是否新车 1：是 0：否',
	`openid` VARCHAR(100) NULL DEFAULT NULL COMMENT 'openid',
	`nickname` VARCHAR(100) NULL DEFAULT NULL COMMENT '昵称',
	`headimgurl` VARCHAR(255) NULL DEFAULT NULL COMMENT '用户头像',
	`sessionState` VARCHAR(5) NULL DEFAULT NULL COMMENT '会话状态  1:会话中;0:结束会话',
	`messageTotal` VARCHAR(5) NULL DEFAULT NULL COMMENT '未读消息数量',
	`phoneNumber` VARCHAR(20) NULL DEFAULT NULL COMMENT '报案电话',
	`underwritingTime` TIMESTAMP NULL DEFAULT NULL COMMENT '核赔结束时间',
	PRIMARY KEY (`ID`),
	INDEX `Index` (`registNo`)
)
COMMENT='微信报案信息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE weixin_policy_clause_reading (
	id VARCHAR(32) NOT NULL COMMENT '主键',
	openid VARCHAR(100) NULL DEFAULT NULL COMMENT '微信号',  
	policyNo VARCHAR(25) NOT NULL COMMENT '保单号',	
	isAgree INT(2) NOT NULL COMMENT '是否阅读（1、同意，空 或0 不同意）',	
	cashcouponId VARCHAR(32) NOT NULL COMMENT '红包ID',
	createTime DATETIME NOT NULL COMMENT '创建时间',
	PRIMARY KEY (id)
   )
COMMENT='阅读保单条款记录表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
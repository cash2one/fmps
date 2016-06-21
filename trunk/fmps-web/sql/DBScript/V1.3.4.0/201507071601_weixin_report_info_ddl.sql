ALTER TABLE `weixin_report_info`
	CHANGE COLUMN `caseStatus` `caseStatus` TINYINT(3) NOT NULL COMMENT '案件状态 1:未结案;2:已结案,缺材料;100:查看调度改派修改理赔方式;110:核赔提交;' AFTER `remark`,
	CHANGE COLUMN `sessionState` `sessionState` TINYINT(3) NULL DEFAULT NULL COMMENT '会话状态  1:会话中;0:结束会话,2:客户推出会话' AFTER `headimgurl`;

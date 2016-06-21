ALTER TABLE `weixin_claim_image`
	ADD COLUMN `status` VARCHAR(5) NOT NULL DEFAULT '0' COMMENT '发送核心状态,0表示待发送,1表示发送成功,2表示发送失败' AFTER `imgtype`;
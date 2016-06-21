ALTER TABLE `weixin_totaiwan_claim_image`
	ALTER `phonenum` DROP DEFAULT;
ALTER TABLE `weixin_totaiwan_claim_image`
	CHANGE COLUMN `phonenum` `phonenum` VARCHAR(11) NOT NULL COMMENT '电话号码' AFTER `customername`;

ALTER TABLE `weixin_plan_insurancekind`
	ADD COLUMN `productid` VARCHAR(32) NOT NULL COMMENT '保险产品id' AFTER `id`;

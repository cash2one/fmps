ALTER TABLE `weixin_policy`
	ALTER `policyno` DROP DEFAULT;
ALTER TABLE `weixin_policy`
	CHANGE COLUMN `policyno` `policyno` VARCHAR(20) NULL COMMENT '保单号' AFTER `id`,
	ADD COLUMN `orderno` VARCHAR(64) NULL COMMENT '订单号' AFTER `premium`,
	ADD COLUMN `status` VARCHAR(5) NULL COMMENT '1.支付接口调用成功;2.支付接口调用失败;3.微信支付成功;4.核心系统投保成功' AFTER `orderno`,
	ADD COLUMN `productid` VARCHAR(64) NULL COMMENT '商品ID' AFTER `status`,
	ADD COLUMN `productname` VARCHAR(100) NULL COMMENT '商品名称' AFTER `productid`,
	ADD COLUMN `period` VARCHAR(10) NULL COMMENT '保障期限' AFTER `productname`,
	ADD COLUMN `planname` VARCHAR(50) NULL COMMENT '计划名称' AFTER `period`,
	ADD COLUMN `paytime` DATETIME NULL COMMENT '支付时间' AFTER `planname`;

ALTER TABLE `weixin_policy_contract_address`
	ALTER `policyno` DROP DEFAULT;
ALTER TABLE `weixin_policy_contract_address`
	CHANGE COLUMN `policyno` `policyno` VARCHAR(20) NULL COMMENT '保单号' AFTER `id`,
	ADD COLUMN `orderno` VARCHAR(64) NULL COMMENT '订单号' AFTER `policyno`;

ALTER TABLE `weixin_policy_contract_address`
	CHANGE COLUMN `policyno` `policyno` VARCHAR(50) NULL DEFAULT NULL COMMENT '保单号' AFTER `id`;
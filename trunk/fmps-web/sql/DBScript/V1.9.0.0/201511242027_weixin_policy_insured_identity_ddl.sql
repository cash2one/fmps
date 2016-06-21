ALTER TABLE `weixin_policy_insured_identity`
	CHANGE COLUMN `policyno` `policyno` VARCHAR(50) NULL DEFAULT NULL COMMENT '保单号' AFTER `id`;
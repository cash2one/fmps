ALTER TABLE `weixin_policy_insured_identity`
	ADD CONSTRAINT `FK_weixin_policy_insured_identity_weixin_policy` FOREIGN KEY (`policyno`) REFERENCES `weixin_policy` (`policyno`);
 
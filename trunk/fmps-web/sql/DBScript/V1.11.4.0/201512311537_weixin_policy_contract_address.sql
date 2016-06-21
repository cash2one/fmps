ALTER TABLE `weixin_policy`
	ADD INDEX `Index_policy` (`policyno`);
ALTER TABLE `weixin_policy_contract_address`
	ADD CONSTRAINT `FK_weixin_policy_contract_address_weixin_policy` FOREIGN KEY (`policyno`) REFERENCES `weixin_policy` (`policyno`);
 	
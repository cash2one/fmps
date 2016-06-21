ALTER TABLE `weixin_product_rule`
	ADD CONSTRAINT `FK_product_rule_weixin_product` FOREIGN KEY (`productid`) REFERENCES `weixin_product` (`id`);

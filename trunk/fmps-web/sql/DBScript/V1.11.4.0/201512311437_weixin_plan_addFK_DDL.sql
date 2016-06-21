ALTER TABLE `weixin_plan`
	ADD CONSTRAINT `FK_plan_weixin_product` FOREIGN KEY (`productid`) REFERENCES `weixin_product` (`id`);

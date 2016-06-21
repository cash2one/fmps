ALTER TABLE `weixin_product_affiliated`
	ADD CONSTRAINT `FK_affiliated_weixin_product` FOREIGN KEY (`productid`) REFERENCES `weixin_product` (`id`);

ALTER TABLE `weixin_product`
	ADD COLUMN `producticon` varchar(255) DEFAULT NULL COMMENT '图标链接' AFTER `imagehref`;

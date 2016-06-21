ALTER TABLE `weixin_product`
	ADD COLUMN `delivery` VARCHAR(2) NULL COMMENT '保单寄送方式（1、无  2、仅电子保单 3、仅纸质保单 4、电子保单、纸质保单可选）' AFTER `occupationLevels`;
 
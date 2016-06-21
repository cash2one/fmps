CREATE TABLE `product_parameters` (
`id` BIGINT( 20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`productid` VARCHAR( 32) NULL DEFAULT NULL COMMENT '产品id',
`type` VARCHAR( 20) NULL DEFAULT NULL COMMENT '参数类型',
`param_key` VARCHAR( 20) NULL DEFAULT NULL,
`param_value` VARCHAR( 20) NULL DEFAULT NULL,
`description` VARCHAR( 255) NULL DEFAULT NULL COMMENT '描述',
PRIMARY KEY ( `id`),
INDEX `FK_WEIXIN_PRODUCT_PARAMETERS__PRODUCTID` ( `productid`),
CONSTRAINT `FK_WEIXIN_PRODUCT_PARAMETERS__PRODUCTID` FOREIGN KEY (`productid`) REFERENCES `weixin_product` ( `id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COMMENT='产品参数表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1 ;
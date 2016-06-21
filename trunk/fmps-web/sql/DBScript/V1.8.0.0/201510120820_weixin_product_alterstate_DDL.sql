ALTER TABLE `weixin_product`
	ALTER `state` DROP DEFAULT;
ALTER TABLE `weixin_product`
	CHANGE COLUMN `state` `status` VARCHAR(5) NOT NULL COMMENT '状态' AFTER `createtime`;

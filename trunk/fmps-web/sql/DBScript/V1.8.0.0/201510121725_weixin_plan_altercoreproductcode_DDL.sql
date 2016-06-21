ALTER TABLE `weixin_plan`
	ALTER `codeproductcode` DROP DEFAULT;
ALTER TABLE `weixin_plan`
	CHANGE COLUMN `codeproductcode` `coreproductcode` VARCHAR(20) NOT NULL COMMENT '核心产品代码' AFTER `productid`;

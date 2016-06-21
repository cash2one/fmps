ALTER TABLE `weixin_plan`
	ALTER `state` DROP DEFAULT;
ALTER TABLE `weixin_plan`
	CHANGE COLUMN `state` `status` VARCHAR(5) NOT NULL COMMENT '状态' AFTER `createtime`;

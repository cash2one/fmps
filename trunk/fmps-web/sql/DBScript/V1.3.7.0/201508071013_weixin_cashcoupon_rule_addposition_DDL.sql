ALTER TABLE `weixin_cashcoupon_rule`
	ADD COLUMN `position` VARCHAR(50) NULL DEFAULT NULL COMMENT '红包出现位置，多个以_隔开' AFTER `num`;

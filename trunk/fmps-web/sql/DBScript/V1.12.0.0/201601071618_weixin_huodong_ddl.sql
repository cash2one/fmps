ALTER TABLE `weixin_huodong`
	ADD COLUMN `prizesuper` VARCHAR(400) NULL DEFAULT NULL COMMENT '特等奖奖品' AFTER `description`,
	ADD COLUMN `supertotal` INT(4) NULL DEFAULT NULL COMMENT '特等奖数量' AFTER `prizesuper`,
	CHANGE COLUMN `priceone` `prizeone` VARCHAR(400) NULL DEFAULT NULL COMMENT '一等奖奖品' AFTER `supertotal`,
	CHANGE COLUMN `pricetwo` `prizetwo` VARCHAR(400) NULL DEFAULT NULL COMMENT '二等奖奖品' AFTER `onetotal`,
	CHANGE COLUMN `pricethree` `prizethree` VARCHAR(400) NULL DEFAULT NULL COMMENT '三等奖奖品' AFTER `twototal`,
	CHANGE COLUMN `endtime` `endtime` TIMESTAMP NULL DEFAULT NULL COMMENT '结束时间' AFTER `starttime`;;

ALTER TABLE `weixin_plan_insurancekind`
	ADD CONSTRAINT `FK_insurancekind_weixin_plan` FOREIGN KEY (`planid`) REFERENCES `weixin_plan` (`id`);

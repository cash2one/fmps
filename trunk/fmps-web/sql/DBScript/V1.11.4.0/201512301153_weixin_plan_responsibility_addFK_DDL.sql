ALTER TABLE `weixin_plan_responsibility`
	ADD CONSTRAINT `FK_responsibility_weixin_plan` FOREIGN KEY (`planid`) REFERENCES `weixin_plan` (`id`);

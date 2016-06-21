/*修改外键名称*/
ALTER TABLE `weixin_policy`
	DROP FOREIGN KEY `FK_weixin_huodong__id`;
ALTER TABLE `weixin_policy`
	ADD CONSTRAINT `FK_WEIXIN_POLICY_HUODONG__HUODONGID` FOREIGN KEY (`huodongid`) REFERENCES `weixin_huodong` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION;

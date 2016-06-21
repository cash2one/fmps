ALTER TABLE `weixin_huodong_ranklist`
	ADD CONSTRAINT `FK_huodong_ranklist_huodong_record` FOREIGN KEY (`openid`) REFERENCES `weixin_huodong_record` (`sponsor`);

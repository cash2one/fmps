ALTER TABLE `weixin_policy`
       ADD COLUMN `huodongid` VARCHAR(100 ) NULL COMMENT '活动id' AFTER `operateCode`;
ALTER TABLE `weixin_policy`
       ADD CONSTRAINT `FK_weixin_huodong__id` FOREIGN KEY ( `huodongid`) REFERENCES `weixin_huodong` ( `id`) ON UPDATE NO ACTION ON DELETE NO ACTION;

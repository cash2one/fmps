/*加计划id*/
ALTER TABLE `product_parameters`
ADD COLUMN `planid` VARCHAR(32 ) NULL COMMENT '计划id' AFTER `description`,
       ADD CONSTRAINT `FK_WEIXIN_PRODUCT_PARAMETERS__PLANID` FOREIGN KEY (`planid`) REFERENCES `weixin_plan` ( `id`) ON UPDATE NO ACTION ON DELETE NO ACTION ;

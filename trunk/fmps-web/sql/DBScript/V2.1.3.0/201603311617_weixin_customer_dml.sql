ALTER TABLE `weixin_customer`
	ADD COLUMN `carRelation` VARCHAR(5) NULL COMMENT '与车主关系代码' AFTER `school`,
	ADD COLUMN `carRelationname` VARCHAR(10) NULL COMMENT '与车主关系名称' AFTER `carRelation`,
	ADD COLUMN `carownername` VARCHAR(10) NULL COMMENT '车主姓名' AFTER `carRelationname`,
	ADD COLUMN `licenseno` VARCHAR(10) NULL COMMENT '车牌号' AFTER `carownername`;
 
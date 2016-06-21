ALTER TABLE `weixin_claim_image`
	ADD COLUMN `caseno` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '案件号' AFTER `uploadtime`,
	ADD COLUMN `imgtype` VARCHAR(5) NOT NULL DEFAULT '' COMMENT '照片类型,1:身份证,2:许可证,3:通行证,4:医疗诊断书,5:医疗收据正版,6:银行卡,7:其他证明文件' AFTER `caseno`;
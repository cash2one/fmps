ALTER TABLE `weixin_receive_message`
	ADD COLUMN `contentType` VARCHAR(100) NULL DEFAULT NULL COMMENT '��ý���ļ�����' ,
	ADD COLUMN `contentLength` VARCHAR(100) NULL DEFAULT NULL COMMENT '��ý���ļ�����'  ;
ALTER TABLE `weixin_receive_message`
	ADD COLUMN `contentType` VARCHAR(100) NULL DEFAULT NULL COMMENT '多媒体文件类型' ,
	ADD COLUMN `contentLength` VARCHAR(100) NULL DEFAULT NULL COMMENT '多媒体文件长度'  ;
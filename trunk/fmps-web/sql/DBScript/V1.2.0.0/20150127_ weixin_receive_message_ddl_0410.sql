ALTER TABLE `weixin_receive_message`
	CHANGE COLUMN `content` `content` VARCHAR(600) NULL DEFAULT NULL COMMENT 'ÏûÏ¢ÄÚÈÝ' AFTER `ID`;
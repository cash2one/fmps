ALTER TABLE `weixin_card_info`
	CHANGE COLUMN `status` `status` VARCHAR(5) NOT NULL COMMENT '��ǰ״̬(-1�ɼ���;-2�Ѽ���)' AFTER `validate`;
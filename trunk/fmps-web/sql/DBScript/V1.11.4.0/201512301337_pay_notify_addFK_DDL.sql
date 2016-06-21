ALTER TABLE `pay_notify`
	ADD CONSTRAINT `FK_notify_orderinfo` FOREIGN KEY (`out_trade_no`) REFERENCES `weixin_offline_orderinfo` (`ID`);

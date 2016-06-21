ALTER TABLE `weixin_offline_order_detail`
	ADD CONSTRAINT `FK_weixin_offline_order_detail_weixin_offline_orderinfo` FOREIGN KEY (`orderinfo_id`) REFERENCES `weixin_offline_orderinfo` (`ID`);
 
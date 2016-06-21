ALTER TABLE `t_s_dynamic_password`	ADD INDEX `Index_Send_to` (`send_to`);
 
ALTER TABLE `webservice_invoke_failure_log` ADD INDEX `Index_status` (`status`);

ALTER TABLE `weixin_customer_service_chatinfo`	ADD INDEX `Index_operatorcode` (`operatorcode`);

ALTER TABLE `weixin_giftset_detail`
	ADD INDEX `Index _applicantname` (`applicantname`, `appIdentifynumber`),
	ADD INDEX `Index_insuredname` (`insuredname`, `insIdentifynumber`),
	ADD INDEX `Index_openid` (`openid`);
ALTER TABLE `weixin_product_affiliated`
	ADD INDEX `INX_WEIXIN_PRODUCT_AFFILIATED_PRODUCTID_TYPE` (`productid`, `type`); 
ALTER TABLE `weixin_receive_message`	ADD INDEX `Index_msgid` (`msgid`);
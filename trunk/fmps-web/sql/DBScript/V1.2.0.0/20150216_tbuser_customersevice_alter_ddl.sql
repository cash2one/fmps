alter table weixin_customer_service_chatinfo modify column content varchar(1000) ;

INSERT INTO `t_s_base_user` (`ID`, `activitiSync`, `browser`, `password`, `realname`, `signature`, `status`, `userkey`, `username`, `departid`, `imageurl`) VALUES ('4028d881436d514601436d5215bc0047', 1, NULL, 'aa646048bfae3f04', '李磊', NULL, 1, NULL, '0000130', '4028d881436d514601436d5214d70015', 'http://wx.qlogo.cn/mmopen/PiajxSqBRaELM8BIiasOyflG8hPRypXrqgQ2vtBAicxLy0lQuLeH4SDicILcbWwQLYaG44qibJE1BBfXicn5kZ8AmFicw/0');
INSERT INTO `t_s_base_user` (`ID`, `activitiSync`, `browser`, `password`, `realname`, `signature`, `status`, `userkey`, `username`, `departid`, `imageurl`) VALUES ('4028d881436d514601436d5215bc0048', NULL, NULL, 'aa646048bfae3f04', '许晓文', NULL, NULL, NULL, '0000117', '4028d881436d514601436d5214d70015', 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLACWRFjcshnWFqA3ouvR0Emm0Zib0icvwIMjLa3qbJXgqoqmgnf28kC3DibxevcpvpcVSxEJ6G8GjjJg/0');
INSERT INTO `t_s_base_user` (`ID`, `activitiSync`, `browser`, `password`, `realname`, `signature`, `status`, `userkey`, `username`, `departid`, `imageurl`) VALUES ('4028d881436d514601436d5215bc0049', NULL, NULL, 'aa646048bfae3f04', '张月明', NULL, NULL, NULL, '0000149', '4028d881436d514601436d5214d70015', 'http://wx.qlogo.cn/mmopen/PiajxSqBRaELM8BIiasOyflG8hPRypXrqgQ2vtBAicxLy0lQuLeH4SDicILcbWwQLYaG44qibJE1BBfXicn5kZ8AmFicw/0');

INSERT INTO `t_s_user` (`email`, `mobilePhone`, `officePhone`, `signatureFile`, `id`, `accountid`, `type`) VALUES (NULL, NULL, NULL, NULL, '4028d881436d514601436d5215bc0047', '', NULL);
INSERT INTO `t_s_user` (`email`, `mobilePhone`, `officePhone`, `signatureFile`, `id`, `accountid`, `type`) VALUES (NULL, NULL, NULL, NULL, '4028d881436d514601436d5215bc0048', '', NULL);
INSERT INTO `t_s_user` (`email`, `mobilePhone`, `officePhone`, `signatureFile`, `id`, `accountid`, `type`) VALUES (NULL, NULL, NULL, NULL, '4028d881436d514601436d5215bc0049', NULL, '');

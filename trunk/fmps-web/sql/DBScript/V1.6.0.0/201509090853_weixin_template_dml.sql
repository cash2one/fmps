
/*两条正式环境在使用的模板消息配置*/
insert into weixin_template
  (id,
   title,
   content,
   content_demo,
   template_id,
   account_id,
   bussiness_type,
   status,
   create_time,
   update_time)
values
  ('ga828ebb4881111e01488114371a0002',
   '理赔审核通过通知',
'{{first.DATA}}
车牌号：{{keyword1.DATA}}
被保险人：{{keyword2.DATA}}
出险经过：{{keyword3.DATA}}
理赔金额：{{keyword4.DATA}}
理赔所缺材料：{{keyword5.DATA}}
{{remark.DATA}}',
'尊敬的张三先生/女士，您的理赔案件最新进展信息
车牌号：闽D12345
被保险人：梁一
出险经过：2015-03-01日16时02分于SM城市广场公交车站旁发生碰撞事故，造成保险杠明显凹陷。
理赔金额：2660
理赔所缺材料：行驶证
您好，案件已审核通过，赔款会支付到您指定银行卡。如您欠缺材料请于5个工作日将所缺材料补齐，如有疑问您可拨打4008-817-518进行咨询。【富邦财险】',
   '4wHwpnNTJGkdtO2BMjVipfk5os1QJnSaAZ6VHVdEf_Y',
   '8a828ebb4883613201488364bc510001',
   '400',
   '1',
   '2015-09-08 10:26:57',
   '2015-09-08 10:26:57');

insert into weixin_template
  (id,
   title,
   content,
   content_demo,
   template_id,
   account_id,
   bussiness_type,
   status,
   create_time,
   update_time)
values
  ('ga828ebb4881111e01488114371a0001',
   '理赔查勘提醒',
'{{first.DATA}}
车牌号：{{keyword1.DATA}}
被保险人：{{keyword2.DATA}}
出险经过：{{keyword3.DATA}}
理赔专员：{{keyword4.DATA}}
理赔专员手机号：{{keyword5.DATA}}
{{remark.DATA}}',
'尊敬的张三先生/女士，您的理赔案件最新进展信息
车牌号：闽D12345
被保险人：张三
出险经过：2015-03-01日16时02分于SM城市广场公交车站旁发生碰撞事故，造成保险杠明显凹陷。
理赔专员：李四
理赔专员手机号：13412345678
您好，理赔专员5分钟内会与您联系，请您放心。如有疑问您可拨打4008-817-518进行咨询。【富邦财险】',
   'Ngyk_OO3qcXHv6fELnsKNHAVS79Ag6xfFivgnXocaGo',
   '8a828ebb4883613201488364bc510001',
   '400',
   '1',
   '2015-09-08 10:26:57',
   '2015-09-08 10:26:57');
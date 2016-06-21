/*新车号牌更新提醒*/
INSERT INTO weixin_template
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
VALUES
  ('5d30a619-dc50-49ea-a5a7-7d1297e3a81e',
   '新车号牌更新提醒',
   '{{first.DATA}}\r\n车型名称：{{keyword1.DATA}}\r\n发动机号：{{keyword2.DATA}}\r\n车架号：{{keyword3.DATA}}\r\n{{remark.DATA}}',
   '尊敬的张三先生/女士，爱车上牌后请您尽快更新保单的车牌信息\r\n车型名称：途观\r\n发动机号：121212121\r\n车架号：LSGTYGFD54DA34356\r\n点击详情，进行新车车牌变更。车牌变更有助于您的理赔时效。若需帮助，请回复"0"（转人工服务）',
   '5Me4ggzdPw6BfCDHTt2AdC9D_0gWcsIQpMGONBfrc28',
   '8a828ebb4883613201488364bc510001',
   '500',
   1,
   '2016-01-07 14:31:25',
   '2016-01-07 14:31:25');

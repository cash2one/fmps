/**weixin_report_info���claimConsumeTime�����ʱ�ֶ�**/
alter table weixin_report_info
    add claimConsumeTime int NULL DEFAULT NULL COMMENT '�����ʱ(�������ʱ�������ʱ�� ��λ:��)';


/**�޸�weixin_report_info���caseStatus�ֶα�ע**/
ALTER TABLE weixin_report_info 
MODIFY COLUMN caseStatus varchar(3) NOT NULL 
COMMENT '����״̬ 1:δ�᰸;2:�ѽ᰸,ȱ����;100:�鿴���ȸ����޸����ⷽʽ;110:�����ύ;';

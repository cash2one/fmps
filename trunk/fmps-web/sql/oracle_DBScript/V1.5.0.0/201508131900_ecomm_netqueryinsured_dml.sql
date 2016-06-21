/*ecomm_netqueryinsured ��ʷ���ݴ��� ɾ��ע����ȫ���˱�����Ч����Сʱ����������Сʱ�ı��� */
delete from ecomm_netqueryinsured i
where 
exists
 (select 1
          from netqueryphead h,netquerycmain m
         where h.policyno = i.policyno and h.policyno = m.policyno
           and (h.endortype = '19' or
               (h.endortype = '21' and h.validdate = m.startdate and
               h.validhour = m.starthour)))
;
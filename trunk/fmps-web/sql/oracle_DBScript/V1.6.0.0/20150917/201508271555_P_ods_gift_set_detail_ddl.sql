/*存储过程:产生券详细*/
create or replace procedure p_ods_gift_set_detail is

  /* 定义一个变量存weixin_policy_gift_set的批次号,
  出现异常时用于更新批次表 */
  v_batchid number(28);
  v_sqlerrm varchar2(255);
begin
  for c in (select w.policyno,
                   gift_set_id,
                   gift_set_name,
                   gift_set_count,
                   inserttime,
                   gift_set_detail_id,
                   gift_set_detail_count,
                   name,
                   repairlogo,
                   deepcolor,
                   lightcolor,
                   providerepairname,
                   startdate,
                   enddate,
                   applicantname,
                   appidentifynumber,
                   insuredname,
                   insidentifynumber,
                   w.batchid,
                   w.areaname,
                   w.cardtype,
                   c.licenseno
              from weixin_policy_gift_set w,
                   etl_batch_log          l,
                   netquerycitem_car      c
             where w.batchid = l.batchid
               and w.policyno = c.policyno(+)
               and l.status = 0) loop
  
    v_batchid := c.batchid;
  
    for cc in 1 .. c.gift_set_count * c.gift_set_detail_count loop
      insert into ods_gift_set_detail
        (id,
         policyno,
         giftsetid,
         giftsetname,
         giftsetdetailid,
         name,
         repairlogo,
         providerepairname,
         deepcolor,
         lightcolor,
         startdate,
         enddate,
         etl_inserttime,
         applicantname,
         appidentifynumber,
         insuredname,
         insidentifynumber,
         batchid,
         areaname,
         cardtype,
         licenseno)
      values
        (sys_guid(),
         c.policyno,
         c.gift_set_id,
         c.gift_set_name,
         c.gift_set_detail_id,
         c.name,
         c.repairlogo,
         c.providerepairname,
         c.deepcolor,
         c.lightcolor,
         c.startdate,
         c.enddate,
         c.inserttime,
         c.applicantname,
         c.appidentifynumber,
         c.insuredname,
         c.insidentifynumber,
         c.batchid,
         c.areaname,
         c.cardtype,
         c.licenseno);
    end loop;
    commit;
  end loop;

exception
  when others then
    v_sqlerrm := SQLERRM;
    update etl_batch_log
       set reason = SUBSTR(v_sqlerrm, 1, 255)
     where batchid = v_batchid;
  
end p_ods_gift_set_detail;

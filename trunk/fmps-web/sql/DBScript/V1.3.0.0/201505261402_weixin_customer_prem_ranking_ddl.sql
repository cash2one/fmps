/*mysql保费排名加索引*/
ALTER TABLE weixin_customer_prem_ranking ADD INDEX IDX_PREM_RANKING__IDENTIFY_NAME(identifynumber,customername); 
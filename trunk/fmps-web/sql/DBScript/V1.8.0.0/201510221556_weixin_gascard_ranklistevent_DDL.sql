-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.20 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.3.0.4814
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  事件 fmps.weixin_gascard_ranklistevent 结构
DELIMITER //
CREATE  EVENT `weixin_gascard_ranklistevent` ON SCHEDULE EVERY 1 MINUTE STARTS '2015-10-26 15:37:24' ENDS '2015-11-14 00:00:00' ON COMPLETION PRESERVE ENABLE COMMENT '加油卡活动排行榜' DO BEGIN
delete from weixin_gascard_ranklist;
set @mycnt = 0;
insert into weixin_gascard_ranklist (id,nickname,openid,cnt,rankno,updatetime) select uuid(),rank.nickname,rank.openid,rank.cnt,(@mycnt := @mycnt + 1) as rankno,current_timestamp from (select userinfo.nickname,record.sponsor as openid,count(record.sponsor) as cnt from weixin_gascard_help_record record left join weixin_gzuserinfo userinfo on userinfo.openid=record.sponsor  where record.huodongid='8a828ebb49166847014916deca570006' group by record.sponsor order by cnt desc limit 150) rank;
END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

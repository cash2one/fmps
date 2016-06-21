-- --------------------------------------------------------
-- 主机:                           10.1.21.52
-- 服务器版本:                        5.6.20-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  8.3.0.4814
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 fmps.weixin_cashcoupon_rule 结构
CREATE TABLE IF NOT EXISTS `weixin_cashcoupon_rule` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `rulename` varchar(32) DEFAULT NULL COMMENT '规则名称',
  `huodongid` varchar(100) DEFAULT NULL COMMENT '活动编号',
  `maxvalue` float DEFAULT NULL COMMENT '最大值',
  `minvalue` float DEFAULT NULL COMMENT '最小值',
  `num` int(11) DEFAULT NULL COMMENT '总数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='红包规则表';

-- 正在导出表  fmps.weixin_cashcoupon_rule 的数据：~2 rows (大约)
DELETE FROM `weixin_cashcoupon_rule`;
/*!40000 ALTER TABLE `weixin_cashcoupon_rule` DISABLE KEYS */;
INSERT INTO `weixin_cashcoupon_rule` (`id`, `rulename`, `huodongid`, `maxvalue`, `minvalue`, `num`) VALUES
	('10000000001', '高概率', '8a828ebb49166847014916deca570004', 1.1, 1, 20000),
	('10000000002', '低概率', '8a828ebb49166847014916deca570004', 5, 4.5, 40);
/*!40000 ALTER TABLE `weixin_cashcoupon_rule` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

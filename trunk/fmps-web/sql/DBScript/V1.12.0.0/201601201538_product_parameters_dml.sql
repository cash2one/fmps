-- --------------------------------------------------------
-- 主机:                           10.1.21.52
-- 服务器版本:                        5.6.26-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  8.3.0.4814
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- 正在导出表  fmps.product_parameters 的数据：~4 rows (大约)
DELETE FROM `product_parameters`;
/*!40000 ALTER TABLE `product_parameters` DISABLE KEYS */;
INSERT INTO `product_parameters` (`id`, `productid`, `type`, `param_key`, `param_value`, `description`, `planid`) VALUES
	(6, '8a8195b351f192df0151f62dae090007', 'general', 'startdate', '2016-03-01', '春节交通意外10万1个月', '8a8195b3522e514601522e9cdc45000b'),
	(7, '8a8195b351f6b7910151f74dc163003a', 'general', 'startdate', '2016-02-01', '春节老人骨折险固定起保日期', '8a8195b3522f359701522f500975138d'),
	(8, '8a8195b351f192df0151f62dae090007', 'general', 'startdate', '2016-03-01', '春节交通意外10万11个月', '8a8195b351f192df0151f62e50650008'),
	(9, '8a8195b35112ed70015112f3280d0002', 'general', 'toTai', 'Y', '是否是赴台类商品', NULL),
	(10, '8a8195b35112ed70015112f3280d0002', 'general', 'need_mailing_address', 'Y', '需要填保单寄送地址', NULL);
/*!40000 ALTER TABLE `product_parameters` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

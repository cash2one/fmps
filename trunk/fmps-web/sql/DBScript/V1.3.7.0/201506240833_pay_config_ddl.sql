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

-- 导出  表 fmps.pay_config 结构
CREATE TABLE IF NOT EXISTS `pay_config` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `type` varchar(20) NOT NULL COMMENT '支付方式',
  `key` varchar(50) NOT NULL COMMENT '参数名',
  `value` varchar(300) NOT NULL COMMENT '参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='第三方支付配置信息表(涉及domain的请使用${WebRoot}代替)';

-- 正在导出表  fmps.pay_config 的数据：~9 rows (大约)
DELETE FROM `pay_config`;
/*!40000 ALTER TABLE `pay_config` DISABLE KEYS */;
INSERT INTO `pay_config` (`id`, `type`, `key`, `value`) VALUES
	('100001', '支付宝', 'sec_id', 'MD5'),
	('100002', '支付宝', 'call_back_url', '${WebRoot}/pay/payController/success.do'),
	('100003', '支付宝', 'merchant_url', '${WebRoot}/pay/payController/order.do'),
	('100004', '支付宝', 'notify_url', '${WebRoot}/pay/payController/notify.do'),
	('100005', '支付宝', 'charset', 'utf-8'),
	('100006', '支付宝', 'seller_account_name', 'test@fubon.com.cn'),
	('100007', '支付宝', 'req_url', '/fo/offlinepay/alipayapi'),
	('100008', '支付宝', 'quato', '3000'),
	('12345678', '支付宝', 'key', 'luerpjn2w1ykpdmaujxlg789e0kjini4'),
	('123456789', '支付宝', 'partner', '2088311617201418');
/*!40000 ALTER TABLE `pay_config` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

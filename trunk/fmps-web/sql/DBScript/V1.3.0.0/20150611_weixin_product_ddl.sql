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

-- 导出  表 fmps.weixin_product 结构
CREATE TABLE IF NOT EXISTS `weixin_product` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `productname` varchar(30) NOT NULL COMMENT '产品名称',
  `internalcode` varchar(20) NOT NULL COMMENT '产品代码',
  `type` int(6) NOT NULL COMMENT '类型',
  `iscard` varchar(2) NOT NULL COMMENT '是否卡单',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `state` varchar(5) NOT NULL COMMENT '状态',
  `imagename` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `imagehref` varchar(255) DEFAULT NULL COMMENT '图片链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信产品表';

-- 正在导出表  fmps.weixin_product 的数据：~10 rows (大约)
DELETE FROM `weixin_product`;
/*!40000 ALTER TABLE `weixin_product` DISABLE KEYS */;
INSERT INTO `weixin_product` (`id`, `productname`, `internalcode`, `type`, `iscard`, `createtime`, `state`, `imagename`, `imagehref`) VALUES
	('ff8080814d8fd559014d8fec1b6f0002', '富邦家财卡', 'ssd', 2, 'Y', '2015-05-26 19:12:04', '1', NULL, 'upload/files/20150607165811G6rK3RAp.jpg'),
	('ff8080814d9405fe014d940e34d30001', '富邦爱家卡', 'aijiaka', 2, 'Y', '2015-05-27 14:27:48', '1', NULL, 'upload/files/20150605093451vGsW64Ic.jpg'),
	('ff8080814d9405fe014d9464d93f001b', '富邦意外伤害骨折卡', 'gz', 1, 'Y', '2015-05-27 16:02:26', '1', NULL, 'upload/files/20150607165832yiU8exGE.jpg'),
	('ff8080814d9405fe014d9474b5f3001e', '富邦长盛卡', 'cs', 1, 'Y', '2015-05-27 16:19:46', '1', NULL, 'upload/files/201506071658548Ir2Ckh0.jpg'),
	('ff8080814d9405fe014d94810fe6002a', '富邦关爱卡', 'gak', 1, 'Y', '2015-05-27 16:33:15', '1', NULL, 'upload/files/20150527163314F1uTCI9y.png'),
	('ff8080814d940613014d94260e3d0008', '富邦交通守护卡', 'jiaotong', 1, 'Y', '2015-05-27 14:53:51', '1', NULL, 'upload/files/20150607170518g0Ryg2r9.jpg'),
	('ff8080814d940613014d94310f09000b', '富邦安心A卡', 'sxk', 1, 'Y', '2015-05-27 15:05:52', '1', NULL, 'upload/files/20150607165934punN61Qs.jpg'),
	('ff8080814d940613014d9456c3cf0018', '富邦安心B卡', 'sxk', 1, 'Y', '2015-05-27 15:47:03', '1', NULL, 'upload/files/20150607170024dXS51u4Z.jpg'),
	('ff8080814d940613014d947b91dd0026', '悠游天下卡', 'yytx', 1, 'Y', '2015-05-27 16:27:15', '1', NULL, 'upload/files/201505291446274BTbRUWv.jpg'),
	('ff8080814d9ee364014dacbdb98b0008', '住宅守护卡', 'zzsh', 2, 'Y', '2015-06-01 09:30:24', '1', NULL, 'upload/files/20150607170054rwNBGwC4.jpg');
/*!40000 ALTER TABLE `weixin_product` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

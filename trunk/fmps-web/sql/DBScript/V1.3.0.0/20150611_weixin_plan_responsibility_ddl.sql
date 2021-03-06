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

-- 导出  表 fmps.weixin_plan_responsibility 结构
CREATE TABLE IF NOT EXISTS `weixin_plan_responsibility` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `planid` varchar(32) NOT NULL COMMENT '计划ID',
  `liabilitycode` varchar(20) NOT NULL COMMENT '责任代码',
  `liability` varchar(100) NOT NULL COMMENT '保险责任',
  `amount` varchar(10) NOT NULL COMMENT '保额',
  `unit` varchar(20) NOT NULL COMMENT '单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计划责任维护表';

-- 正在导出表  fmps.weixin_plan_responsibility 的数据：~37 rows (大约)
DELETE FROM `weixin_plan_responsibility`;
/*!40000 ALTER TABLE `weixin_plan_responsibility` DISABLE KEYS */;
INSERT INTO `weixin_plan_responsibility` (`id`, `planid`, `liabilitycode`, `liability`, `amount`, `unit`) VALUES
	('ff8080814d92c7ca014d92fd5b4d0017', 'ff8080814d8fd53d014d8fedbb510001', '0001', '房屋及其室内附属设备', '4', '万元'),
	('ff8080814d92c7cb014d92fd92a60017', 'ff8080814d8fd53d014d8fedbb510001', '0002', '室内装潢', '1', '万元'),
	('ff8080814d9405fe014d94120dcc0004', 'ff8080814d9405fe014d940faecf0002', '0001', '室内财产 含室内装潢', '10', '万元'),
	('ff8080814d9405fe014d942963f80009', 'ff8080814d9405fe014d94277d8a0007', '0001', '个人交通乘客意外伤害身故/伤残 ', '10', '万元'),
	('ff8080814d9405fe014d94472f46000d', 'ff8080814d940613014d9431b1b5000c', '0003', '意外伤害住院日额补贴金（住院第4日起给付，最高以180日为限）', '50', '元/天'),
	('ff8080814d9405fe014d9447c2cc000e', 'ff8080814d940613014d9431b1b5000c', '0004', '空中大众运输交通工具乘客意外身故/伤残', '50', '万元'),
	('ff8080814d9405fe014d94480b31000f', 'ff8080814d940613014d9431b1b5000c', '0005', '陆海大众运输交通工具乘客意外身故/伤残', '30', '万元'),
	('ff8080814d9405fe014d944840a60010', 'ff8080814d940613014d9431b1b5000c', '0006', '自驾或乘坐7座以下非营运车身故', '20', '万元'),
	('ff8080814d9405fe014d944880bd0011', 'ff8080814d940613014d9431b1b5000c', '0007', '行人身份遭受机动车交通意外伤害事故身故', '20', '万元'),
	('ff8080814d9405fe014d945d14b40014', 'ff8080814d9405fe014d94576c8a0013', '0001', '个人意外伤害身故/伤残', '8', '万元'),
	('ff8080814d9405fe014d946073ce0016', 'ff8080814d9405fe014d94576c8a0013', '0003', '意外伤害住院日额补贴金（住院第4日起给付，最高以180日为限）', '30', '元/天'),
	('ff8080814d9405fe014d946132f00017', 'ff8080814d9405fe014d94576c8a0013', '0006', '自驾或乘坐7座以下非营运车身故', '10', '万元'),
	('ff8080814d9405fe014d9461713e0018', 'ff8080814d9405fe014d94576c8a0013', '0007', '行人身份遭受机动车交通意外伤害事故身故', '10', '万元'),
	('ff8080814d9405fe014d94767ccb0020', 'ff8080814d9405fe014d947603f7001f', '0001', '个人意外伤害身故/残疾/烧伤保险金', '8', '万元'),
	('ff8080814d9405fe014d947ca2160023', 'ff8080814d940613014d947c4abe0027', '0001', '航空意外伤害保险', '50', '万元'),
	('ff8080814d9405fe014d947ce28b0024', 'ff8080814d940613014d947c4abe0027', '0002', '火车意外伤害保险', '10', '万元'),
	('ff8080814d9405fe014d947d1dd20025', 'ff8080814d940613014d947c4abe0027', '0003', '轮船意外伤害保险', '10', '万元'),
	('ff8080814d9405fe014d948229d90032', 'ff8080814d940613014d9481ca140030', '0001', '个人意外伤害身故/残疾/烧伤', '20', '万元'),
	('ff8080814d9405fe014d94825bb20033', 'ff8080814d940613014d9481ca140030', '0002', '意外伤害医疗(扣免赔额200元后90%赔付)', '2', '万元'),
	('ff8080814d9405fe014d948294d70034', 'ff8080814d940613014d9481ca140030', '0003', '意外伤害住院日额补贴金（住院第4日起给付，最高以180日为限）', '100', '元/天'),
	('ff8080814d940613014d94409cf4000d', 'ff8080814d940613014d9431b1b5000c', '0001', '个人意外伤害身故/伤残', '15', '万元'),
	('ff8080814d940613014d94421589000e', 'ff8080814d940613014d9431b1b5000c', '0002', '意外伤害医疗(扣免赔额100元后100%赔付)', '1', '万元'),
	('ff8080814d940613014d945e1ffc0019', 'ff8080814d9405fe014d94576c8a0013', '0002', '意外伤害医疗(扣免赔额100元后100%赔付)', '5000', '元'),
	('ff8080814d940613014d9460b60f001a', 'ff8080814d9405fe014d94576c8a0013', '0004', '空中大众运输交通工具乘客意外身故/伤残', '30', '万元'),
	('ff8080814d940613014d9460ef6a001b', 'ff8080814d9405fe014d94576c8a0013', '0005', '陆海大众运输交通工具乘客意外身故/伤残', '16', '万元'),
	('ff8080814d940613014d946999d3001e', 'ff8080814d9405fe014d94695512001c', '0001', '意外骨折医疗保障', '2000', '元'),
	('ff8080814d940613014d9476b0c20022', 'ff8080814d9405fe014d947603f7001f', '0002', '意外伤害医疗保险金(扣免赔额100元后80%赔付)', '1', '万元'),
	('ff8080814d940613014d9477006f0023', 'ff8080814d9405fe014d947603f7001f', '0003', '意外伤害住院日额补贴保险金', '50', '元/天'),
	('ff8080814d9ee364014dacafb5900006', 'ff8080814d8fd53d014d8fedbb510001', '0007', '附加家用电器用电安全保险', '16000', '元'),
	('ff8080814d9ee364014dacb08ba10007', 'ff8080814d8fd53d014d8fedbb510001', '0009', '附加居家责任保险', '32000', '元'),
	('ff8080814d9ee364014dacd68df00009', 'ff8080814d9ee366014dacc71403000f', '0001', '房屋及其室内附属设备及室内财产', '15', '万元'),
	('ff8080814d9ee364014dacd6d745000a', 'ff8080814d9ee366014dacc71403000f', '0002', '家庭财产保险附加火灾火场清理费用保险', '1', '万元'),
	('ff8080814d9ee366014dacad81770009', 'ff8080814d8fd53d014d8fedbb510001', '0003', '家电和文体娱乐用品', '4000', '元'),
	('ff8080814d9ee366014dacae263d000a', 'ff8080814d8fd53d014d8fedbb510001', '0004', '衣服和床上用品', '3000', '元'),
	('ff8080814d9ee366014dacaeccc1000b', 'ff8080814d8fd53d014d8fedbb510001', '0005', '家具及其他生活用品', '3000', '元'),
	('ff8080814d9ee366014dacaf7cab000c', 'ff8080814d8fd53d014d8fedbb510001', '0006', '附加盗抢保险', '2000', '元'),
	('ff8080814d9ee366014dacafe87f000d', 'ff8080814d8fd53d014d8fedbb510001', '0008', '附加管道破裂及水渍保险', '6000', '元');
/*!40000 ALTER TABLE `weixin_plan_responsibility` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

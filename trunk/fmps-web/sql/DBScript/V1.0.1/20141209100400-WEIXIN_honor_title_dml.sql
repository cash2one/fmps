-- --------------------------------------------------------
-- 主机:                           10.1.21.52
-- 服务器版本:                        5.6.20 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  8.3.0.4814
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- 正在导出表  fmps.weixin_honor_title 的数据：~34 rows (大约)
ALTER TABLE `weixin_honor_title` ADD `honor_desc` varchar(255) not NULL ;
DELETE FROM `weixin_honor_title`;
/*!40000 ALTER TABLE `weixin_honor_title` DISABLE KEYS */;
INSERT INTO `weixin_honor_title` (`id`, `honor_name`, `prem_start`, `prem_end`, `honor_desc`) VALUES
	('402889f657689ac401476670bb74002l', '灵宝天尊', 150000, 999999999, '三清之一，道教最高神'),
	('402889f657689ac401476670bb74003l', '太上老君', 140000, 150000, '三清道教教主'),
	('402889f657689ac401476670bb74004l', '紫微大帝', 130000, 140000, '执掌天经地纬、日月星辰等自然现象'),
	('402889f657689ac401476670bb74005l', '天皇大帝', 120000, 130000, '统御众星，主持人间兵革之事'),
	('402889f657689ac401476670bb74006l', '太白金星', 110000, 120000, '奉玉皇大帝之命，监察人间善恶'),
	('402889f657689ac401476670bb74007l', '赤脚大仙', 100000, 110000, '身带异宝，不惧百毒'),
	('402889f657689ac401476670bb74008l', '天蓬元帅', 90000, 100000, '神系第一护法，天宫的总司令'),
	('402889f657689ac401476670bb74009l', '托塔天王', 80000, 90000, '手持如意黄金宝塔，降魔大元帅'),
	('402889f657689ac401476670bb74010l', '哪吒', 70000, 80000, '三头八臂，第一总领使天帅元领袖'),
	('402889f657689ac401476670bb74011l', '二郎神', 60000, 70000, '擅长七十三变，肉身成圣'),
	('402889f657689ac401476670bb74012l', '齐天大圣', 50000, 60000, '强者为尊该让我，英雄只此敢争先'),
	('402889f657689ac401476670bb74013l', '风伯', 40000, 50000, '掌八风消息，通五运之气候'),
	('402889f657689ac401476670bb74014l', '月老', 30000, 40000, '婚姻之神，愿天下有情人都成眷属'),
	('402889f657689ac401476670bb74015l', '增长天王', 20000, 30000, '快刀斩乱麻；慧剑断烦恼'),
	('402889f657689ac401476670bb74016l', '持国天王', 10000, 20000, '慈悲为怀，保佑众生'),
	('402889f657689ac401476670bb74017l', '广目天王', 9500, 10000, '以清净天眼观察护持世界'),
	('402889f657689ac401476670bb74018l', '多闻天王', 9000, 9500, '制服魔众,护持众生财物'),
	('402889f657689ac401476670bb74019l', '文曲星君', 8500, 9000, '聪明才智,一跃龙门'),
	('402889f657689ac401476670bb74020l', '东华帝君', 8000, 8500, '姜子牙——领导男仙，主掌仙籍'),
	('402889f657689ac401476670bb74021l', '福星', 7500, 8000, '掌管天下福瑞'),
	('402889f657689ac401476670bb74022l', '财神', 7000, 7500, '分配天下功名利禄'),
	('402889f657689ac401476670bb74023l', '寿星', 6500, 7000, '保佑长命百岁'),
	('402889f657689ac401476670bb74024l', '纵横始祖', 6000, 6500, '鬼谷子——通天彻地，人不能及'),
	('402889f657689ac401476670bb74025l', '南华真人', 5500, 6000, '庄子——天道无为'),
	('402889f657689ac401476670bb74026l', '文始真人', 5000, 5500, '不行俗礼，隐德行仁'),
	('402889f657689ac401476670bb74027l', '显化真人', 4500, 5000, '张三丰——武当派创立者'),
	('402889f657689ac401476670bb74028l', '诙谐岁星', 4000, 4500, '东方朔——滑稽多智，情圣之首'),
	('402889f657689ac401476670bb74029l', '天师', 3500, 4000, '管理天下道教'),
	('402889f657689ac401476670bb74030l', '平天大圣', 3000, 3500, '牛魔王——魔界魔头，法力无边'),
	('402889f657689ac401476670bb74031l', '混天大圣', 2500, 3000, '鹏魔王——一切智慧忿怒的部主'),
	('402889f657689ac401476670bb74032l', '驱神大圣', 2000, 2500, '拿日月，缩千山，辨休咎，乾坤摩弄'),
	('402889f657689ac401476670bb74033l', '通风大圣', 1500, 2000, '善聆音，能察理，知前后，万物皆明'),
	('402889f657689ac401476670bb74034l', '巨灵神', 1000, 1500, '天生霸气,绝对力量的象征'),
	('402889f657689ac401476670bb74035l', '土地公', 0, 1000, '土豪啊，有土斯有财');
/*!40000 ALTER TABLE `weixin_honor_title` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
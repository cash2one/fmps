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

-- 导出  表 fmps.weixin_customer_service_chatinfo 结构
CREATE TABLE IF NOT EXISTS `weixin_customer_service_chatinfo` (
  `ID` varchar(32) NOT NULL,
  `operatorcode` varchar(32) NOT NULL COMMENT '客服工号',
  `content` varchar(255) DEFAULT NULL COMMENT '消息内容',
  `filepath` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `msgtype` varchar(3) NOT NULL COMMENT '消息类型 001:text 002:image',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客服聊天信息表';

-- 正在导出表  fmps.weixin_customer_service_chatinfo 的数据：~0 rows (大约)
DELETE FROM `weixin_customer_service_chatinfo`;
/*!40000 ALTER TABLE `weixin_customer_service_chatinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `weixin_customer_service_chatinfo` ENABLE KEYS */;


-- 导出  表 fmps.weixin_customer_service_chat_map 结构
CREATE TABLE IF NOT EXISTS `weixin_customer_service_chat_map` (
  `ID` varchar(32) NOT NULL,
  `claim_registno` varchar(100) NOT NULL COMMENT '报案号',
  `message_id` varchar(64) DEFAULT NULL COMMENT '微信消息存储表id',
  `message_source` int(11) NOT NULL COMMENT '消息来源 0：客服 1：客户',
  `message_readed` int(11) NOT NULL COMMENT '客户信息是否读取， 0：未读 1：已读 ',
  `customer_service_id` varchar(32) DEFAULT NULL COMMENT '客服聊天记录id',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='聊天记录映射表';

-- 正在导出表  fmps.weixin_customer_service_chat_map 的数据：~0 rows (大约)
DELETE FROM `weixin_customer_service_chat_map`;
/*!40000 ALTER TABLE `weixin_customer_service_chat_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `weixin_customer_service_chat_map` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

/*
SQLyog v10.2 
MySQL - 5.6.20 : Database - fmps
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fmps` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `fmps`;

/*Table structure for table `webservice_client_management` */

DROP TABLE IF EXISTS `webservice_client_management`;

CREATE TABLE `webservice_client_management` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `clientCode` varchar(10) DEFAULT NULL COMMENT '客户端代码',
  `token` varchar(16) DEFAULT NULL COMMENT '签名用的token为双方约定的16位随机码',
  `AESKey` varchar(43) DEFAULT NULL COMMENT 'AES密钥为双方约定的43位随机码',
  `status` int(1) DEFAULT NULL COMMENT '是否有效 1:有效 0:无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `webservice_client_management` */

insert  into `webservice_client_management`(`id`,`clientCode`,`token`,`AESKey`,`status`) values ('8a8192d849f4ff9e0149f505cb5c0004','100','ABCDEFGHIJKLMNOP','ABCDEFGHIJKLMNOPABCDEFGHIJKLMNOPABCDEFGHIJK',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

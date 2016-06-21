/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50620
Source Host           : 127.0.0.1:3306
Source Database       : fmps

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2015-07-02 14:33:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `weixin_claim_common_words`
-- ----------------------------
DROP TABLE IF EXISTS `weixin_claim_common_words`;
CREATE TABLE `weixin_claim_common_words` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `wordname` varchar(200) DEFAULT NULL COMMENT '话术名称',
  `wordorder` varchar(255) DEFAULT NULL COMMENT '排序',
  `parentwordid` varchar(32) DEFAULT NULL COMMENT '父话术',
  PRIMARY KEY (`ID`),
  KEY `FK_hsbrd7b3keorj8pmxcv8bpahnxp` (`parentwordid`),
  CONSTRAINT `FK_hsbrd7b3keorj8pmxcv8bpahnxp` FOREIGN KEY (`parentwordid`) REFERENCES `weixin_claim_common_words` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信闪赔常用语';

-- ----------------------------
-- Records of weixin_claim_common_words
-- ----------------------------
INSERT INTO `weixin_claim_common_words` VALUES ('1', '系统自发信息', null, null);
INSERT INTO `weixin_claim_common_words` VALUES ('10', '您已经拍好了吗？我还没有收到哦', null, '2');
INSERT INTO `weixin_claim_common_words` VALUES ('11', '您好，可能是信号不太好，您查看一下您照片发送进度情况', null, '2');
INSERT INTO `weixin_claim_common_words` VALUES ('12', '现在各大城市道路状况都不太好，现场理赔员到达现场的时间因受制于堵车、天气、修路等很多原因而不确定。微信闪赔功能就是为了节约您的等待时间，通过您自行拍照，处理简单的小事故。让您无需等待随拍随走。', null, '2');
INSERT INTO `weixin_claim_common_words` VALUES ('13', '您可以先将车开到路边安全的地方，然后在按照微信《拍照指引》进行拍摄现、您的爱车和证件。', null, '2');
INSERT INTO `weixin_claim_common_words` VALUES ('14', '照片已收到$(picturenum)张', null, '2');
INSERT INTO `weixin_claim_common_words` VALUES ('15', '1、损失部位看不清晰的话，我们就不能准确的为您爱车核定修理费用，所以还是麻烦您再拍一次，谢谢！', null, '2');
INSERT INTO `weixin_claim_common_words` VALUES ('16', '2、证件照片是必备的理赔材料，您先忙您的事情，我先帮您核算修理价格，有空了您再给我补齐证件照片。', null, '2');
INSERT INTO `weixin_claim_common_words` VALUES ('17', '$(reportorname)$(reportorsex)，您的事故照片已经齐全，感谢您专业的拍照。您的车辆可以移至安全的地方。', null, '2');
INSERT INTO `weixin_claim_common_words` VALUES ('18', '$(reportorname)$(reportorsex)，您出险的赔案，现我司已完成现场查勘作业，请告知您车辆将要前往维修厂商名称（4S店或综合维修厂）好让我司对您的车辆损失进行维修价格核定。\r\n也可以前往富邦合作厂商，请您在富邦微信内点理赔栏，选择维修平台，里面有我司合作厂商，可以保证维修质量、维修费用不会有差', null, '3');
INSERT INTO `weixin_claim_common_words` VALUES ('19', '好的，请您稍等，我这边尽快根据您选择的维修厂进行定损。', null, '3');
INSERT INTO `weixin_claim_common_words` VALUES ('2', '拍照指引', null, null);
INSERT INTO `weixin_claim_common_words` VALUES ('20', '请您在富邦微信内点理赔栏，选择维修平台，里面有我司合作厂商，可以保证配件为正厂、维修费用不会有差价。', null, '3');
INSERT INTO `weixin_claim_common_words` VALUES ('21', '那您能问一下***平时爱车在哪里维修吗，我尽快为您核定维修价格', null, '3');
INSERT INTO `weixin_claim_common_words` VALUES ('22', '1、那您可以离开现场，然后把司机电话给我，我来帮您处理。', null, '3');
INSERT INTO `weixin_claim_common_words` VALUES ('23', '2、您能现在问一下司机吗，我马上就能为您核定维修价格。', null, '3');
INSERT INTO `weixin_claim_common_words` VALUES ('24', '$(reportorname)$(reportorsex)，您好，根据您选择的厂商，您的车辆定损项目与金额已经完成评估，（说明金额及项目）。若在维修过程中发现隐损或修理厂对价格有异议请随时与我联系，也可以前往富邦合作厂商，请您在富邦微信内点理赔栏，选择维修平台，里面有我司合作厂商，可以保证维修质量、维修费用不会有差', null, '3');
INSERT INTO `weixin_claim_common_words` VALUES ('25', '$(reportorname)$(reportorsex)，您好请问您和被保险的关系，及麻烦提供一下被保险人电话，因后期赔款是否收到，将会回访被保险人，谢谢您的配合！', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('26', '$(reportorname)$(reportorsex)，请您提供爱车被保险人的银行账号和开户行信息。方便我为您支付理赔款。', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('27', '这一点请您放心，我们对价格的评估是基于您拍摄的照片和 ${city}维修行业工时费用标准核定的，为了保证您的安全和爱车的可靠性，配件也全部是按照原厂价格核定。\r\n若有修理厂商要价过高，可以前往富邦合作厂商，请您在富邦微信内点理赔栏，选择维修平台，里面有我司合作厂商，可以保证维修质量、维修费用不会有差', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('28', '如果您拍照的照片没有反映出全部损失或者车辆内部有损坏配件，请及时联系我或拨打4008817518我们会及时安排富邦保险定损专员为您提供追加定损及赔付服务。', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('29', '那麻烦您联系一下他本人，尽快提供给我们，谢谢。', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('3', '定损问题', null, null);
INSERT INTO `weixin_claim_common_words` VALUES ('30', '为了保证您的资金安全和转账速度，请您使用带有银联标志的国有或股份制商业银行的银行账户。这里我们建议您优先使用大中型商业银行的银行账号和准确的开户行信息', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('31', '您可以拨打银行卡上的电话向银行免费咨询。', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('32', '暂不支持支付信用卡', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('33', '实在抱歉，根据《反洗钱法》和保监会要求，所有商业保险公司财产险项下理赔款项都必须转账给被保险人。', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('34', '发票做为您维修及付款凭证，本次事故发票由您自行保存。', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('35', '要是后期确实有增补项目或是金额不够，我们会按照实际损失情况为您追加赔款。若有修理厂商要价过高，可以前往富邦合作厂商，请您在富邦微信内点理赔栏，选择维修平台，里面有我司合作厂商，可以保证维修质量、维修费用不会有差价。', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('36', '微信闪赔业务是保险公司正规的案件受理渠道，都是经过监管部门批准的，我们的微信记录也会长期保存。您可以放心使用。', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('37', '$(reportorname)$(reportorsex)，本次案件已处理完毕，您可以离开现场了，案件审核通过后，我们会及时将赔款支付到您的（被保险人）提供的账户中，请注意查收！\r\n如事后还有需要为您服务的随时与我联系（工作日0592-5353666-51022）或拨打我司客服电话4008817518联系，很高兴为', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('38', '感谢您的配合，有疑问的话，可以在微信平台再次输入您的手机号码联系我们。', null, '4');
INSERT INTO `weixin_claim_common_words` VALUES ('39', '现场我们已经处理完毕，您可以先行离开。关于配件项目是否更换，您车辆到您选择的修理厂后，麻烦修理厂联系我司工作人员，或至开至厦门定损中心定损，我司工作人员会配合修理厂工作人员进行拆解，在进行核定是否达到更换。', null, '5');
INSERT INTO `weixin_claim_common_words` VALUES ('4', '赔付问题', null, null);
INSERT INTO `weixin_claim_common_words` VALUES ('40', '您好，根据现场的受损情况比较严重，我这边将会为您安排现场的同事配合您处理', null, '5');
INSERT INTO `weixin_claim_common_words` VALUES ('41', '您好，$(reportorname)$(reportorsex)，经查您的车辆受损比较严重，我这边会转现场同事到现场配合您处理，请您电话保持畅通，谢谢！', null, '5');
INSERT INTO `weixin_claim_common_words` VALUES ('42', '电话联系，转现场', null, '5');
INSERT INTO `weixin_claim_common_words` VALUES ('5', '疑难问题', null, null);
INSERT INTO `weixin_claim_common_words` VALUES ('6', '个人常用语', null, null);
INSERT INTO `weixin_claim_common_words` VALUES ('7', '您好，富邦微信理赔专员$(operatorname)，工号$(operatorcode)，为了减少您的等待时间，在此为您服务！', null, '1');
INSERT INTO `weixin_claim_common_words` VALUES ('8', '$(reportorname)$(reportorsex)您好，感谢您使用微信自助理赔，请在确保您安全的情况下，按微信《拍照指引手册》进行拍摄您的爱车和证件，以便于我们尽快处理完本次事故。', null, '1');
INSERT INTO `weixin_claim_common_words` VALUES ('9', '我们微信理赔专员会在线指导您，只要您拍摄的照片清晰齐全，您就可以离开现场了，随后的损失核定和赔付都不会占用您的时间和影响您的行程。\r\n请尽快按照拍照指南进行拍照吧！', null, '2');

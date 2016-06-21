/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.com.fubon.webservice;

/**
 * WebService常量定义.
 * 
 * @author binbin.wang
 */
public class WsConstants {

	/** 项目内统一的NameSpace定义 **/
	public static final String NS = "http://ws.fubon.com.cn";

	/** 核心系统WebService NameSpace定义 **/
	public static final String CORE_SYSTEM_NS = "http://webservice.quotation.fubon.com";

	/** WebService调用入口URL地址Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_ENTRY_URL = "WS_ENTRY_URL";

	/** WebService调用方法Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_METHOD_NAME = "WS_METHOD_NAME";

	/** WebService调用tns的Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_TARGET_NAMESPACE = "WS_TARGET_NAMESPACE";

	/** 富邦WebService请求Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_REQUEST = "WS_REQUEST";

	/** 富邦WebService响应Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_RESPOSNE = "WS_RESPOSNE";

	/** 外部WebService请求Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_EXTERNL_REQUEST = "WS_EXTERNL_REQUEST";

	/** 富邦WebService请求XML格式Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_REQUEST_XML = "WS_REQUEST_XML";

	/** 外部WebService请求XML格式Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_EXTERNL_REQUEST_XML = "WS_EXTERNL_REQUEST_XML";

	/** 外部WebService响应Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE = "WS_EXTERNL_RESPONSE";

	/** 外部WebService响应XML格式Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML = "WS_EXTERNL_RESPONSE_XML";

	/** webservice响应处理类 Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_RESPONSE_HANDLER = "WS_RESPONSE_HANDLER";

	/** 是否异步调用Key值 **/
	public static final String CHAIN_CONTEXT_KEY_WS_IS_ASYNC_INVOKE = "WS_IS_ASYNC_INVOKE";

	/** 外部请求类类型Key值 **/
	public static final String CHAIN_CONTEXT_KEY_EXTERNL_REQEUST_CLASS_NAME = "EXTERNL_REQUEST_CLASS_NAME";

	/** 外部响应类类型Key值 **/
	public static final String CHAIN_CONTEXT_KEY_EXTERNL_RESPONSE_CLASS_NAME = "EXTERNL_RESPONSE_CLASS_NAME";

	public static final String REQUEST_HEAD_KEY_SERVER_CODE = "FMPS";

	public static final String REQUEST_HEAD_KEY_SERVER_CODE_CORE = "CORE";

	public static final String REQUEST_HEAD_KEY_SERVER_CODE_CLAIM = "CLAIM";

	public static final String REQUEST_HEAD_KEY_SERVER_CODE_WECHAT = "WECHAT";

	public static final String REQUEST_HEAD_KEY_CLIENT_CODE_COREOS = "100";

	/** 核心系统交易码:微信用户绑定 **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_1 = "1";

	/** 核心系统交易码:微信理赔根据报案电话获取报案信息 **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_2 = "CLM001";

	/** 核心系统交易码:微信理赔发送理赔照片信息至核心 **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_3 = "CLM002";

	/** 核心系统交易码:微信理赔金额确认成功后调用webservice **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_4 = "40";
	
	/** 核心系统交易码:微信理赔根据报案电话获取非车报案信息 **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_5 = "CLM003";

	/** 核心系统交易码:微信理赔发送非车理赔照片信息至核心 **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_6 = "CLM004";
	
	/** 核心系统交易码:新车上牌 **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_42 = "42";

	/** 核心系统交易码:微信发送过来的报文 **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_30 = "30";
	
	/** 核心系统交易码:微信发送给核心承保报文 **/
	public static final String REQUEST_HEAD_KEY_TRANSATION_CODE_PRP01 = "PRP01";

	/** XML声明 **/
	public static final String XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	/** 返回给理赔客户端的返回码 0000：成功 **/
	public static final String RETURNCODE_1 = "0000";

	/** 返回给理赔客户端的返回码 0001：clientCode无效或不存在 **/
	public static final String RETURNCODE_2 = "0001";

	/** 返回给理赔客户端的返回码 0002：验签失败 **/
	public static final String RETURNCODE_3 = "0002";

	/** 返回给理赔客户端的返回码 0003：请求报文解密失败 **/
	public static final String RETURNCODE_4 = "0003";

	/** 返回给理赔客户端的返回码 0004：响应报文加密失败 **/
	public static final String RETURNCODE_5 = "0004";

	/** 返回给理赔客户端的返回码 0005：openid为空 **/
	public static final String RETURNCODE_6 = "0005";

	/** 返回给理赔客户端的返回码 9999：其他未知错误 **/
	public static final String RETURNCODE_9 = "9999";

	/** 返回给ws客户端的返回消息：成功 **/
	public static final String RETURNMESSAGE_1 = "成功";
	/** 返回给ws客户端的返回消息：ok **/
	public static final String RETURNMESSAGE_OK = "ok";

	/** 返回给ws客户端的返回消息：成功clientCode无效或不存在 **/
	public static final String RETURNMESSAGE_2 = "clientCode无效或不存在";

	/** 返回给ws客户端的返回消息：验签失败 **/
	public static final String RETURNMESSAGE_3 = "验签失败";

	/** 返回给ws客户端的返回消息：请求报文解密失败 **/
	public static final String RETURNMESSAGE_4 = "请求报文解密失败";

	/** 返回给ws客户端的返回消息：响应报文加密失败 **/
	public static final String RETURNMESSAGE_5 = "响应报文加密失败";

	/** 返回给ws客户端的返回消息：openid为空 **/
	public static final String RETURNMESSAGE_6 = "openid为空";

	/** 返回给ws客户端的返回消息：交易报文加密失败 **/
	public static final String RETURNMESSAGE_7 = "交易报文加密失败";

	/** 返回给ws客户端的返回消息：交易报文解密失败 **/
	public static final String RETURNMESSAGE_8 = "交易报文解密失败";

	/** 返回给ws客户端的返回消息：其他未知错误 **/
	public static final String RETURNMESSAGE_9 = "其他未知错误";

	/** 理赔处理方式:1 传统理赔 **/
	public static final String CLAIM_CASE_HANDLE_WAY_1 = "1";

	/** 理赔案件状态:110 核赔提交 **/
	public static final Integer CLAIM_CASE_STATUS_110 = 110;

	/** webservice卡单激活验卡及投保 URL **/
	public static final String CORE_SYSTEM_PRPAR = "http://10.1.20.101:7002/prpall/EiesServer?SVCCODE=09";

	/** WebService重构定义的变量名：响应报文 **/
	public static final String RESPONSEJSON = "responseJson";

	/** WebService重构定义的变量名：AES加解密key **/
	public static final String AESKEY = "key";

	/** WebService重构定义的变量名：解密后的inputJson **/
	public static final String INPUTJSON = "inputJson";

	/** restful方式WebService请求报文key **/
	public static final String CHAIN_CONTEXT_KEY_WS_INPUTJSON = "WS_INPUTJSON";

	/** restful方式WebService响应报文key **/
	public static final String CHAIN_CONTEXT_KEY_WS_RESPONSEJSON = "WS_RESPONSEJSON";

	/** restful方式WebService TOKEN key **/
	public static final String CHAIN_CONTEXT_KEY_WS_TOKEN = "WS_TOKEN";

	/** restful方式WebService AESKEY key **/
	public static final String CHAIN_CONTEXT_KEY_WS_AESKEY = "WS_AESKEY";
	
	/** restful方式WebService secretKey **/
	public static final String CHAIN_CONTEXT_KEY_WS_secretKey = "WS_secretKey";

	/** restful方式WebService CLIENTCODE key **/
	public static final String CHAIN_CONTEXT_KEY_WS_CLIENTCODE = "WS_CLIENTCODE";
}

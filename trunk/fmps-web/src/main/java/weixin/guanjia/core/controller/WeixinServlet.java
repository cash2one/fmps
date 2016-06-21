package weixin.guanjia.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.account.service.impl.WeixinAccountServiceImpl;
import weixin.guanjia.core.service.impl.WechatService;
import weixin.guanjia.core.util.MessageUtil;
import weixin.guanjia.core.util.SignUtil;
import cn.com.fubon.exceptions.InvalidMessageException;

/**
 * 核心请求处理类
 * 
 * @author 捷微团队
 * @date 2013-05-18
 */
public class WeixinServlet extends HttpServlet {
	private static final long serialVersionUID = 4440739483644821986L;
	@Autowired
	private WeixinAccountServiceI weixinAccountService;

	@Override
	public void init() throws ServletException {
		weixinAccountService = new WeixinAccountServiceImpl();
	}

	/**
	 * 确认请求来自微信服务器
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();
		List<WeixinAccountEntity> weixinAccountEntities = weixinAccountService
				.getList(WeixinAccountEntity.class);
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		for (WeixinAccountEntity account : weixinAccountEntities) {
			if (SignUtil.checkSignature(account.getAccounttoken(), signature,
					timestamp, nonce)) {
				out.print(echostr);
			}
		}
		out.close();
		out = null;
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String respMessage = "";
		Map<String, String> requestMap = null;

		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		WechatService wechatService = new WechatService();
		try {
			// xml请求解析
			requestMap = MessageUtil.parseXml(request);
			
			//TODO:将原始报文写入数据库

			// 判断是否为发送给当前微信用户的消息
			List<WeixinAccountEntity> weixinAccountEntities = weixinAccountService
					.getList(WeixinAccountEntity.class);
			// 暂时只支持一个微信公众账号
			WeixinAccountEntity account = weixinAccountEntities.get(0);
			String ToUserName = requestMap.get("ToUserName");
			if (ToUserName.equals(account.getAccountname())) {
				throw new InvalidMessageException("该报文的接收账号是：" + ToUserName
						+ "，为非法消息。");
			}

			// TODO： 判断请求是否经过验签名

			// 调用核心业务类接收消息、处理消息			
			respMessage = wechatService.coreService(request);
		} catch (InvalidMessageException ime) {
			LogUtil.info("非法消息", ime);
		} catch (Exception e) {
			LogUtil.info("解析微信端请求出错", e);
		}

		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();
	}
}

package weixin.guanjia.core.entity.message.resp;

import weixin.util.WeiXinConstants;

public class TextMessageResp extends BaseMessageResp {
	// 回复的消息内容
	private String Content;

	public TextMessageResp() {
		this.MsgType = WeiXinConstants.RESP_MESSAGE_TYPE_TEXT;
	}
	
	public TextMessageResp(String content) {
		super();
		this.Content = content;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}

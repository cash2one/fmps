/**
 * 
 */
package weixin.guanjia.core.entity.message.resp;

import weixin.util.WeiXinConstants;

/**
 * 图片消息
 * 
 * @author pollux
 *
 */
public class ImageMessageResp extends BaseMessageResp {

	private Image image;

	public ImageMessageResp() {
		this.MsgType = WeiXinConstants.RESP_MESSAGE_TYPE_IMAGE;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}

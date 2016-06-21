/**
 * 
 */
package weixin.guanjia.core.entity.message.resp;

import weixin.guanjia.core.util.MessageUtil;
import weixin.util.WeiXinConstants;

/**
 * @author pollux
 *
 */
public class VideoMessageResp extends BaseMessageResp {

	private Video video;

	public VideoMessageResp() {
		this.MsgType = WeiXinConstants.RESP_MESSAGE_TYPE_VIDEO;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}

/**
 * 
 */
package weixin.guanjia.core.entity.message.resp;

import weixin.util.WeiXinConstants;

/**
 * @author pollux
 *
 */
public class VoiceMessageResp extends BaseMessageResp {

	private Voice voice;

	public VoiceMessageResp() {
		this.MsgType = WeiXinConstants.RESP_MESSAGE_TYPE_VOICE;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
}

package weixin.guanjia.core.entity.message.resp;

import weixin.guanjia.core.util.MessageUtil;
import weixin.util.WeiXinConstants;

/**
 * 音乐消息
 * 
 * @author Administrator
 *
 */
public class MusicMessageResp extends BaseMessageResp {
	// 音乐
	private Music Music;

	public MusicMessageResp() {
		this.MsgType = WeiXinConstants.RESP_MESSAGE_TYPE_MUSIC;
	}

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}

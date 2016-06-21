package weixin.guanjia.core.entity.message.req;

/**
 * 音频消息
 * 
 * @author 捷微团队
 * @date 2013-05-19
 */
public class VoiceMessage extends BaseMessage {
	// 语音格式
	private String Format;
	// 媒体ID
	private String MediaId;
	// 语音识别结果
	private String Recognition;

	public String getFormat() {
		return Format;
	}

	public String getMediaId() {
		return MediaId;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
}

/**
 * 
 */
package weixin.guanjia.core.entity.message.resp;

/**
 * @author pollux
 *
 */
public class Video {

	// 媒体文件ID
	private String mediaId;

	// 缩略图的媒体ID
	private String thumbMediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
}

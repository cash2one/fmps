/**
 * 
 */
package weixin.guanjia.core.entity.message.resp;

/**
 * 图片model
 * 
 * @author pollux
 *
 */
public class Image {

	private String mediaId;
	
	public Image(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}

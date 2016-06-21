package weixin.guanjia.core.entity.message.event;

public class SubscribeEvent extends BaseEvent {
	
	//扫码预设KEY
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	 

}

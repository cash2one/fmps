package weixin.guanjia.core.entity.message.event;
/**
 * 模板消息事件处理
 * @author fangfang.guo
 *
 */
public class TemplateSendJobFinishEvent extends BaseEvent {
	
	//发送状态:success成功;failed:user block用户拒绝接收;failed: system failed发送失败（非用户拒绝）
	// 重新封装的微信模板消息送达状态 0：成功；1：用户拒绝接收；2：发送失败（非用户拒绝）；
	private Integer Status;
	//模板消息id
	private String MsgID;

	public Integer getStatus(){
		return Status;
	}

	public void setStatus(Integer status){
		Status = status;
	}

	public String getMsgID() {
		return MsgID;
	}

	public void setMsgID(String msgID) {
		MsgID = msgID;
	}

}

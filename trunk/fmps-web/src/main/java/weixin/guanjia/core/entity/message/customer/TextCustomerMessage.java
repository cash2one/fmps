package weixin.guanjia.core.entity.message.customer;

import java.io.IOException;
import java.io.StringWriter;

import net.sf.json.JSONObject;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TextCustomerMessage extends BaseCustomerMessage {

	private Text text;

	public TextCustomerMessage() {
		this.msgtype = "text";
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Text getText() {
		return text;
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		TextCustomerMessage tcm = new TextCustomerMessage();
		tcm.setTouser("touser_openid");
		Text t = new Text("this is content");
		
		ObjectMapper mapper = new ObjectMapper();
		StringWriter sw = new StringWriter();
		JsonGenerator jsonGen = new JsonFactory().createJsonGenerator(sw);
		mapper.writeValue(jsonGen, tcm);
		jsonGen.close();
		
		
		JSONObject jsonObj = JSONObject.fromObject(tcm);
		System.out.println(jsonObj.toString());
	}
}

package weixin.popular.bean.templatemessage;

public class TemplateMessageItem{

	/*
	 * 需要有默认构造方法,否则json转TemplateMessage对象会出错
	 */
	public TemplateMessageItem(){

	}

	private String value;

	private String color;

	public TemplateMessageItem(String value,String color){
		super();
		this.value = value;
		this.color = color;
	}

	public String getValue(){
		return value;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getColor(){
		return color;
	}

	public void setColor(String color){
		this.color = color;
	}

}

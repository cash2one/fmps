package cn.com.fubon.businessReminder.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;

import cn.com.fubon.businessReminder.entity.NewCarMsgEntity;

import com.alibaba.fastjson.JSON;

public class ReflectUtil{

    /**
     * 将jdbcTemplate查询的map结果集 反射生成对应的bean
     * @param clazz 意向反射的实体.clazz
     * @param jdbcMapResult 查询结果集
     * @return 
     * @see
     */
	public static <T> T reflect(Class<T> clazz, Map<String, Object> jdbcMapResult) {
		// 获得
		Field[] fields = clazz.getDeclaredFields();

		// 存放field和column对应关系，该关系来自于实体类的 @Column配置
		Map<String/* field name in modelBean */, String/* column in db */> fieldHasColumnAnnoMap = new LinkedHashMap<String, String>();
		Annotation[] annotations = null;
		for (Field field : fields) {
			annotations = field.getAnnotations();
			for (Annotation an : annotations) {
				if (an instanceof Column) {
					Column column = (Column) an;
					fieldHasColumnAnnoMap.put(field.getName(), column.name());
				}
			}
		}
		// 存放field name 和 对应的来自map的该field的属性值，用于后续reflect成ModelBean
		Map<String, Object> conCurrent = new LinkedHashMap<String, Object>();
		for (Map.Entry<String, String> en : fieldHasColumnAnnoMap.entrySet()) {
			// 将column大写。因为jdbcMapResult key is UpperCase
//			String key = en.getValue().toUpperCase();
			String key = en.getValue();

			// 获得map的该field的属性值
			Object value = jdbcMapResult.get(key);

			// 确保value有效性，防止JSON reflect时异常
			if (value != null) {
				conCurrent.put(en.getKey(), jdbcMapResult.get(key));
			}
		}
		// fastjson reflect to modelbean
		return JSON.parseObject(JSON.toJSONString(conCurrent), clazz);
	}

    
	/**
	 * test example
	 * 
	 * @param args
	 * @throws Exception
	 * @see
	 */
	public static void main(String[] args) throws Exception {
		Map<String, Object> jdbcMapResult = new HashMap<>();
		jdbcMapResult.put("sex", "女士");
		jdbcMapResult.put("openid", "testopenidzhenzhen");
		jdbcMapResult.put("id", "1FADCD7E630D02CBE053A414010AB44D");
		jdbcMapResult.put("msgtype", "1");
		jdbcMapResult.put("sendstatus", "0");
		jdbcMapResult.put("identifynumber", "350103197211240060");
		jdbcMapResult.put("insuredname", "陈文健");
		jdbcMapResult.put("brandname", "欧蓝德OUTLANDER 2.4L越野车");
		jdbcMapResult.put("engineno", "PA48484J10");
		jdbcMapResult.put("frameno", "JE3AZ5939EZ015550");
		jdbcMapResult.put("policyno", "805072015350101003080");
		jdbcMapResult.put("licenseno", "PA48484J12");
		jdbcMapResult.put("nextsendtime", "2015-09-14 11:38:45.0");

		NewCarMsgEntity msg = ReflectUtil.reflect(NewCarMsgEntity.class, jdbcMapResult);
		System.out.println(msg.getSex());
		System.out.println(msg.getOpenid());
		System.out.println(msg.getId());
		System.out.println(msg.getMsgtype());
		System.out.println(msg.getSendstatus());
		System.out.println(msg.getIdentifynumber());
		System.out.println(msg.getInsuredname());
		System.out.println(msg.getBrandname());
		System.out.println(msg.getEngineno());
		System.out.println(msg.getFrameno());
		System.out.println(msg.getPolicyno());
		System.out.println(msg.getLicenseno());
		System.out.println(msg.getNextsendtime());
	}
}
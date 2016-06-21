/**
 * 
 */
package cn.com.fubon.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.dozer.util.ReflectionUtils;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author binbin.wang
 *
 */
public class MapConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		return Reflections.hasContainInteface(type, Map.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {		
		Map map = (Map) source;  
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {  
            Entry entry = (Entry) iterator.next();  
            ExtendedHierarchicalStreamWriterHelper.startNode(writer, entry.getKey().toString(), Entry.class);  
  
            writer.setValue(entry.getValue().toString());  
            writer.endNode();  
        }  
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		Map<String, Object> map = (Map<String, Object>) populateMap(reader, context);
		return map;
	}
	
	protected Object populateMap(HierarchicalStreamReader reader,
			UnmarshallingContext context) {		
		Map<String, Object> map = new HashMap<String, Object>();
		while(reader.hasMoreChildren()) {
			reader.moveDown();
			String key = reader.getNodeName();
			Object value = null;
			
			if (reader.hasMoreChildren())
				value = populateMap(reader, context);
			else
				value = reader.getValue();
			
			map.put(key, value);
			
			reader.moveUp();
		}
		
		return map;
	}

}











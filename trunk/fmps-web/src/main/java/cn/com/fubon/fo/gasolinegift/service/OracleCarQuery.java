package cn.com.fubon.fo.gasolinegift.service;

import java.util.List;
import java.util.Map;
public interface OracleCarQuery    {
	
	public List<Map<String, Object>> queryOracleCarLicensenoList(String insuredname,String identifynumber );

}

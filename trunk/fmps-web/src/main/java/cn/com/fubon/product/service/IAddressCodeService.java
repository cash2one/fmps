/**
 * 
 */
package cn.com.fubon.product.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

/**
 * @author guojunjie
 *
 */
public interface IAddressCodeService extends CommonService {

	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);

	public <T> List<T> getList(Class clas);

	/**
	 * 根据cityCode查找区域codeList
	 * 
	 * @param cityCode
	 * @return
	 */
	public List<Map<String, Object>> findCountyCodeListbyCityCode(
			String cityCode);

	/**
	 * 根据cityCode查找区域名称List
	 * 
	 * @param cityCode
	 * @return
	 */
	public List<Map<String, Object>> findCountyListbyCityCode(String cityCode);

	/**
	 * 根据provinceCode查找城市cityList
	 * 
	 * @param provinceCode
	 * @return
	 */
	public List<Map<String, Object>> findCityCodeListbyProvinceCode(
			String provinceCode);

	/**
	 * 根据provinceCode查找城市名称List
	 * 
	 * @param provinceCode
	 * @return
	 */
	public List<Map<String, Object>> findCityListbyProvinceCode(
			String provinceCode);

	/**
	 * 查找省份codeList
	 * 
	 * @return
	 */
	public List<String> findProvinceList();

	/**
	 * 查找省份名称List
	 * 
	 * @return
	 */
	public List<String> findProvinceCodeList();

	/**
	 * 根据产品id查找投保须知列表
	 * 
	 * @param productid
	 * @return
	 */
	public String findDocumentListByProductid(String productid);

	/**
	 * 根据产品id查找保险条款列表
	 * 
	 * @param productid
	 * @return
	 */
	public List<Map<String, Object>> findArticleListByProductid(String productid);

	/**
	 * 根据产品id查找保险条款标题列表
	 * 
	 * @param productid
	 * @return
	 */
	public List<Map<String, Object>> findArticleListByProductid2(
			String productid);
}

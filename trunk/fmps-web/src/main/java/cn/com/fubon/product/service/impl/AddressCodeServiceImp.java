/**
 * 
 */
package cn.com.fubon.product.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.product.service.IAddressCodeService;

/**
 * 卡单激活模块service
 * 
 * @author guojunjie
 *
 */
@Service("addressCodeService")
@Transactional
public class AddressCodeServiceImp extends CommonServiceImpl implements
		IAddressCodeService {
	private static final Logger logger = Logger
			.getLogger(AddressCodeServiceImp.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}

	/**
	 * 根据cityCode查找区域codeList
	 * 
	 * @param cityCode
	 * @return
	 */
	public List<Map<String, Object>> findCountyCodeListbyCityCode(
			String cityCode) {
		String sql = " select countyCode from weixin_address_code as t "
				+ " where  t.cityCode=? ORDER BY t.countyCode asc";
		List<Map<String, Object>> countyCodeList = new ArrayList<Map<String, Object>>();
		countyCodeList = this.findForJdbc(sql, cityCode);
		return countyCodeList;
	}

	/**
	 * 根据cityCode查找区域名称List
	 * 
	 * @param cityCode
	 * @return
	 */
	public List<Map<String, Object>> findCountyListbyCityCode(String cityCode) {
		String sql = " select county from weixin_address_code as t "
				+ " where  t.cityCode=? ORDER BY t.countyCode asc";

		List<Map<String, Object>> countyList = new ArrayList<Map<String, Object>>();
		countyList = this.findForJdbc(sql, cityCode);
		return countyList;
	}

	/**
	 * 根据provinceCode查找城市cityList
	 * 
	 * @param provinceCode
	 * @return
	 */
	public List<Map<String, Object>> findCityCodeListbyProvinceCode(
			String provinceCode) {

		String sql = " select cityCode from weixin_address_code as t "
				+ " where not exists(select * from weixin_address_code "
				+ " where city = t.city and id < t.id) and t.provinceCode=? ORDER BY t.cityCode asc";
		List<Map<String, Object>> cityCodeList = new ArrayList<Map<String, Object>>();
		cityCodeList = this.findForJdbc(sql, provinceCode);
		return cityCodeList;
	}

	/**
	 * 根据provinceCode查找城市名称List
	 * 
	 * @param provinceCode
	 * @return
	 */
	public List<Map<String, Object>> findCityListbyProvinceCode(
			String provinceCode) {
		String sql = " select city from weixin_address_code as t "
				+ " where not exists(select * from weixin_address_code "
				+ " where city = t.city and id < t.id) and t.provinceCode=? ORDER BY t.cityCode asc";
		List<Map<String, Object>> cityList = new ArrayList<Map<String, Object>>();
		cityList = this.findForJdbc(sql, provinceCode);

		return cityList;
	}

	/**
	 * 查找省份codeList
	 * 
	 * @return
	 */
	public List<String> findProvinceList() {
		String sql = " select province from weixin_address_code as t "
				+ " where not exists(select * from weixin_address_code "
				+ " where province = t.province and id < t.id) ORDER BY t.provinceCode asc";

		return commonDao.findListbySql(sql);
	}

	/**
	 * 查找省份名称List
	 * 
	 * @return
	 */
	public List<String> findProvinceCodeList() {
		String sql = " select provinceCode from weixin_address_code as t "
				+ " where not exists(select * from weixin_address_code "
				+ " where province = t.province and id < t.id) ORDER BY t.provinceCode asc";

		return commonDao.findListbySql(sql);
	}

	/**
	 * 根据产品id查找投保须知列表
	 * 
	 * @param productid
	 * @return
	 */
	public String findDocumentListByProductid(String productid) {
		String sql = "select document from weixin_product_affiliated where type=2 and productid=?";
		List<Map<String, Object>> documentList = new ArrayList<Map<String, Object>>();
		documentList = this.findForJdbc(sql, productid);

		String str = "";
		// List<String> strs = commonDao.findListbySql(sql);

		if (documentList.size() > 0) {
			str = (String) documentList.get(0).get("document");
		}
		return str;
	}

	/**
	 * 根据产品id查找保险条款列表
	 * 
	 * @param productid
	 * @return
	 */
	public List<Map<String, Object>> findArticleListByProductid(String productid) {
		String sql = "select document,description from weixin_product_affiliated where type=1 and productid=? order by productid asc";

		List<Map<String, Object>> articleList = new ArrayList<Map<String, Object>>();
		articleList = this.findForJdbc(sql, productid);
		return articleList;
	}

	/**
	 * 根据产品id查找保险条款标题列表
	 * 
	 * @param productid
	 * @return
	 */
	public List<Map<String, Object>> findArticleListByProductid2(
			String productid) {
		String sql = "select description from weixin_product_affiliated where type=1 and productid=? order by productid asc";
		List<Map<String, Object>> articleList = new ArrayList<Map<String, Object>>();
		articleList = this.findForJdbc(sql, productid);
		return articleList;
	}
}

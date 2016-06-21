/**
 * 
 */
package cn.com.fubon.fo.card.service.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.card.entity.ContractAddress;
import cn.com.fubon.fo.card.service.IContractAddressService;

/**
 * 卡单激活模块service
 * 
 * @author guojunjie
 *
 */
@Service("contractAddressService")
@Transactional
public class ContractAddressServiceImp extends CommonServiceImpl implements
		IContractAddressService {
	private static final Logger logger = Logger
			.getLogger(ContractAddressServiceImp.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}
	@Override
	public ContractAddress getContractAddress( String policyno, String provincecode,String citycode, String countycode, String insuredaddress){
		
		ContractAddress contractAddress=new ContractAddress();
		contractAddress.setPolicyno(policyno);
		contractAddress.setProvincecode(provincecode);		
		contractAddress.setCitycode(citycode);
		contractAddress.setCountycode(countycode);
		contractAddress.setInsuredaddress(insuredaddress);
		this.save(contractAddress);
		return contractAddress;
	}
	
	
}

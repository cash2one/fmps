package cn.com.fubon.webservice.externl.telesalesystem.resphandler;

/**
 * 电销webservice返回处理,获取订单信息
 * @author fangfang.guo
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.jeecgframework.core.common.service.CommonService;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.pay.entity.WeiXinOfflineOrderDetail;
import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.util.MD5Utils;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWSConstants;
import cn.com.fubon.webservice.externl.telesalesystem.entity.PrpTitemkind;
import cn.com.fubon.webservice.externl.telesalesystem.entity.Risklist;
import cn.com.fubon.webservice.externl.telesalesystem.entity.TelesaleResponse;

@Transactional(rollbackFor = Exception.class)
public class GetPayInfoTelesaleResponseHandler implements
		TelesaleResponseHandler {
	@Resource
	private Mapper mapper;
	@Resource
	private CommonService commonService;

	@Override
	public WeiXinOfflineOrderInfo process(TelesaleResponse telesaleResponse) {
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = null;

		weiXinOfflineOrderInfo = commonService.findUniqueByProperty(
				WeiXinOfflineOrderInfo.class, "payCode", telesaleResponse
						.getTelesaleResponseHead().getPayCode());

		// 如果支付码可用状态005且订单在数据库中不存在则保存
		if (TelesaleWSConstants.PAYCODESTATUS_5.equals(telesaleResponse
				.getTelesaleResponseHead().getPayCodeStatus())
				&& weiXinOfflineOrderInfo == null) {
			SimpleDateFormat dateformat1 = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
			String startDate = telesaleResponse.getTelesaleResponseProposal()
					.getStartDate();
			if (startDate.contains("/")) {
				try {
					startDate = dateformat2
							.format(dateformat1.parse(startDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			telesaleResponse.getTelesaleResponseProposal().setStartDate(
					startDate);
			// xml报文得到的response对象转成订单对象
			weiXinOfflineOrderInfo = mapper.map(telesaleResponse,
					WeiXinOfflineOrderInfo.class);
			String paycode = weiXinOfflineOrderInfo.getPayCode();
			weiXinOfflineOrderInfo.setPaycodemd5(MD5Utils.MD5(paycode));
			// 保存订单对象
			commonService.save(weiXinOfflineOrderInfo);
			List<Risklist> risklists = ((TelesaleResponse) telesaleResponse).getTelesaleResponseProposal().getRisklist();
			List<PrpTitemkind> prpTitemkindList = null;
			WeiXinOfflineOrderDetail weiXinOfflineOrderDetail =null;
			List<WeiXinOfflineOrderDetail> weiXinOfflineOrderDetails=new ArrayList<WeiXinOfflineOrderDetail>();
			for(Risklist risk : risklists){
				prpTitemkindList = risk.getPrpTitemkindList();	
				weiXinOfflineOrderDetail=new WeiXinOfflineOrderDetail();
				for (PrpTitemkind iPrpTitemkind : prpTitemkindList) {
					weiXinOfflineOrderDetail = mapper.map(iPrpTitemkind,WeiXinOfflineOrderDetail.class);
					weiXinOfflineOrderDetail.setRiskname(risk.getRiskname());
					weiXinOfflineOrderDetail.setSubpremium(risk.getSubpremium());
					weiXinOfflineOrderDetail.setOrderInfo(weiXinOfflineOrderInfo);
					weiXinOfflineOrderDetails.add(weiXinOfflineOrderDetail);
					// 保存订单详细
					commonService.save(weiXinOfflineOrderDetail);
				}
			}
			weiXinOfflineOrderInfo.setWeiXinOfflineOrderDetails(weiXinOfflineOrderDetails);
		}

		return weiXinOfflineOrderInfo;
	}

	@Override
	public WeiXinOfflineOrderInfo asyncExecuteprocess(
			TelesaleResponse telesaleResponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSendFailure(FbWSRequest fbWSRequest) {
		// TODO Auto-generated method stub

	}

}

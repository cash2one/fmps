package cn.com.fubon.webservice.externl.telesalesystem.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 险种列表
 * @author fbxmn07
 *
 */
public class Risklist {
		//险种名称
		@XStreamAlias("RISKNAME")
		private String riskname;
		//险种保费
		@XStreamAlias("SUBPREMIUM")
		private String subpremium;
		//商业险信息
		@XStreamAlias("PRPTITEMKINDLIST")
		private List<PrpTitemkind> prpTitemkindList;
		
		public String getRiskname() {
			return riskname;
		}
		public void setRiskname(String riskname) {
			this.riskname = riskname;
		}
		public String getSubpremium() {
			return subpremium;
		}
		public void setSubpremium(String subpremium) {
			this.subpremium = subpremium;
		}
		public List<PrpTitemkind> getPrpTitemkindList() {
			return prpTitemkindList;
		}
		public void setPrpTitemkindList(List<PrpTitemkind> prpTitemkindList) {
			this.prpTitemkindList = prpTitemkindList;
		}
}

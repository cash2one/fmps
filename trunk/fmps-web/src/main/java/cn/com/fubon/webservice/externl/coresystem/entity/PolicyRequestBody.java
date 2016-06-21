/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 投保请求报文body
 * 
 * @author qingqu.huang
 *
 */
public class PolicyRequestBody {
	@XStreamAlias("INSURED_LIST")
	private List<Insured> insured_list;
	@XStreamAlias("APPLICANT")
	private Applicant applicant;
	@XStreamAlias("INSURANCECARD")
	private InsuranceCard ic;
	@XStreamAlias("INSURANCE_PERIOD")
	private Period period;
	@XStreamAlias("PROPERT_REPOSE_ADDRESS_LIST")
	private List<Address> address;
	@XStreamAlias("FROM")
	private String from;

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	/**
	 * @return the insured_list
	 */
	public List<Insured> getInsured_list() {
		return insured_list;
	}

	/**
	 * @param insured_list
	 *            the insured_list to set
	 */
	public void setInsured_list(List<Insured> insured_list) {
		this.insured_list = insured_list;
	}

	/**
	 * @return the applicant
	 */
	public Applicant getApplicant() {
		return applicant;
	}

	/**
	 * @param applicant
	 *            the applicant to set
	 */
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	/**
	 * @return the ic
	 */
	public InsuranceCard getIc() {
		return ic;
	}

	/**
	 * @param ic
	 *            the ic to set
	 */
	public void setIc(InsuranceCard ic) {
		this.ic = ic;
	}

	/**
	 * @return the period
	 */
	public Period getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(Period period) {
		this.period = period;
	}

}

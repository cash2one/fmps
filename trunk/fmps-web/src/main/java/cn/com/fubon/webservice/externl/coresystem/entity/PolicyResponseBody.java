/**
 * 
 */
package cn.com.fubon.webservice.externl.coresystem.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 投保响应报文body
 * 
 * @author qingqu.huang
 *
 */
public class PolicyResponseBody {

	@XStreamAlias("INSURED_LIST")
	private List<Insured> insured_list;
	@XStreamAlias("APPLICANT")
	private RspApplicant applicant;
	@XStreamAlias("INSURANCECARD")
	private InsuranceCard ic;
	@XStreamAlias("INSURANCE_PERIOD")
	private Period period;
	@XStreamAlias("PROPERT_REPOSE_ADDRESS_LIST")
	private List<Address> address;
	@XStreamAlias("EXCEPTION_TYPE")
	private String exceptiontype;
	@XStreamAlias("EXCEPTION_MESSAGE")
	private String exceptionmessage;
	@XStreamAlias("STACK_TRACE")
	private String tack_trace;

	/**
	 * @return the tack_trace
	 */
	public String getTack_trace() {
		return tack_trace;
	}

	/**
	 * @param tack_trace
	 *            the tack_trace to set
	 */
	public void setTack_trace(String tack_trace) {
		this.tack_trace = tack_trace;
	}

	/**
	 * @return the exceptiontype
	 */
	public String getExceptiontype() {
		return exceptiontype;
	}

	/**
	 * @param exceptiontype
	 *            the exceptiontype to set
	 */
	public void setExceptiontype(String exceptiontype) {
		this.exceptiontype = exceptiontype;
	}

	/**
	 * @return the exceptionmessage
	 */
	public String getExceptionmessage() {
		return exceptionmessage;
	}

	/**
	 * @param exceptionmessage
	 *            the exceptionmessage to set
	 */
	public void setExceptionmessage(String exceptionmessage) {
		this.exceptionmessage = exceptionmessage;
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
	public RspApplicant getApplicant() {
		return applicant;
	}

	/**
	 * @param applicant
	 *            the applicant to set
	 */
	public void setApplicant(RspApplicant applicant) {
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
}

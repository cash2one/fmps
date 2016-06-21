package cn.com.fubon.webservice.externl.coresystemUnderwrite.entity.request;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微店承保请求报文APPLICATION部分
 * 
 * @author yaoming.zhang
 */
@XStreamAlias("APPLICATION")
public class Application {
	
	@XStreamAlias("APPMAININFO")
	private Appmaininfo appmaininfo;
	
	@XStreamAlias("APPLICANT")
	private Applicant applicant;
	
	@XStreamAlias("INSURANTLIST")
	private List<Insurant> insurant;

	public Appmaininfo getAppmaininfo() {
		return appmaininfo;
	}
	public void setAppmaininfo(Appmaininfo appmaininfo) {
		this.appmaininfo = appmaininfo;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	public List<Insurant> getInsurant() {
		return insurant;
	}
	public void setInsurant(List<Insurant> insurant) {
		this.insurant = insurant;
	}

}

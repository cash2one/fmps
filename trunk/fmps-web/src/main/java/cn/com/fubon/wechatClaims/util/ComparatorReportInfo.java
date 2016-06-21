package cn.com.fubon.wechatClaims.util;

import java.util.Comparator;

import cn.com.fubon.wechatClaims.entity.ReportInfo;

public class ComparatorReportInfo implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		ReportInfo r1 = (ReportInfo)o1;
		ReportInfo r2 = (ReportInfo)o2;
		
		int result = r2.getReportDate().compareTo(r1.getReportDate());
		
		if(result == 0){
			return r2.getReportTime().compareTo(r1.getReportTime());
		}
		
		return result;
		
	}

}

package cn.com.fubon.fo.claim.util;

import java.util.Comparator;

import cn.com.fubon.fo.claim.entity.NotCarReportInfo;

public class ComparatorNotCarReportInfo implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		NotCarReportInfo r1 = (NotCarReportInfo)o1;
		NotCarReportInfo r2 = (NotCarReportInfo)o2;
		
		int result = r2.getReportDate().compareTo(r1.getReportDate());
		
		if(result == 0){
			return r2.getReportTime().compareTo(r1.getReportTime());
		}
		
		return result;
		
	}

}

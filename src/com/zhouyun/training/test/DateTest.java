package com.zhouyun.training.test;

import java.util.Calendar;
import java.util.Date;

import com.zhouyun.training.constant.DateConstant;
import com.zhouyun.training.util.DateUtil;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println("test=" + now);
		
		// Long转Date
		System.out.println(new Date(1445851414000L));
		// Date转Long
		System.out.println(now.getTime());
		
		Date date = DateUtil.transformString2Date("2018-1-30", "yyyy-MM-dd");
		System.out.println(date.getTime());
		
		System.out.println(DateUtil.addDay(now, 20));
		System.out.println(DateUtil.getDayOfMonth(now));
		System.out.println(DateUtil.getFirstDateOfMonth(now));
		System.out.println(DateUtil.getLastDateOfMonth(now));
		
		Date date1 = new Date(1445851414000L);
		Date date2 = new Date(1545851414000L);
		System.out.println(DateUtil.getDaysBetweenTwoDates(date1, date2));
		
		System.out.println(DateUtil.transformDate2String(now, DateConstant.FORMAT_YYYYMMDD_ZH));
		System.out.println(DateUtil.transformDate2String(now, DateConstant.FORMAT_YYYYMMDD));
		System.out.println(DateUtil.transformDate2String(now, DateConstant.FORMAT_YYYYMD));
		System.out.println(DateUtil.transformDate2String(now, DateConstant.FORMAT_YYYYMMDDHHMMSS));
		System.out.println(DateUtil.transformDate2String(now, DateConstant.FORMAT_YYYYMMDDHHMMSS_2));
		System.out.println(DateUtil.transformDate2String(now, DateConstant.FORMAT_YYYYMMDDHHMMSSS));
		System.out.println(DateUtil.transformDate2String(now, DateConstant.FORMAT_HHMMSS));
		
		date = DateUtil.transformString2Date("2018-01-01", DateConstant.FORMAT_YYYYMMDD);
		System.out.println(DateUtil.addDay(date, -1));
		
		System.out.println(getDay(new Date()));
		
	}
	
    public static int getDay(Date date) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	return c.get(Calendar.DATE);
    }
}

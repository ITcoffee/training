package com.zhouyun.training.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * 日期工具类
 *
 * @author  周云
 * @version 2017年6月13日 下午4:10:49
 */
public class DateUtil {
	
	/**
	 * String转Date
	 * 
	 * @param date
	 * 			日期字符串
	 * @param pattern
	 * 			日期格式
	 * @return
	 */
	public static Date transformString2Date(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Date转String
	 * 
	 * @param date
	 * 			日期
	 * @param pattern
	 * 			日期格式
	 * @return
	 */
	public static String transformDate2String(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(date);
	}
	
    /**
     * 取得月第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDateOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.getActualMinimum(Calendar.DATE));
        return c.getTime();
    }

    /**
     * 取得月最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        return c.getTime();
    }
    
    /**
     * 取得当前月份一共有多少天
     *
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getActualMaximum(Calendar.DATE);
    }
    
    /**
     * 判断是否是闰年
     * 
     * @param year
     * @return
     */
	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	}
	
	/**
	 * 在指定日期上加上天数
	 *
	 * @param date
	 * 			指定日期
	 * @param days
	 * 			天数
	 * @return
	 */
	public static Date addDay(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	/**
	 * 在指定日期上加上月数
	 *
	 * @param date
	 * 			指定日期
	 * @param months
	 * 			月数
	 * @return
	 */
	public static Date addMonth(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	
	/**
	 * 获取指定日期的年份
	 * 
	 * @param date
	 * @return
	 */
	public static int getYearOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * 获取指定日期的月份
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonthOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取指定日期的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DATE);
	}
	
	/**
	 * 获取指定日期的季度
	 * 1 第一季度、2 第二季度、3 第三季度、4 第四季度
	 *
	 * @param date
	 * @return
	 */
	public static int getSeasonOfDate(Date date) {

		int season = 0;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		switch (month) {
			case Calendar.JANUARY:
			case Calendar.FEBRUARY:
			case Calendar.MARCH:
				season = 1;
				break;
			case Calendar.APRIL:
			case Calendar.MAY:
			case Calendar.JUNE:
				season = 2;
				break;
			case Calendar.JULY:
			case Calendar.AUGUST:
			case Calendar.SEPTEMBER:
				season = 3;
				break;
			case Calendar.OCTOBER:
			case Calendar.NOVEMBER:
			case Calendar.DECEMBER:
				season = 4;
				break;
			default:
				break;
		}
		
		return season;
	}
	
	/**
	 * 计算两个日期相差的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDaysBetweenTwoDates(Date date1, Date date2) {
		try {
			long time = 0L;
			long time1 = date1.getTime();
			long time2 = date2.getTime();
			if (time1 > time2) {
				time = time1 - time2;
			} else {
				time = time2 - time1;
			}
					
			return (int) (time / (24 * 60 * 60 * 1000));
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
}

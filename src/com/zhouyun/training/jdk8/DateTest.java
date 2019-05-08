package com.zhouyun.training.jdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/** 
 * 新日期时间类
 *
 * 作用：加强对日期与时间的处理
 * 老日期时间类非线程安全、设计差（sql.Date、util.Date重名）
 * 
 * @author  周云
 * @version 2019年5月8日
 */
public class DateTest {

	public static void main(String[] args) {
		// 当前日期时间
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("当前日期时间： " + currentTime);
		
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("当前日期: " + date1);
		
		int year = currentTime.getYear();
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		System.out.println("年：" + year + ", 月：" + month.getValue() + ", 日：" + day);
		
		int hour = currentTime.getHour();
		int minute = currentTime.getMinute();
		int second = currentTime.getSecond();
		System.out.println("时：" + hour + ", 分：" + minute + ", 秒：" + second);
		
		// 设置日期
		LocalDateTime date2 = currentTime.withYear(2018).withMonth(2).withDayOfMonth(10);
		System.out.println("date2:" + date2);
		
		LocalDate date3 = LocalDate.of(2012, 2, 2);
		System.out.println("date3:" + date3);
		
		// 设置时间
		LocalTime date4 = LocalTime.of(2, 2, 2);
		System.out.println("date4:" + date4);
		
		// 解析字符串
		LocalTime date5 = LocalTime.parse("02:02:02");
		System.out.println("date5:" + date5);
		
		// 时区
		ZonedDateTime date10 = ZonedDateTime.parse("2012-02-02T02:02:02+01:30[Asia/Shanghai]");
		System.out.println("date10:" + date10);
		
		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId:" + id);
		
		id = ZoneId.systemDefault();
		System.out.println("当前时区：" + id);
	}
}

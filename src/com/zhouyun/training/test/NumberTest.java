package com.zhouyun.training.test;

import java.math.BigDecimal;

/** 
 * 数字相关测试
 *
 * @author  周云
 * @version 2017年6月13日 下午4:09:08
 */
public class NumberTest {

	public static void main(String[] args) {
		Integer i = 1;
		System.out.println(Integer.SIZE);
		
		// Integer.bitCount(int i) : i的补码中1的个数
		Integer i2 = 5;
		Integer i3 = 7;
		Integer i4 = 9;
		System.out.println(Integer.bitCount(i));
		System.out.println(Integer.bitCount(i2));
		System.out.println(Integer.bitCount(i3));
		System.out.println(Integer.bitCount(i4));
		
		// Integer.decode(String s) : 字符串转为Integer
//		System.out.println(Integer.decode("a"));
//		System.out.println(Integer.decode("a11"));
		System.out.println(Integer.decode("11"));

		for (int j = 0; j < 2; j++) {
			System.out.println(j);
		}
		
		int count = 23;
		int pageSize = 10000;
		System.out.println(count / pageSize);
		
//		System.out.println(new BigDecimal(2).divide(new BigDecimal(3)));
		System.out.println(new BigDecimal(2).divide(new BigDecimal(3), 4, BigDecimal.ROUND_UP));
	}

}

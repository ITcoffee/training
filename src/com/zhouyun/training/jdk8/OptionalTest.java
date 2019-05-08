package com.zhouyun.training.jdk8;

import java.util.Optional;

/** 
 * Optional类
 *
 * 作用：提供很多有用的方法，这样我们就不用显式进行空值检测，很好的解决空指针异常
 * 
 * @author  周云
 * @version 2019年5月8日
 */
public class OptionalTest {
	
	public static void main(String[] args) {
		
		Integer value1 = null;
		Integer value2 = new Integer(10);
		
		// Optional.ofNullable - 允许参数为null
		Optional<Integer> a = Optional.ofNullable(value1);
		// Optional.of - 如果参数是null，抛出异常NullPointerException
		Optional<Integer> b = Optional.of(value2);
		
		OptionalTest test = new OptionalTest();
		System.out.println(test.sum(a, b));
	}
	
	private Integer sum(Optional<Integer> a, Optional<Integer> b) {
		// Optional.isPresent - 判断值是否存在
		System.out.println("第一个参数值是否存在： " + a.isPresent());
		System.out.println("第二个参数值是否存在： " + b.isPresent());
		
		// Optional.orElse - 如果值存在,返回值；否则返回new Integer(0)
		Integer value1 = a.orElse(new Integer(0));
		// Optional.get - 获取值
		Integer value2 = b.get();
		
		return value1 + value2;
	}
	
}

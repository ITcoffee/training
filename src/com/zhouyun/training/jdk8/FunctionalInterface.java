package com.zhouyun.training.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/** 
 * 函数式接口
 * 
 * 
 *
 * @author  周云
 * @version 2019年5月7日
 */
public class FunctionalInterface {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		// Predicate<Integer> predicate = n -> true
		// n 是一个参数传递到 Predicate 接口的 test方法
		// n 如果存在则 test方法返回 true
		System.out.println("输出所有数据：");
		eval(list, n -> true);
		
		// Predicate<Integer> predicate1 = n -> n%2 == 0
	    // n 是一个参数传递到 Predicate 接口的 test 方法
	    // 如果 n%2 为 0 test 方法返回 true
	    System.out.println("输出所有偶数:");
	    eval(list, n -> n%2 == 0);
	    
	    // Predicate<Integer> predicate2 = n -> n > 3
	    // n 是一个参数传递到 Predicate 接口的 test 方法
	    // 如果 n 大于 3 test 方法返回 true
	    System.out.println("输出大于3的所有数字:");
	    eval(list, n -> n > 3);
	    System.out.println("输出不大于3的所有数字:");
	    eval2(list, n -> n > 3);
	}
	
	private static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.println(n);
			}
		}
	}
	
	private static void eval2(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.negate().test(n)) {
				System.out.println(n);
			}
		}
	}
}

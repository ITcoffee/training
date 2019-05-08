package com.zhouyun.training.jdk8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/** 
 * Stream
 *
 * 作用：极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码
 * 
 * @author  周云
 * @version 2019年5月7日
 */
public class Stream {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("空字符串数量为: " + count);
		
		count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("字符串长度为 3 的数量为: " + count);
		
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("筛选后的列表: " + filtered);
		
		String merged = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串： " + merged);
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> squares = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Squares: " + squares);
		
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		IntSummaryStatistics stats = integers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("最大值： " + stats.getMax());
		System.out.println("最小值： " + stats.getMin());
		System.out.println("总和： " + stats.getSum());
		System.out.println("平均数： " + stats.getAverage());
		
	    Random random = new Random();
	    random.ints().limit(10).sorted().forEach(System.out::println);
	    
	    count = strings.parallelStream().filter(string -> string.isEmpty()).count();
	    System.out.println("空字符串的数量为： " + count);
	}
	
}

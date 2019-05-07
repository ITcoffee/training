package com.zhouyun.training.jdk8;

import java.util.Arrays;
import java.util.List;
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
		
		
	}
	
}

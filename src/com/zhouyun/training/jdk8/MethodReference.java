package com.zhouyun.training.jdk8;

import java.util.ArrayList;
import java.util.List;

/** 
 * 方法引用
 * 
 * 作用：减少冗余代码，使代码变的更加简洁紧凑
 *
 * @author  周云
 * @version 2019年5月7日
 */
public class MethodReference {
	
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("alibaba");
		names.add("tencent");
		names.add("baidu");
		
		MethodReference refer = new MethodReference();
		
		names.forEach(refer :: print1);
		names.forEach(MethodReference :: print2);
	}
	
	private void print1(String s) {
		System.out.println("print1: " + s);
	}
	
	private static void print2(String s) {
		System.out.println("print2: " + s);
	}
}

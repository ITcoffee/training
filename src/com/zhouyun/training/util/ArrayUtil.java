package com.zhouyun.training.util;

/** 
 * 数组工具类
 *
 * @author  周云
 * @version 2017年7月7日 下午2:07:00
 */
public class ArrayUtil {

	public static void exchange(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
}

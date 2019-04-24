package com.zhouyun.training.algorithm.sort;

import java.util.Arrays;

import com.zhouyun.training.util.ArrayUtil;

/** 
 * 冒泡排序
 * 
 * 一、操作
 * 1、比较相邻的元素，如果第一个比第二个大，就交换他们两个。
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。每一轮比较过后，最大的数都会排到这轮的最后位置。
 * 3、针对所有的元素重复以上的步骤，除了最后一个。
 * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 
 * 二、时间复杂度：O(N^2)
 * 三、空间复杂度：O(1)
 * 四、稳定度：稳定（相同的2个数排序前后顺序不变）
 * 
 * @author  周云
 * @version 2017年5月6日
 */
public class BubbleSort {
	
	public static void sort(int[] sorting) {
		if (sorting == null || sorting.length == 0) {
			return;
		}
		
		for (int i = 0; i < sorting.length - 1; i++) {
			for (int j = 0; j < sorting.length - 1 - i; j++) {
				/* 
				 * 1、升序
				 * 2、>而不是>=保证了稳定性
				 */
				if (sorting[j] > sorting[j + 1]) {
					ArrayUtil.exchange(sorting, j, j + 1);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {3, 5, 1, 7, 2, 8, 4, 0, -2, -6, 9};
		sort(array);
		
		System.out.println(Arrays.toString(array));
	}

}

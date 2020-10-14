package com.zhouyun.training.algorithm.sort;

import java.util.Arrays;

/** 
 * 归并排序
 *
 * @author  周云
 * @version 2017年5月6日
 */
public class MergerSort {
	
	public int[] sort(int[] nums, int start, int end) {
		if (nums == null || nums.length <= 1) {
			return nums;
		}
		
		if (start == end) {
			return new int[] {nums[start]};
		}
		
		int middle = start + (end - start) / 2;			// 当前数组的截取位置
		int[] leftNums = sort(nums, start, middle);		// 左边数组进行归并排序
		int[] rightNums = sort(nums, middle + 1, end);	// 右边数组进行归并排序

		int[] newNums = new int[leftNums.length + rightNums.length];
		int l = 0, r = 0, n = 0;
		while (l < leftNums.length && r < rightNums.length) {
			newNums[n++] = leftNums[l] < rightNums[r] ? leftNums[l++] : rightNums[r++];
		}
		
		// 如果左边或右边数组还有剩余，插入排序后的新数组
		while (l < leftNums.length) {
			newNums[n++] = leftNums[l++];
		}
		while (r < rightNums.length) {
			newNums[n++] = rightNums[r++];
		}
		
		return newNums;
	}

	public static void main(String[] args) {
		MergerSort merge = new MergerSort();
		
		int[] nums = {4, 7, 1, 2, 10, 8, 6, 12, 3, 2};
		int[] newNums = merge.sort(nums, 0, nums.length - 1);
		for (int i = 0; i < newNums.length; i++) {
			System.out.print(newNums[i] + " ");
		}
		
		System.out.println();
		
		int[] nums2 = {1, 3, 2, 10, 8, 7, 12, 4, 6};
		int[] newNums2 = merge.sort(nums2, 0, nums2.length - 1);
		for (int i = 0; i < newNums2.length; i++) {
			System.out.print(newNums2[i] + " ");
		}
		
		System.out.println(Arrays.toString(newNums2));
		
	}

}

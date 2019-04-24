package com.zhouyun.training.algorithm.sort;

import java.util.Arrays;

import com.zhouyun.training.util.ArrayUtil;

/** 
 * 堆排序
 * 
 * 一、概念
 * 1.堆
 * 堆实际上是一棵完全二叉树，其任何一非叶节点满足性质：
 * Key[i]<=key[2i+1]&&Key[i]<=key[2i+2]或者Key[i]>=Key[2i+1]&&key>=key[2i+2]
 * 即任何一非叶节点的关键字不大于或者不小于其左右孩子节点的关键字。
 * 堆分为大顶堆和小顶堆，满足Key[i]>=Key[2i+1]&&key>=key[2i+2]称为大顶堆，满足 Key[i]<=key[2i+1]&&Key[i]<=key[2i+2]称为小顶堆。由上述性质可知大顶堆的堆顶的关键字肯定是所有关键字中最大的，小顶堆的堆顶的关键字是所有关键字中最小的。
 * 2.堆排序的思想
 * 利用大顶堆(小顶堆)堆顶记录的是最大关键字(最小关键字)这一特性，使得每次从无序中选择最大记录(最小记录)变得简单。
 * 其基本思想为(大顶堆)：
 *   1)将初始待排序关键字序列(R1,R2....Rn)构建成大顶堆，此堆为初始的无序区；
 *   2)将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,......Rn-1)和新的有序区(Rn),且满足R[1,2...n-1]<=R[n]; 
 *   3)由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,......Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2....Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * 二、操作
 * 1、初始化堆：将R[1..n]构造为堆；
 * 2、将当前无序区的堆顶元素R[1]同该区间的最后一个记录交换，然后将新的无序区调整为新的堆。
 *
 * 三、时间复杂度O(N*logN)
 * 四、空间复杂度：O(1)
 * 五、稳定度：不稳定（相同的2个数排序前后顺序改变）
 * 
 * @author  周云
 * @version 2017年5月6日
 */
public class HeapSort {

	 public static void main(String[] args) {
         int[] array = {9, 8, 7, 6, 5, 7, 10, 4, 3, 2, 1, 0, -1, -2, -3};

         System.out.println("Before heap:");
         System.out.println(Arrays.toString(array));

         sort(array);

         System.out.println("After heap sort:");
         System.out.println(Arrays.toString(array));
     }

     public static void sort(int[] array) {
         if (array == null || array.length <= 1) {
             return;
         }

         buildMaxHeap(array);

         for (int i = array.length - 1; i >= 1; i--) {
             ArrayUtil.exchange(array, 0, i);

             maxHeap(array, i, 0);
         }  
     }  

     private static void buildMaxHeap(int[] array) {
         if (array == null || array.length <= 1) {
             return;
         }

         int half = array.length / 2;
         for (int i = half; i >= 0; i--) {
             maxHeap(array, array.length, i);
         }
     }

     private static void maxHeap(int[] array, int heapSize, int index) {
         int left = index * 2 + 1;
         int right = index * 2 + 2;

         int largest = index;
         if (left < heapSize && array[left] > array[index]) {
             largest = left;
         }

         if (right < heapSize && array[right] > array[largest]) {
             largest = right;
         }

         if (index != largest) {
             ArrayUtil.exchange(array, index, largest);

             maxHeap(array, heapSize, largest);
         }
     }

}
package com.zhouyun.training.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * 美团
 *
 * @author  周云
 * @version 2020年9月1日
 */
public class XOR {
	    
    public static Integer[] xorQueries(int[] arr, int[][] queries) {
        if (arr == null) {
            return null;
        }
        if (queries == null) {
            return null;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < queries.length; i++) {
            int[] querie = queries[i];
            if (querie.length != 2) {
                break;
            }
            
            // 超出数组最大索引退出
            if (querie[0] >= arr.length || querie[1] >= arr.length || querie[0] > querie[1]) {
                break;
            }
            
            result.add(xor(Arrays.copyOfRange(arr, querie[0], querie[1] + 1)));
        }
        
        return (Integer[]) result.toArray();
        
    }
    
    private static int xor(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return arr[0] ^ arr[1];
        } else {
            return arr[arr.length - 1] ^ xor(Arrays.copyOfRange(arr, 0, arr.length - 1));
        }
    }
    
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(xorQueries(arr, queries));
    }
}

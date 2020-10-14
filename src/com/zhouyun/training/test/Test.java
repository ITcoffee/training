package com.zhouyun.training.test;

/** 
 * 
 *
 * @author  周云
 * @version 2020年2月24日
 */
public class Test {
	
	public static int lastBox2(int n, int m) {
		if (n <= 0) {
			return 0;
		}
		
		int remainder = n;
		int i = 0;
		while (remainder >= (int) Math.pow(m, i)) {
			remainder = remainder - (int) Math.pow(m, i);
			i++;
		}
		if (remainder == 0) {
			return (int) Math.pow(m, i - 1);
		} else {
			return remainder;
		}
	}

    public static int lastBox(int n, int m) {
    	if (n <= 0) {
    		return 0;
    	}
    	
    	int remainder = (n + 1) % m;
    	if (remainder == 0) {
    		int zhishu = zhishu(n + 1, m);
    		return (int) Math.pow(m, zhishu - 1);
    	}
    	
    	return remainder;
    }
    
    public static int zhishu(int n, int m) {
    	if (n < m) {
    		return 0;
    	}
    	int result = 1;
    	while (n >= Math.pow(m, result + 1)) {
    		result++;
    	}
    	return result;
    }
    
    public static int zhishu2(int n, int m) {
    	return (int) (Math.log(n) / Math.log(m));
    }
    
    public static void main(String[] args) {
		System.out.println(zhishu(9,2));
		System.out.println(zhishu(8,2));
		System.out.println(zhishu(7,2));
		System.out.println(zhishu(5,2));
		System.out.println(zhishu(3,2));
		System.out.println(zhishu2(9,2));
		System.out.println(zhishu2(8,2));
		System.out.println(zhishu2(7,2));
		System.out.println(zhishu2(5,2));
		System.out.println(zhishu2(3,2));
		
		System.out.println(lastBox(7, 2));
		System.out.println(lastBox(8, 2));
		System.out.println(lastBox2(7, 2));
		System.out.println(lastBox2(8, 2));
	}
    
    
}

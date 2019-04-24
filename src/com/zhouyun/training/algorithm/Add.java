package com.zhouyun.training.algorithm;

/** 
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。  
 *
 * @author  周云
 * @version 2017年6月27日 上午9:44:27
 */
public class Add {
	
	/**
	 * 1、先求出两者不考虑进位的情况下的和；
	 * 2、然后求出进位；
	 * 3、判断进位是不是0，不是0就说明存在进位，那么就要继续将当前的值重复这一过程。
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
    public int add(int num1, int num2) {
        while(num2 != 0) {
        	// 求出两者不考虑进位的情况下的和：按位异或
            int temp = num1 ^ num2;
            // 求出进位：按位与，然后左移1位
            num2 = (num1 & num2) << 1;  
              
            num1 = temp;  
        }
        
        return num1;  
    } 
    
    public static void main(String[] args) {
		Add add = new Add();
		System.out.println(add.add(3, 5));
	}
}

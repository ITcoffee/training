package com.zhouyun.training.jdk8;

/** 
 * lambda表达式
 *
 * @author  周云
 * @version 2019年5月7日
 */
public class Lambda {
	
	public static void main(String[] args) {
		Lambda lambda = new Lambda();
		
		// 类型声明
		MathOperation addition = (int a, int b) -> {return a + b;};
		
		// 不用类型声明
		MathOperation subtraction = (a, b) -> {return a - b;};
		
		// 大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> {return a * b;};
		
		// 没用大括号及返回语句
		MathOperation division = (int a, int b) -> a / b;
		
		System.out.println("10 + 5 = " + lambda.operate(10, 5, addition));
		System.out.println("10 - 5 = " + lambda.operate(10, 5, subtraction));
		System.out.println("10 * 5 = " + lambda.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + lambda.operate(10, 5, division));
		
		// 不用括号
		GreetingService greetingService1 = message -> System.out.println("Hello " + message);
		// 用括号
		GreetingService greetingService2 = message -> System.out.println("Hello " + message);
		
		greetingService1.sayMessage("Runoob");
		greetingService2.sayMessage("Google");
	}
	
	interface MathOperation {
		int operation(int a, int b);
	}
	
	interface GreetingService {
		void sayMessage(String message);
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

}

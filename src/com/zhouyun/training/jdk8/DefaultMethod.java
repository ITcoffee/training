package com.zhouyun.training.jdk8;

/** 
 * 接口默认方法
 * 
 * 作用：不需要实现类去实现其方法
 *
 * @author  周云
 * @version 2019年5月7日
 */
public class DefaultMethod {

	public static void main(String[] args) {
		Vehicle vehicle = new Car();
		vehicle.print();
	}
}

interface Vehicle {
	default void print() {
		System.out.println("我是一辆车！");
	}
	
	static void blowHorn() {
		System.out.println("按喇叭！！！");
	}
}

interface FourWheeler {
	default void print() {
		System.out.println("我是一辆四轮车！");
	}
}

class Car implements Vehicle, FourWheeler {
	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("我是一辆汽车！");
	}
}

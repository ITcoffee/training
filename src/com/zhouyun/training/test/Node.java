package com.zhouyun.training.test;

/** 
 * 
 *
 * @author  周云
 * @version 2020年2月13日
 */
public class Node {
	
	private int value;
	private Node left;		// 左子节点
	private Node right;		// 右子节点
	
	public Node(int value) {
		this.setValue(value);
		this.setLeft(null);
		this.setRight(null);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public String toString() {
		return this.value + "";
	}
	
}

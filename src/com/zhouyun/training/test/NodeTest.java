package com.zhouyun.training.test;

import java.util.ArrayList;
import java.util.List;

/** 
 * 
 *
 * @author  周云
 * @version 2020年2月13日
 */
public class NodeTest {
	
	public static void main(String[] args) {
		int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Node> list = new ArrayList<Node>();
		create(data, list);
		
		preTraversal(list.get(0));
		System.out.println();
		midTraversal(list.get(0));
		System.out.println();
		postTraversal(list.get(0));
		System.out.println();
	}
	
	// 构建数结构
	public static void create(int[] data, List<Node> list) {

		//将数组里面的东西变成节点的形式
		for(int i = 0; i < data.length; i++) {
			Node node = new NodeTest().new Node(data[i]);
			list.add(node);
		}
		
		//节点关联成树
		for(int index = 0; index < list.size() / 2 - 1; index++) {
			//编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
			list.get(index).setLeft(list.get(index * 2 + 1));
			list.get(index).setRight(list.get(index * 2 + 2));
		}
		
		//单独处理最后一个父节点 ,list.size() / 2 - 1进行设置，避免单孩子情况
		int index = list.size() / 2 - 1;
		list.get(index).setLeft(list.get(index * 2 + 1));
		//如果有奇数个节点，最后一个父节点才有右子节点
		if(list.size() % 2 == 1) {
			list.get(index).setRight(list.get(index * 2 + 2));
		}
	}
	
	// 前序遍历
	public static void preTraversal(Node root) {
		// 叶子节点停止遍历
		if (root == null) {
			return;
		}
		
		System.out.print(root.getValue() + " ");
		preTraversal(root.getLeft());
		preTraversal(root.getRight());
	}
	
	// 中序遍历
	public static void midTraversal(Node root) {
		if (root == null) {
			return;
		}
		
		midTraversal(root.getLeft());
		System.out.print(root.getValue() + " ");
		midTraversal(root.getRight());
	}
	
	// 后序遍历
	public static void postTraversal(Node root) {
		if (root == null) {
			return;
		}
		
		postTraversal(root.getLeft());
		postTraversal(root.getRight());
		System.out.print(root.getValue() + " ");
	}
	
	class Node {
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
	
}

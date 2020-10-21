package com.zhouyun.training.interview;

import java.util.List;

/** 	
 * 单链表，已知头结点，删除倒数第n个节点，并返回头结点
 *
 * @author  周云
 * @version 2020年10月21日
 */
public class SingelLinkedList {
	
	public Node delete(Node root, List<Node> nodes, int n) {
		if (n > nodes.size()) {
			System.out.println("超出最大节点数！");
			return root;
		}
		
		if (n == nodes.size()) {
			return root.getNext();
		}
		
		Node deleteNode = root;
		
		for (int i = 0; i < nodes.size() - n; i++) {
			deleteNode = deleteNode.getNext();
		}
		
		nodes.remove(deleteNode);
		
		return root;
	}
	
	
	class Node {
		private int value;
		private Node next;
		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		public int getValue() {
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
	}

}

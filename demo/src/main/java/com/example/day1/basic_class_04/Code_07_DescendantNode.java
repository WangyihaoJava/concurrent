package com.example.day1.basic_class_04;

/**
 * 中序遍历 左中右
 *
 * 假设x节点有右子树那么它的后继节点就是 右子树的最左的节点
 * 如果x节点没有右子树那么往上找一直找到 就是通过这个parent指针 他是父亲节点的左子树那么这个父亲节点就是x的后继节点
 *
 *
 */
public class Code_07_DescendantNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 中序遍历的后继节点
	 * 1、如果某个节点有右子树 那么它的后继节点就是 这个右子树的最左节点
	 * 2、没有右子树 (1)它的父节点就是它的后继节点 (2)它的父亲节点作为'某个'节点的左子树时这个'某个'节点就是它的后继节点  也就是它的某个祖先节点
	 * @param
	 */
	public static Node getNextNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			return getLeftMost(node.right);
		} else {
			Node parent = node.parent;
			//一直往上找 判断node是不是parent左子树  如果是 停 返回这个parent  这个的方式
			while (parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}

	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getNextNode(test));
	}

}

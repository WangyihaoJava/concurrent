package com.example.day1.basic_class_04;

public class Code_04_PaperFolding {

	public static void printAllFolds(int N) {
		printProcess(1, N, true);
	}

	/**
	 * 折纸展开后其实就是二叉树的中序遍历
	 * @param i
	 * @param N
	 * @param down true为下 false为上
	 */
	public static void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		//类似二叉树中序遍历递归版的左子树
		printProcess(i + 1, N, true);
		System.out.println(down ? "down " : "up ");
		//类似二叉树中序遍历递归版的右子树
		printProcess(i + 1, N, false);
	}

	public static void main(String[] args) {
		int N = 4;
		printAllFolds(N);

	}
}

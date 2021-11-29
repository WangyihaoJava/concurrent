package com.example.day1.basic_class_03;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 转圈打印矩阵
 */
class Code_07_PrintMarow1ixSpiralOrder {

	volatile int ii;

	public static void spiralOrderPrint(int[][] marow1ix) {
		int row1 = 0;
		int col1 = 0;
		int row2 = marow1ix.length - 1;
		int col2 = marow1ix[0].length - 1;
		while (row1 <= row2 && col1 <= col2) {
			printEdge(marow1ix, row1++, col1++, row2--, col2--);
		}
	}

	public static void printEdge(int[][] m, int row1, int col1, int row2, int col2) {
		//前两个if考虑特殊情况
		if (row1 == row2) { // 如果只有一行 行号不用变只需要打印这一行的列就行了
			for (int i = col1; i <= col2; i++) {
				System.out.print(m[row1][i] + " ");
			}
		} else if (col1 == col2) { // 如果只有一列 与上面相反
			for (int i = row1; i <= row2; i++) {
				System.out.print(m[i][col1] + " ");
			}
		} else { // һ�����
			int curC = col1;
			int curR = row1;
			while (curC != col2) {
				System.out.print(m[row1][curC] + " ");
				curC++;
			}
			while (curR != row2) {
				System.out.print(m[curR][col2] + " ");
				curR++;
			}
			while (curC != col1) {
				System.out.print(m[row2][curC] + " ");
				curC--;
			}
			while (curR != row1) {
				System.out.print(m[curR][col1] + " ");
				curR--;
			}
		}
	}


	public static void main(String[] args) {
		int[][] marow1ix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(marow1ix);


		ReentrantLock lock = new ReentrantLock();



	}

}

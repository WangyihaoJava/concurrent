package com.example.day1.basic_class_03;

public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		//最后一行
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		//控制是从上往下 还是从下往上打印
		boolean fromUp = false;
		while (tR != endR + 1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			/**
			 * 总体的意思是从0开始一直往右 往右走不动了往下 下面两行同理
			 */
			//tc到最后一列了 tr才开始增加
			tR = tC == endC ? tR + 1 : tR;
			//如果tc到最后一行就不变了 否则tc增加
			tC = tC == endC ? tC : tC + 1;
			dC = dR == endR ? dC + 1 : dC;
			dR = dR == endR ? dR : dR + 1;
			//每次取反代表往不同方向打印
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
			boolean f) {
		//右上方往左下方打印
		if (f) {
			while (tR != dR + 1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {
			while (dR != tR - 1) {
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}

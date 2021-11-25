package com.example.day1.basic_class_07;

/**
 * 暴力递归的问题
 * 因为我没有记录每次子过程的解导致同一个解会有好多次重复的计算
 * 动态规划就是解决这个问题的
 *
 * 1傻缓存 就是把每个的解都记录在map里面 每次查看一下有没有 他是不记录位置依赖的 所以严格意义上不是动态规划 如果记录位置依赖就是动态规划
 */
public class Code_07_MinPath {

	public static int minPath1(int[][] matrix) {
		return process1(matrix, matrix.length - 1, matrix[0].length - 1);
	}

	public static int process1(int[][] matrix, int i, int j) {
		int res = matrix[i][j];
		if (i == 0 && j == 0) {
			return res;
		}
		if (i == 0 && j != 0) {
			return res + process1(matrix, i, j - 1);
		}
		if (i != 0 && j == 0) {
			return res + process1(matrix, i - 1, j);
		}
		return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
	}

	public static int minPath2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}

	class Solution {
		public int minPathSum(int[][] grid) {
			if (grid == null || grid.length == 0 || grid[0].length == 0) {
				return 0;
			}
			int rows = grid.length, columns = grid[0].length;
			int[][] dp = new int[rows][columns];
			dp[0][0] = grid[0][0];
			for (int i = 1; i < rows; i++) {
				dp[i][0] = dp[i - 1][0] + grid[i][0];
			}
			for (int j = 1; j < columns; j++) {
				dp[0][j] = dp[0][j - 1] + grid[0][j];
			}
			for (int i = 1; i < rows; i++) {
				for (int j = 1; j < columns; j++) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
				}
			}
			return dp[rows - 1][columns - 1];
		}
	}





	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));

		m = generateRandomMatrix(6, 7);
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));
	}
}

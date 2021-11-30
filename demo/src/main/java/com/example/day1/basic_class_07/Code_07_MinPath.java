package com.example.day1.basic_class_07;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 暴力递归的问题
 * 因为我没有记录每次子过程的解导致同一个解会有好多次重复的计算
 * 动态规划就是解决这个问题的
 *
 * 1傻缓存 就是把每个的解都记录在map里面 每次查看一下有没有 他是不记录位置依赖的 所以严格意义上不是动态规划 如果记录位置依赖就是动态规划
 *
 *
 * 对于最短路径而言 动态规划就是将你每次移动的状态记录下来
 * 所以如果是个一维的 那么一个数组 0 - n-1 就能装得下
 * 二维的 0 - (row - 1)  乘以 0 - (col - 1) 就能装得下
 * 所以每次我们的动态规划最重要的就是 定这个可以装得下所有变化的状态的结构
 *
 * 怎么知道是一维还是二维的 就是通过可变参数如果是1个就是一维表 如果是两个就是二维表 以此类推
 *
 * 比如一个二维的以下面最小路径为例
 * 因为动态规划是需要有位置依赖的 所以对于一个普遍位置 matrix[i][j] 如果想知道他的值既需要左边的又需要上面的 那么怎么去获取
 * 因为在暴力递归中 最后一行 和 最后一列是不依赖的 所以我们可以求出最后一行和最后一列后 在此基础上往下一层一层的推
 * 等我们把每个推完 那么想要普遍位置matrix[i][j]的值自然就可以求出来 因为现在他的左边和右边都有了
 *
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
		//如果已经走到头了 只能往左或者往上
		if (i == 0 && j != 0) {
			return res + process1(matrix, i, j - 1);
		}
		//如果已经走到头了 只能往左或者往上
		if (i != 0 && j == 0) {
			return res + process1(matrix, i - 1, j);
		}
		//如果上面两个都没返回说明当前位置既可以往左又可以往上
		return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
	}

	public static int minPath1Test(int[][] matrix) {
		return process11(matrix, 0, 0);
	}

	public static int process11(int[][] matrix, int i, int j) {

		//如果已经走到头了 只能往左或者往上

		//如果已经走到头了 只能往左或者往上

		//如果上面两个都没返回说明当前位置既可以往左又可以往上
		return 1;
	}

	//增加缓存
	static HashMap<String,Integer>cache = new HashMap<>();
	public static int process2(int[][] matrix, int i, int j) {
		int res = matrix[i][j];
		int result;
		if (i == 0 && j == 0) {
			result =  res;
		}else if (i == 0 && j != 0) {
			//增加缓存如果算过直接取 没算过递归取算
			int next = 0;
			String nextKey = String.valueOf(i) + "_" + String.valueOf(j - 1);
			if (cache.containsKey(nextKey)){
				next = cache.get(nextKey);
			}else {
				next = process2(matrix, i, j - 1);
			}
			result =  res + next;
		}else if (i != 0 && j == 0) {
			int next = 0;
			String nextKey = String.valueOf(i - 1) + "_" + String.valueOf(j);
			if (cache.containsKey(nextKey)){
				next = cache.get(nextKey);
			}else {
				next = process2(matrix, i - 1, j);
			}
			result =  res + next;
		}else {
			int upNext = 0;
			String upNextKey = String.valueOf(i) + "_" + String.valueOf(j - 1);
			if (cache.containsKey(upNextKey)){
				upNext = cache.get(upNextKey);
			}else {
				upNext = process2(matrix, i, j - 1);
			}

			int leftNext = 0;
			String leftNextKey = String.valueOf(i - 1) + "_" + String.valueOf(j);
			if (cache.containsKey(leftNextKey)){
				leftNext = cache.get(leftNextKey);
			}else {
				leftNext = process2(matrix, i - 1, j);
			}
			result =  res + Math.min(upNext,leftNext);
		}
		String key = String.valueOf(i) + "_" + String.valueOf(j);
		cache.put(key,result);
		return result;
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

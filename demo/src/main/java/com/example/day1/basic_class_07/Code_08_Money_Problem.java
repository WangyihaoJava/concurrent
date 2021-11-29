package com.example.day1.basic_class_07;

public class Code_08_Money_Problem {

	public static boolean money1(int[] arr, int aim) {
		return process1(arr, 0, 0, aim);
	}

	//改动态规划只需要 分析i 和 sum 就是 0 - （n - 1） sum 就是0 - arr中所有数累加和
	public static boolean process1(int[] arr, int i, int sum, int aim) {

		//为什么在最后一级才进行判断 因为只有在最后一层才得到所有穷举得出的值
		if (i == arr.length) {
			return sum == aim;
		}
		return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
	}

	public static boolean money2(int[] arr, int aim) {
		boolean[][] dp = new boolean[arr.length + 1][aim + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][aim] = true;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = aim - 1; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + arr[i] <= aim) {
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 8 };
		int aim = 12;
		System.out.println(money1(arr, aim));
		System.out.println(money2(arr, aim));
	}

}

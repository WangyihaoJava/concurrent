package com.example.day1.basic_class_02;

//找到字符串中最大回文长度

/**
 * 笨办法就是 对于奇数回文 从0开始往两边扩直到扩不动了 就是最大长度 但是这个办法对于偶回文是不行的
 * 怎么办呢 两头和中间加上特殊字符 比如 133331  变成#1#3#3#3#3#1# 按照这个去扩 不管什么结果 最大结果除以2就是最终数
 *
 * manacher跟kmp一样也是在原有暴力基础上有加速的过程
 *
 * 回文半径最右边界 所有扩的过程中能够到达的最右的位置
 *
 */
public class Code_04_Manacher {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);
		//回文半径数组 记录每个字符的回文长度
		int[] pArr = new int[charArr.length];
		int index = -1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

}

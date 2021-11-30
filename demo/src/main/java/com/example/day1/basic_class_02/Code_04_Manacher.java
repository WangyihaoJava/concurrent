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
 * 有三种情况
 * 1、当i在最大回文串中 那么一定不可能再大了
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
		//右边届
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			//获取字符的最大回文长度的加速过程就是右边届如果在已知回文串中 就可以进行加速 否则就取1
			//2 * index - i 2倍代表最大回文右边界 减去当前字符的下标
			//pR - i 最大回文右边届 减去 当前下标
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			//每个字符往外扩
			//i + pArr[i] < charArr.length 代表当前字符的回文右边界小于最右边
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				//往外扩的过程 最开始我的左边和右边是否相等 依次累加左边和右边就是往外扩的过程 每次相等的话都进行加加
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}

			//更新更大的回文右边界
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			//比较当前长度和已知最大的回文长度
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

}

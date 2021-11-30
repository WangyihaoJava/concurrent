package com.example.day1.basic_class_02;

//找到字符串中最大回文长度

/**
 * 笨办法就是 对于奇数回文 从0开始往两边扩直到扩不动了 就是最大长度 但是这个办法对于偶回文是不行的
 * 怎么办呢 两头和中间加上特殊字符 比如 133331  变成#1#3#3#3#3#1# 按照这个去扩 不管什么结果 最大结果除以2就是最终数
 *
 * manacher跟kmp一样也是在原有暴力基础上有加速的过程
 *
 * 回文半径最右边界 所有扩的过程中能够到达的最右的位置
 * parr 每个字符扩出来的距离
 * pr 右边界
 * c 当前扩出来的右边界 的中心 每次取得最往右的边界都会且只会将第一次的值进行覆盖
 *
 * 有三种情况
 * 当i不在回文右边界里面 暴力扩 对于abc1234321ab 这样字符串前半部分abc123 都是需要暴力扩的
 * 当i在回文右边界里面 对于abc1234321ab  后半部分321ab 就是属于在里面 这种情况可以加速 怎么加速分三种情况
 * 	   情况一 对于i的回文半径在这个大的回文半径里面  i的回文半径是对应 i‘ 的回文半径这么长 不可能更长了
 * 	   因为他们在整个大回文串里面 是逆序的 所以上来就把i’的值赋值过来(i‘是对应的左边的字符串 已经暴力扩过了)
 * 	   不可能更长是因为 i’的回文左边界 x’ 右边界y‘ 他们当初一定是不等的 所以当时没有扩更长
 * 	   对应过来 i‘的x’ 与i的x 相等 i‘的y’和i的y相等 那么 x' ！= y‘ 就一定有 x ！= y 所以i的回文长度就是i’的回文长度 不可能更长了
 *
 *
 * 	   情况二 左边跑到外边了 i的回文半径也是直接出答案 就是 i 到 最右边界 pR的长度
 * 	   为什么呢 x‘ = y’ 是左边的已经求出来扩到外边的 因为 x‘ x 是以c为中心的回文内 所以 x’ = x
 * 	   为什么以c为中心右边的y没有扩进去呢 只能是 y‘ ！= y 所以 x ！= y(因为x‘ = y’ x’ = x 意思就是我 x’ y’ x都相等了 y‘ ！= y 那么x 和 y必然不等)所以最长只能是i到r
 * 	   情况三 压线了
 * 	   就需要 在i 到 r基础上往右再扩 因为有可能此时是右边跑到外边了 能扩的更大
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

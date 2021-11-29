package com.example.day1.basic_class_02;
//kmp解决的问题是 一个字符串包不包含另一个字符串 如果包含返回开始的位置 不包含返回-1

/**
 * 暴力方法也可以做 从第一个位置往下配 0(n * m)
 */
public class Code_01_KMP {

	/**
	 * 求某个位置字符最大前缀和后缀的长度
	 * 前缀不能包含最后一个字符 后缀也不能包含第一个字符 对于第一个字符来讲 人为规定为0
	 *
	 * kmp加速的过程就是 因为我可以知道str2的最大前缀和后缀 所以按照暴力匹配的方式
	 * 我在第二次进行匹配的时候不用进行全值匹配
	 * 我可以在str2中获取的后缀在str1中对应位置开始 与 str2的前缀部分小加速后的字符串进行匹配(也就是str1去掉后缀第一个字符和str2去掉前缀的第一个字符)
	 * 如果没匹配上 我应该用getnext的值作为下标的位置跟str1中去匹配 如果再没匹配上循环次操作直到等于-1还没匹配上 那么就不包含
	 * 如果匹配上了就一起往下走 直到str2没了
	 *
	 * 这样其实是舍弃了str1后缀之前的匹配部分 为什么舍弃 因为这一部分一定配不出来 为什么 因为如果舍弃的部分能配出来 那么舍弃的部分在str2中等量的长度前缀一定是相等的
	 * 这样的话就说明str2中有更加长的前缀和后缀 这跟我们获取str2的前缀后缀是矛盾的 除非算错了 否则这种情况不可能出现
	 * @param s
	 * @param m
	 * @return
	 */

	//kmp主逻辑
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			//如果s1和s2相等 那么同时往下走进行比较
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
				//next数组中记录着的是这个字符位置的最大前缀和后缀的长度
			} else if (next[mi] == -1) {
				si++;
				//跳过前缀的位置 用前缀的后一个字符进行比较
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	//getnext
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		//cn代表i-1位置的前缀的下一个字符
		int cn = 0;
		while (pos < next.length) {
			//如果当前字符前一个字符和前缀的下一个字符相等 也就是当前字符的值是在原来前缀长度的基础上加1
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
				//如果不相等 我要跳到cn的前缀的下一个字符 而next数组中以cn为下标的数正是我要跳到的cn的前缀的下一个字符
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababacccccc";
		String match = "ktlbktlkktlbktlb";
		String match1 = "cabc";

		String str1 = "ababaabaabac";
		String match11 = "abaabac";
		System.out.println(getIndexOfTest(str1, match11));
		getNextArrayTest(match.toCharArray());

	}


	public static int[] getNextArrayTest(char[] ms) {
		if (ms.length == 1){
			return new int[]{-1};
		}

		int[]next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int index = 2;
		int con = 0;
		while (index < ms.length){
			//前缀的下一个字符和当前字符前一个字符
			if (ms[index - 1] == ms[con]){
				int temp = ++con;
				//如果当前字符前一个字符和前缀的下一个字符相等 也就是当前字符的值是在原来前缀长度的基础上加1
				next[index] = temp;
			index++;
			}else if (con > 0){
				con = next[con];
			}else {
				next[index++] = 0;
			}


		}
		return next;

	}

	public static int getIndexOfTest(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[]ss = s.toCharArray();
		char[]mm = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArrayTest(mm);
		while (si < s.length() && mi < m.length()){
			if (ss[si] == mm[mi]){
				si++;
				mi++;
			}else if (next[mi] == -1){
				si++;
			}else {
				mi = next[mi];
			}
		}

		return mi == m.length() ? si - mi : -1;


	}


}

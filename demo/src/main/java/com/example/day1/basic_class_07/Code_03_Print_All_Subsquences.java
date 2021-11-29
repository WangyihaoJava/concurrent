package com.example.day1.basic_class_07;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印子序列 就是把所有字符拆开 要么要 要么不要一直递归
 */
public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);
		chs[i] = tmp;
	}

	public static void println(String str) {
		char[] chs = str.toCharArray();
		f(chs,0,"");
		System.out.println("");
	}

	/**
	 *
	 * @param chs
	 * @param index
	 * @param pre 就是0-index-1已经形成的字符串
	 */
	public static void f(char[] chs, int index,String pre) {
		//idex到最后打印之前形成的字符串
		//为什么是等于length才打印 因为只有这样的情况下才会把所有的情况全部展开
		if (index == chs.length){
			if (!pre.equals("")){
				System.out.println(pre);
			}
			return;
		}
		//要么要 要么不要 把所有沿途的打印出来就是子序列
		f(chs,index + 1,pre);
		f(chs,index + 1,pre + String.valueOf(chs[index]));
	}

	public static void main(String[] args) {
		String test = "abc";
		/*printAllSubsquence(test);*/
		println(test);
	}


}

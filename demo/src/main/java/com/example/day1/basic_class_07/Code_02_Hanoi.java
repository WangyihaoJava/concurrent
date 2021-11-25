package com.example.day1.basic_class_07;

public class Code_02_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, "left", "mid", "right");
		}
	}

	public static void func(int n, String from, String mid, String to) {
		if (n == 1) {
			//只剩下一个 不违反小压大爱怎么移怎么移 直接移到to上去
			System.out.println("move from " + from + " to " + to);
		} else {
			//相当于1 - n-1都来到to了
			func(n - 1, from, to, mid);
			func(1, from, mid, to);
			func(n - 1, mid, from, to);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}

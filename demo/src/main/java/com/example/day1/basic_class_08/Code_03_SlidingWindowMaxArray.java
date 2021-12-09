package com.example.day1.basic_class_08;

import java.util.LinkedList;

public class Code_03_SlidingWindowMaxArray {

	/**
	 *
	 * @param arr
	 * @param w 窗口的大小
	 * @return
	 */
	public static int[] getMaxWindow(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {

			//保证从大到小(严格由大到小 等于都不行 等于也弹出把当前放进去) 从双端队列尾部弹出 直到到当前数能放进去了
			//为什么要把比当前的都弹出呢 因为当前的下标比这些晚过期并且还比你大 说明你再也不可能成为最大的了(只有弹出才能保证双端队列头部最大)
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);

			//窗口减数 刚刚出去的那个下标是头部的 把头部弹出(说明过期了) 如果没过期不动
			if (qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}

			//每一步得到的最大值就是双端队列的头部
			if (i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
		int w = 3;
		printArray(getMaxWindow(arr, w));

	}

}

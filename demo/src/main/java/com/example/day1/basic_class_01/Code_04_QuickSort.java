package com.example.day1.basic_class_01;

import java.util.Arrays;

/**
 * 快排的空间复杂度logn 是因为我需要记录有一下等于区域的位置 因为我去递归的时候你至少要告诉我从哪开始到结束
 * 所以最好情况就是 我这个等于的位置打的很好刚刚在一半 就是logn 最差情况就是打的很偏就是o(n)
 */
public class Code_04_QuickSort {


	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			int[] p = partition(arr, l, r);
			//左边到 等于区域开始位置的前一个位置 递归
			quickSort(arr, l, p[0] - 1);
			//等于区域结束位置的后一个位置到右边递归
			quickSort(arr, p[1] + 1, r);
		}
	}

	/**
	 * 快排的前半部分就是荷兰国旗问题
	 * @param arr
	 * @param l 从左往右遍历 l相当于当前的数
	 * @param r
	 * @return
	 */
	public static int[] partition(int[] arr, int l, int r) {
		//小于等于区右边界
		int less = l - 1;

		//大于区左边界
		int more = r;

		//为什么要用当前值 而不用less 和大于区的左边界做循环控制 因为存在等于的数刚好在左边界和右边界的中间 这样的话左边界永远不会小于右边界
		while (l < more) {
			//如果当前值小于key 当前值和小于区右边界的后一个数交换
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);

				//如果当前值大于key 当前和大于区的左边界前一个数交换
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		//为什么要和最右边的数交换 因为我们的key使用的是最右边的 他是不对的 相当于交换一次把他放到中间的位置 他就是key 是等于区域的数
		swap(arr, more, r);
		//返回等于区域的下标从哪到哪
		return new int[] { less + 1, more };
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 10;
		int maxValue = 10;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

}

package com.example.day1.basic_class_01;

import java.util.Arrays;


/**
 * 归并排序的过程就是先划分成两部分 左边和右边
 * 左边一直划分 直到划分到剩一个数返回 和下一个递归过程返回的数 进行外排合并 此时外排合并就能保证在这两个数的范围上有序 然后拷贝到原数组
 * 这样一直递归一直外排 依次 外排的范围越来越大 直到整个数组分为两个部分进行最后依次外排 完成排序 注意每次外排都是保证当前范围内的有序 并且之前已经排好的不用重新再排
 *
 * 时间复杂度 两个递归行为加上合并的行为 2 * n/2 + n
 */
public class Code_05_MergeSort {

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		int mid = l + ((r - l) >> 1);
		//把数组分成两半 递归分别对两边排序
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		//最后把两部分进行合并
		merge(arr, l, mid, r);


	}


	//合并的过程就是拿着左边第一个和右边第一个进行比较 谁小要哪个放进额外数组
	//最后把这个额外数组拷贝进去
	public static void merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;

		//两个都不越界的情况下 拿着左边第一个和右边第一个进行比较 谁小要哪个放进额外数组
		while (p1 <= m && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}

		//两个必要且只有一个越界 把没越界的放进去
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}

		//拷贝到原数组
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
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
			mergeSort(arr1);
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
		mergeSort(arr);
		printArray(arr);
		int[]tt = new int[]{3,5,7,1,0};
		System.out.println(mergeSortT(tt,0,tt.length - 1));

	}

	public static int mergeSortT(int[] arr, int l, int r) {
		if (l == r) {
			return arr[l];
		}
		int mid = l + ((r - l) >> 1);
		//把数组分成两半 递归分别对两边排序
		int maxleft = mergeSortT(arr, l, mid);
		int maxright = mergeSortT(arr, mid + 1, r);
		return Math.max(maxleft,maxright);

	}

}

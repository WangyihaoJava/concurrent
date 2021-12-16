package com.example.day1.basic_class_01;

import java.util.Arrays;

public class Code_03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int size = arr.length;
		//头结点和尾结点交换
		swap(arr, 0, --size);

		//如果没到0 我给你一个size你去调整成大根堆 size减1后 相当于整个结构减1 最后一个再也碰不到了 每次拿一个最大的数不动了 最后直到最后一个数 这样就从大到小排好序了(大根堆的情况 如果是小根堆就是从小到大排)
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	/**
	 * 某个位置往上走 (保证任意一个父节点是最大 但是不保证子节点大小次序)
	 * @param arr
	 * @param index
	 */
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			//如果当前位置比父节点大 交换
			swap(arr, index, (index - 1) / 2);
			//然后当前的变成父节点位置后 继续循环看是不是比他的父更大
			index = (index - 1) / 2;
		}
	}

	/**
	 * 某个位置往下走 (调整子节点的次序)
	 * @param arr
	 * @param index
	 * @param size
	 */
	public static void heapify(int[] arr, int index, int size) {
		//当前的左孩子下标
		int left = index * 2 + 1;//index * 2 + 2是当前右孩子
		while (left < size) {
			//我孩子中较大那个下标给我(起码是左孩子 在不越届并且右孩子更大就是右孩子)
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			//找出我和我最大孩子的那个下标
			largest = arr[largest] > arr[index] ? largest : index;
			//如果我的孩子没有比我大 循环停止
			if (largest == index) {
				break;
			}

			//某个孩子比我大 那个孩子的位置是largest 那个孩子和我换 然后继续循环
			swap(arr, largest, index);

			//把当前下标改为更大的那个 循环继续
			index = largest;
			left = index * 2 + 1;
		}
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
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

}

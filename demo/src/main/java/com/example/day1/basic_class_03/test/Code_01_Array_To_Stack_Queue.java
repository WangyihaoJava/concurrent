package com.example.day1.basic_class_03.test;

public class Code_01_Array_To_Stack_Queue {

	/**
     * 数组模拟栈结构
	 */
	public static class ArrayStack {
		private Integer[] arr;
		private Integer size;

		public ArrayStack( Integer size) {
			if (size < 1){
				throw new RuntimeException("size有误");
			}
			arr = new Integer[size];
		}

		public int peek(){
			return arr[size - 1];
		}

		public void push(int obj){
			arr[size++] = obj;
		}

		public int pop(){
			return arr[--size];
		}
	}

	/**
	 * 数组实现队列
	 */
	public static class ArrayQueue {
		private Integer[] arr;
		private Integer first;
		private Integer end;
		private Integer size;

		public ArrayQueue( Integer size) {
			if (size == 0){
				throw new RuntimeException("数量有误");
			}

			this.arr = new Integer[size];
			this.first = 0;
			this.end = 0;
			this.size = 0;
		}


		public int peek() {
			if (size == 0){
				throw new RuntimeException("栈是空的");
			}
			return arr[first];
		}

		public void push(int obj) {
			if (size == arr.length -1 ){
				throw new RuntimeException("栈已经满了");
			}
			size++;
			arr[end] = obj;
			end = end == arr.length -1 ? 0 : end + 1;
		}

		public int pop() {
			if (size == 0){
				throw new RuntimeException("栈已经空了");
			}

			int temp = first;
			first = first == arr.length -1 ? 0 : first + 1;

			return arr[temp];
		}

	}

	}

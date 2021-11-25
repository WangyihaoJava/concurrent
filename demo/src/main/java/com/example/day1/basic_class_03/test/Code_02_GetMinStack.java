package com.example.day1.basic_class_03.test;

import java.util.PriorityQueue;
import java.util.Stack;

public class Code_02_GetMinStack {
	public static class MyStack1 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack1() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {
			if (stackData.isEmpty()){
				stackMin.push(newNum);
			}else {
				Integer pop = stackMin.peek();
				if (newNum <= pop){
					stackMin.push(newNum);
				}
			}
			stackData.push(newNum);
		}

		public int pop() {
			Integer pop = stackData.pop();
			if (pop == getmin()){
				stackMin.pop();
			}
			return pop;
		}

		public int getmin() {
			return stackMin.peek();
		}
	}


	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(3);
		System.out.println(stack1.getmin());
		stack1.push(4);
		System.out.println(stack1.getmin());
		stack1.push(1);
		System.out.println(stack1.getmin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getmin());

		System.out.println("=============");

		MyStack1 stack2 = new MyStack1();
		stack2.push(3);
		System.out.println(stack2.getmin());
		stack2.push(4);
		System.out.println(stack2.getmin());
		stack2.push(1);
		System.out.println(stack2.getmin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getmin());
	}



}

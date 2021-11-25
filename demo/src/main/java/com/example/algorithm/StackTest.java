package com.example.algorithm;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        /**
         * class Solution {
         *     public boolean validateStackSequences(int[] pushed, int[] popped) {
         *         Stack<Integer> stack = new Stack<>();
         *         int i = 0;
         *         for(int num : pushed) {
         *             stack.push(num); // num 入栈
         *             while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
         *                 stack.pop();
         *                 i++;
         *             }
         *         }
         *         return stack.isEmpty();
         *     }
         * }

         *
         * class Solution {
         *          *     public boolean validateStackSequences(int[] pushed, int[] popped) {
         *
         *          }
         *
         *
         *
         * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
         * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
         *
         *  
         *
         * 示例 1：
         *
         * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
         * 输出：true
         * 解释：我们可以按以下顺序执行：
         * push(1), push(2), push(3), push(4), pop() -> 4,
         * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
         * 示例 2：
         *
         * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
         * 输出：false
         * 解释：1 不能在 2 之前弹出。
         *  
         *
         * 提示：
         *
         * 0 <= pushed.length == popped.length <= 1000
         * 0 <= pushed[i], popped[i] < 1000
         * pushed 是 popped 的排列。
         *
         *
         *
         */


       /* int[] pushed = new int[1];
        int[] popped = new int[2];

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int i = 0;
        for (int num : pushed){
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }*/

        /*
        定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

 

        示例:

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();   --> 返回 -3.
        minStack.pop();
        minStack.top();      --> 返回 0.
        minStack.min();   --> 返回 -2.
 

        提示：

        各函数的调用总次数不超过 20000 次

        -3
        0
        -2   -2
             -3

    */

        /**
         * class MinStack {
         *     Stack<Integer> A, B;
         *     public MinStack() {
         *         A = new Stack<>();
         *         B = new Stack<>();
         *     }
         *     public void push(int x) {
         *         A.add(x);
         *         if(B.empty() || B.peek() >= x)
         *             B.add(x);
         *     }
         *     public void pop() {
         *         if(A.pop().equals(B.peek()))
         *             B.pop();
         *     }
         *     public int top() {
         *         return A.peek();
         *     }
         *     public int min() {
         *         return B.peek();
         *     }
         * }
         *

         */


        /**
         *
         *
         *
         * class MinStack {
         *
         *
         *
         *
         *
         *
         * }
         *
         *
         *
         */



        /*Stack<Integer>stack = new Stack<>();
        stack.add(-2);
        stack.add(-3);
        System.out.println(stack.peek() + "----");

        Stack<Integer>stackq = new Stack<>();
        stackq.add(-2);
        stackq.add(0);
        stackq.add(-3);
        System.out.println(stack.pop().equals(stackq.peek()) + "11----");
        System.out.println(stack.peek() + "--" + stackq.peek());
        */

        int x = 1;

        Stack<Integer>stackA = null;
        Stack<Integer>stackB = null;
        stackA = new Stack<>();
        stackB = new Stack<>();

        stackA.add(x);
        if (stackB.isEmpty() || stackB.peek() >= x){
            stackB.add(x);
        }

        if (stackA.pop().equals(stackB.peek())){
            stackB.pop();
        }



        stackA.peek();

        stackB.peek();



    }

}

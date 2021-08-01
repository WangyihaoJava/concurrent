package com.example.algorithm;

/**
 * @author wangyihao
 * @ClassName: Test
 * @Description:
 * @date 2021/7/9 16:36
 */
public class Test {

    private static int flag;

    public static void main(String[] args) {
        /**
         * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。 n<=39
         * 问题分析：
         *
         * 可以肯定的是这一题通过递归的方式是肯定能做出来，但是这样会有一个很大的问题，
         * 那就是递归大量的重复计算会导致内存溢出。另外可以使用迭代法，
         * 用fn1和fn2保存计算过程中的结果，并复用起来。下面我会把两个方法示例代码都给出来并给出两个方法的运行时间对比。
         */
        int fibonacci = Fibonacci1(7);
        System.out.println(fibonacci);
        System.out.println(flag);


    }

    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1||n==2) {
            return 1;
        }

        flag++;

        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }

    public static int Fibonacci1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1, second = 1, third = 0;
        for (int i = 3; i <= n; i++) {
            third = (first + second) % 1000000007;
            first = second;
            second = third;
        }
        return third;
    }

    public static int Solution(int n) {

        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;

    }


}

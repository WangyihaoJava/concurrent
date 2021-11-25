package com.example.day1;

public class Test {
    public static void main(String[] args) {
        int n = 5;
        int res = dfs(n);
        System.out.println(res);
    }

    private static int dfs(int n) {
        if (n == 1){
            return 1;
        }
        return n * dfs(n -1);
    }
}

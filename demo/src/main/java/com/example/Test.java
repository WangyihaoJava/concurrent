package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    private volatile int count ;

    public static void main(String[] args) {

        
        Thread[]list = new Thread[10];


        int result;
        for (int i = 0; i < 10; i++){
            list[i] = new Runner(10 * i + 1);
            list[i].start();
        }

        Runner runner = new Runner(0);
        System.out.println(runner.getRsult() + "------");


        int n = 5;
        int dfs = dfs(n);
        System.out.println(dfs);

    }

    private static int dfs(int n) {

        if (n == 1){
            return 1;
        }else {
            int num = n * dfs(n -1);
            return num;
        }

    }


}

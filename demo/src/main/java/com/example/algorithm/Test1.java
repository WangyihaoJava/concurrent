package com.example.algorithm;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author wangyihao
 * @ClassName: Test1
 * @Description:
 * @date 2021/7/30 14:45
 */
public class Test1 implements Runnable{
    public static void main(String[] args) {
    Thread thread =new Thread(new Test1());
    thread.start();

    }


    @Override
    public void run() {
        System.out.println("1111");
    }


}

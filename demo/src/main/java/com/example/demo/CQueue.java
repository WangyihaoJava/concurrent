package com.example.demo;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangyihao
 * @ClassName CQueue
 * @date 2021/5/19 16:11
 * @Description
 */
public class CQueue {
    LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    public void appendTail(int value) {
        A.addLast(value);

    }
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }


    public static void main(String[] args){

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("s","s");

        String s = "c;";
        System.out.println(s.hashCode());

        Integer i = 0;
        Integer j = 1;
        System.out.println(i.hashCode());
        System.out.println(j.hashCode());

        System.out.println(2 & 1);

    }



}



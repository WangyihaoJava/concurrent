package com.example;

public class Runner extends Thread{
    private int result;
    private static int rsult;

    public Runner(int i) {
        result = i;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            rsult = result + rsult + i;
        }
        add(rsult);
    }

    public synchronized static void add(int add){
        rsult = rsult + add;
    }
    public int getRsult() {
        return rsult;
    }
}

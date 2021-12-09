package com.example.algorithm.qioushu;

import java.util.concurrent.Semaphore;

public class printqioushu {
    private int count = 0;
    private final Object lock = new Object();
    private final Semaphore semaphore = new Semaphore(1);
    public void turning() {
        new Thread(() -> {
            while (count < 100) {
                try {
                    semaphore.acquire(1);
                    // 只处理偶数
                    if ((count & 1) == 0) {
                        System.out.println("偶数" + ": " + count++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release(1);
                }

            }
        }, "偶数").start();


        new Thread(() -> {
            while (count < 100) {
                try {
                    semaphore.acquire(1);
                    // 只处理奇数
                    if ((count & 1) == 1) {
                        System.out.println("奇数" + ": " + count++);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release(1);
                }
            }

        }, "奇数").start();

    }

}

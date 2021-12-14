package com.demo.thread;

import cn.hutool.core.date.DateUtil;

public class RunnableTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " -> listening:" + DateUtil.now());
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " -> listening:" + DateUtil.now());
            }
        });
        t2.start();
    }

}

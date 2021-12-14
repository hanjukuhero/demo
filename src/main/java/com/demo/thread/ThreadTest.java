package com.demo.thread;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        MyThread2 t2 = new MyThread2();
        t2.start();
    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 可以直接用this代表该线程
                System.out.println(this.getName() + " -> listening:" + DateUtil.now());
            }
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 可以直接用this代表该线程
                System.out.println(this.getName() + " -> listening:" + DateUtil.now());
            }
        }
    }
}

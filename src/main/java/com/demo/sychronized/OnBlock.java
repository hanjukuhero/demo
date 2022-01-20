package com.demo.sychronized;

/**
 * @description:
 * @author：yi.qin
 * @date：2021/12/30
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
class OnBlock implements Runnable {

    public final static Object object = new Object();

    private static int count;


    public OnBlock() {
        count = 0;
    }

    @Override
    public void run() {
        // 如果是给静态引用加锁，那就是只有一个线程能拿到锁且需要待该线程执行完这个代码块
        // synchronized (object) {

        // 如果是 给当前对象实例加锁，那多个线程都能拿到锁。
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Demo00 {
        public static void main(String[] args) {
            // test01
            OnBlock s1 = new OnBlock();
            OnBlock s2 = new OnBlock();
            Thread t1 = new Thread(s1);
            Thread t2 = new Thread(s2);

            // test02
            // OnBlock s = new OnBlock();
            // Thread t1 = new Thread(s);
            // Thread t2 = new Thread(s);

            t1.start();
            t2.start();



        }
    }
}



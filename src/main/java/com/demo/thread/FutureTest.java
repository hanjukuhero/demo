package com.demo.thread;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 可以拿到任务的返回结果
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int i = 0;
                while (i < 10) {
                    // Thread.sleep(1000);
                    // 休眠1秒
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " -> listening:" + DateUtil.now());
                    i++;
                }
                return "已循环" + i + "次";
            }
        }) ;

        Thread t1 = new Thread(task, "futureTask");
        t1.start();
        System.out.println(task.get());
    }
}

package com.demo.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: CAS
 * @author：yi.qin
 * @date：2021/12/21
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
public class CasTest {
    public static void main(String[] args) {
        //初始值
        AtomicInteger integer = new AtomicInteger(5);
        //比较并替换
        boolean flag = integer.compareAndSet(5, 10);
        boolean flag2 = integer.compareAndSet(5, 15);

        System.out.println("是否自选并替换 "+flag +"更改之后的值为："+integer.get());
        System.out.println("是否自选并替换 "+flag2 +"更改之后的值为："+integer.get());
    }
}

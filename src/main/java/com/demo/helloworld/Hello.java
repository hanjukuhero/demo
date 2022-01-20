package com.demo.helloworld;

import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @description:
 * @author：yi.qin
 * @date：2022/1/5
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
public class Hello {
    private static String name;

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (isInterested(random.nextInt(10))) {
                count++;
            }
        }

        Object obj = null;
        try {
            System.out.println(obj.equals("aaa"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.printf("Found %d interested values%n", count);
    }



    private static boolean isInterested(int i) {
        name = "abc";
        return i % 2 == 0;

    }
}

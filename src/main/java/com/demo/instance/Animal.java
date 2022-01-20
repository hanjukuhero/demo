package com.demo.instance;

import lombok.Data;

/**
 * @description:
 * @author：yi.qin
 * @date：2022/1/7
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
@Data
public class Animal {
    private String name;
    private Integer age;

    public void run(Animal animal) {
        System.out.println(animal.getName() + "run");
    }

}

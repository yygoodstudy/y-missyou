package com.yy.ymissyou.sample.hero;

import com.yy.ymissyou.sample.ISkill;

/**
 * @Date: 2020/12/7 02:21
 * @Description:
 */
//@Component
public class Camille implements ISkill {

    private String name;
    private Integer age;

    public Camille() {
        System.out.println("Camille 初始化了...");
    }

    public Camille(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public void q() {
        System.out.println("Camille Q");
    }

    public void w() {
        System.out.println("Camille W");
    }

    public void e() {
        System.out.println("Camille E");
    }

    public void r() {
        System.out.println("name:" + this.name + "释放了Camille R");
    }
}

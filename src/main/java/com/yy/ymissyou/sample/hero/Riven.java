package com.yy.ymissyou.sample.hero;

import com.yy.ymissyou.sample.ISkill;

/**
 * @Date: 2020/12/7 01:25
 * @Description:
 */
//@Component // 单独的一个Component无法解决实例化的时候赋值的问题
public class Riven implements ISkill {

    private String skillName = "Riven R";
    private String name;
    private Integer age;

    public Riven() {
        System.out.println("Riven 初始化了...");
    }

    public Riven(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public void q() {
        System.out.println("Riven Q");
    }

    public void w() {
        System.out.println("Riven W");
    }

    public void e() {
        System.out.println("Riven E");
    }

    public void r() {
        System.out.println(this.name + "释放了" + this.skillName);
    }
}

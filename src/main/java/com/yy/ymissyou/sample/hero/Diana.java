package com.yy.ymissyou.sample.hero;

import com.yy.ymissyou.sample.ISkill;
import org.springframework.context.annotation.Lazy;

/**
 * @Date: 2020/12/6 03:11
 * @Description:
 */
//@Component
@Lazy // 延迟加载，修改spring立即加载机制。不会再项目启动的时候就实例化该Bean
public class Diana implements ISkill {

    public Diana() {
        System.out.println("Diana 初始化了...");
    }

    public void q() {
        System.out.println("Diana Q");
    }

    public void w() {
        System.out.println("Diana W");
    }

    public void e() {
        System.out.println("Diana E");
    }

    public void r() {
        System.out.println("Diana R");
    }
}

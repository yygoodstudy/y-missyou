package com.yy.ymissyou.sample;

import com.yy.ymissyou.sample.hero.Camille;
import com.yy.ymissyou.sample.hero.Diana;
import com.yy.ymissyou.sample.hero.Riven;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2020/12/7 02:25
 * @Description:
 */
@Configuration // 使用配置类的好处，可以一次性初始化多个Bean，主要的优点在于可以在初始化的时候为Bean属性赋值。
public class HeroConfiguration {

    //@Bean
    // matchIfMissing = true：如果配置文件中没有找到该value值所对应的属性，也会将该Bean加载到spring容器中
    //@ConditionalOnProperty(value = {"hero.name"},havingValue = "riven",matchIfMissing = true) // 如果配置文件中hero.name的值是camille则将该Bean注入到spring容器中。
    public ISkill camille() {
        return new Camille(18, "camille");
    }

    @Bean //(name = "rivenMm")
    //@Conditional(RivenCondition.class) // 配合RivenCondition这个条件类(这个类要求实现Condition注解，方法返回的boolean值确定是否要将该Bean注入到spring容器中)
    public ISkill riven() {
        return new Riven(19, "锐雯");
    }

    //@Bean(name = "diana")
    //@ConditionalOnBean(name = "mysql")// 如果容器中有name = mysql这个Bean，则会将Diana这个类实例化到spring容器中
    //@ConditionalOnMissingBean(name = "mysql") // 如果容器中没有mysql这个bean,则会创建Diana这个Bean并注入到spring容器中
    public ISkill diana(){
        return new Diana();
    }
}

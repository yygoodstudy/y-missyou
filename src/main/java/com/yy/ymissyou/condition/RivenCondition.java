package com.yy.ymissyou.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义Condition用于@Conditional(Class[? extends Condtion] classes) 注解标注的Bean是否加入到spring容器中
 * @Date: 2020/12/9 00:46
 * @Description:
 */
public class RivenCondition implements Condition {
    //@Value("${hero.name}")
    //private String name; // 这种方法取不到值

    /**
     * 只有加入了该条件注解的类并且该方法返回true时，该Bean才会加入到spring容器中
     * @param context
     * @param metadata
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        String heroName = context.getEnvironment().getProperty("hero.name"); // 取配置文件中的hero.name属性的值
        return "Riven".equals(heroName);
    }
}

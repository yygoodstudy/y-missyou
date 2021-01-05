package com.yy.ymissyou;

import com.yy.ymissyou.sample.ISkill;
import com.yy.ymissyou.sample.LOLConfigurationSelector;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @Date: 2020/12/17 00:15
 * @Description:
 */
//@ComponentScan
@Import(LOLConfigurationSelector.class) // 主动的将spring配置类导入到IOC容器中
public class LOLApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(LOLApplication.class)
                .web(WebApplicationType.NONE)  // 关闭web server，不加载web相关的配置
                .run(args);
        ISkill riven = (ISkill) context.getBean("riven");
        riven.r();
    }
}

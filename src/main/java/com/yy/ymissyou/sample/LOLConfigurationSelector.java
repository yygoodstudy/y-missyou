package com.yy.ymissyou.sample;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Date: 2020/12/17 00:32
 * @Description:
 */
public class LOLConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HeroConfiguration.class.getName()};
    }
}

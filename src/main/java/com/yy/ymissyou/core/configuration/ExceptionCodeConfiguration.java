package com.yy.ymissyou.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2020/12/27 00:48
 * @Description:异常Code和message的配置类
 */
@Component
@ConfigurationProperties(prefix = "yao")
@PropertySource(value = "classpath:config/exception-code.properties",encoding = "gb2312")
public class ExceptionCodeConfiguration {

    private Map<Integer,String> codes = new HashMap<>();

    public String getMessage(int code){
        return codes.get(code);
    }

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }
}

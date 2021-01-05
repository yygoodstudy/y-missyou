package com.yy.ymissyou.sample;

import com.yy.ymissyou.sample.database.Mysql;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @Date: 2020/12/7 03:16
 * @Description:
 */
//@Configuration
public class DatabaseConfiguration {

    @Value("${mysql.ip}") //@Value("${mysql.ip}") :读取配置文件中的key:value并为属性赋值。
    private String ip;
    @Value("${mysql.port}")
    private Integer port;

    @Bean
    public IConnect mysql() {
        return new Mysql(this.ip, this.port);
    }
}

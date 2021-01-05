package com.yy.ymissyou.sample.database;

import com.yy.ymissyou.sample.IConnect;

/**
 * @Date: 2020/12/7 03:10
 * @Description:
 */
public class Mysql implements IConnect {


    private String ip = "locahost";
    private Integer port = 3306;

    public Mysql() {
    }

    public Mysql(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }


    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public void connect() {
        System.out.println("url=" + this.ip + ":" + this.port);
    }
}

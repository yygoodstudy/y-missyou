package com.yy.ymissyou.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Banner：指的是一组轮播图
 * @Date: 2021/1/10 06:33
 * @Description: 物理外键(一般不建议使用，指在数据库中通过创建外键的方式建立表与表之间的练习方式)，通常使用逻辑外键
 * 实体与实体之间的配置最麻烦，但是更能体现它的价值
 */
@Entity
public class Banner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键的生成策略--自增长
    private Long id;
    @Column(length=16)
    private String name;
    @Transient // 不会序列化该属性，JPA再创建表的时候不会创建该列
    private String description;
    private String img;
    private String title;
    /**
     * 表示Banner和BannerItem一对多的关系，JPA会自动为我们创建第三张表：banner_items,用来维护Banner和BannerItem之间的关系
     */
    @OneToMany
    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}

package com.yy.ymissyou.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * BannerItem:指的是一组轮播图上的某个图片
 * @Date: 2021/1/10 12:01
 * @Description:
 */
@Entity
public class BannerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键的生成策略--自增长
    private Long id;
    /**
     * 图片地址
     */
    private String img;
    /**
     * keyword：关键字，如果点击BannerItem跳转到某个SPU商品的详情页面，就必须要知道跳转到哪个具体的SPU的详情页面
     * 如果要跳转到SPU页面，可能keyword就是SPU的ID，跳转到专题上面，这个keyword可能就是这个专题的标识
     */
    private String keyword;
    /**
     * 点击这个BannerItem不仅仅可以跳转到SPU商品的详情页面，还可以跳转到一个专题上面，甚至可以跳转到任意页面。
     * 这个type:指的就是需要跳转的类型
     */
    private Short type;
    /**
     * BannerItem的名称
     */
    private String name;

    /**
     * 外键：反映Banner和BannerItem的关联关系
     */
    private Long bannerId;
}

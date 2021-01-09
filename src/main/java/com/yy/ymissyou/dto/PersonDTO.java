package com.yy.ymissyou.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

/**
 * PersonDTO：数据传输对象专门用来接收前端传过来的参数的对象
 *
 * @Date: 2020/12/27 05:38
 * @Description:
 */
//@ToString
//@Data // 不建议使用 会默认生成 setter/getter/equals/hashcode/toString方法
//@Setter
//@Getter
//@AllArgsConstructor // 会自动生成全参数的构造方法
//@RequiredArgsConstructor // 只为标注了 @NonNull的参数生成构造方法
//@Builder
@Setter
@Getter
@ToString
public class PersonDTO {

    @NonNull // 该参数不能为空
    @Length(min = 2, max = 10, message = "需要在2和10之间")
    private String name;
    private Integer age;
    @Valid // 作用：标记于级联属性之上，这样级联属性上的验证才能生效。
    private SchoolDTO schoolDTO;

    private String password1;
    private String password2;
}

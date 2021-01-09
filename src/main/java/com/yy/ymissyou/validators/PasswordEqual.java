package com.yy.ymissyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = PasswordValidator.class) // 标明该注解的实现逻辑
public @interface PasswordEqual {

    String message() default "passwords are not equal";
    int max() default 16;
    int min() default 1;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}

package com.yy.ymissyou.validators;

import com.yy.ymissyou.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Date: 2021/1/9 22:43
 * @Description: 自定义注解@PasswordEqual的实现，需要实现ConstraintValidator接口
 * <p>
 * PasswordEqual:注解类型
 * PersonDTO:注解作用的类型
 */
public class PasswordValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {

    private int max;
    private int min;

    @Override
    public boolean isValid(PersonDTO personDTO, ConstraintValidatorContext context) {
        return personDTO.getPassword1().equals(personDTO.getPassword2());
    }

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }
}

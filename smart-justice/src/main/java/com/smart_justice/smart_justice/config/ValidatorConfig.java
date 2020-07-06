package com.smart_justice.smart_justice.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @className: ValidatorConfig
 * @description: 数据校验配置:
 *                  配置hibernate Validator为快速失败返回模式
 * @author: ZSZ
 * @date: 2019/10/28 22:54
 */
@Configuration
public class ValidatorConfig {

    /**
     * 快速失败返回模式：快速失败返回模式只要有一个验证失败，则返回
     */
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                .addProperty( "hibernate.validator.fail_fast", "true" )
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator;
    }
}

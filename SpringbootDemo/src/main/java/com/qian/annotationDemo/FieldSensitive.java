package com.qian.annotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/2/26 13:19
 * @Description: 自定义注解，对敏感字段脱敏
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldSensitive {
    /**敏感字段脱敏格式，默认为自定义脱敏格式*/
    SensitiveEnum type() default SensitiveEnum.CUSTOMER;

    /**前缀不需要脱敏的长度*/
    int prefixNoMaskLen() default 1;

    /**后缀不需要脱敏的长度*/
    int suffixNoMaskLen() default 1;

    /**使用的脱敏占用符号*/
    String symbol() default "*";
}

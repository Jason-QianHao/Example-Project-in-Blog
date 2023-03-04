package com.qian.annotationDemo.aop;

import com.alibaba.fastjson.JSON;
import com.qian.annotationDemo.FieldSensitive;
import com.qian.annotationDemo.SensitiveEnum;
import com.qian.annotationDemo.model.User;
import com.qian.annotationDemo.util.SensitiveUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/3/4 14:35
 * @Description:
 */

@Aspect
@Component
public class SensitiveAop {

    /**
     * 定义切入点
     */
//    @Pointcut("execution(* com.qian..*.*(..))")
//    public void pointcut(){
//
//    }

    /**
     * 定义advisor
     */
    @Around("execution(* com.qian.annotationDemo.controller..*.*(..))")
    public Object aroundAop(ProceedingJoinPoint joinPoint) throws Throwable {
//        String methodName = joinPoint.getSignature().getName();
//        if(!methodName.equals("test")){
//            return data;
//        }
        Object data = joinPoint.proceed();
        if (data == null) {
            return "";
        }
        User user;
        if(data instanceof User) {
            user = (User) data;
        }if(data instanceof String){
            user = JSON.parseObject((String) data, User.class);
        }else {
            return "";
        }
        Class<?> objClass = user.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            FieldSensitive annotation = field.getAnnotation(FieldSensitive.class);
            if (annotation != null) {
                Object value = field.get(user);
                if (ObjectUtils.isNotEmpty(value) && StringUtils.isNotBlank((String)value)) {
                    SensitiveEnum sensitiveEnum = annotation.type();
                    int prefixNoMaskLen = annotation.prefixNoMaskLen();
                    int suffixNoMaskLen = annotation.suffixNoMaskLen();
                    String symbol = annotation.symbol();
                    switch (sensitiveEnum) {
                        case CUSTOMER:
                            value = SensitiveUtil.desValue((String)value, prefixNoMaskLen, suffixNoMaskLen, symbol);
                            break;
                        case ID_NO:
                            value = SensitiveUtil.hideIdNo((String)value);
                            break;
                        case NAME:
                            value = SensitiveUtil.hideName((String)value);
                            break;
                        case PHONE:
                            value = SensitiveUtil.hidePhone((String)value);
                            break;
                        default:
                            throw new IllegalArgumentException("unknown privacy type enum " + sensitiveEnum);
                    }
                    field.set(user, value);
                    field.setAccessible(false);
                }
            }
        }
        return JSON.toJSONString(user);
    }
}

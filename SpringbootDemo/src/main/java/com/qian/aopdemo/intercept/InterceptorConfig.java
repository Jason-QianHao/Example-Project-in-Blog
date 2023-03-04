package com.qian.aopdemo.intercept;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterceptorConfig {
    public static final String traceExecution = "execution(* com.qian.aopdemo.controller..*.*(..))";

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        /**创建自定义的方法拦截器*/
        MethodRTIntercept methodRTIntercept = new MethodRTIntercept();
        /**定义切入点Pointcut*/
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(traceExecution);
        /**定义通知Advisor*/
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(methodRTIntercept);
        return advisor;
    }
}
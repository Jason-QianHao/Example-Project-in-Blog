package com.qian.intercept;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/2/5
 * @Description: 在接口方法打印耗时日志
 */
@Component
public class MethodRTIntercept implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long startTs = System.currentTimeMillis();
        try {
            Object proceed = invocation.proceed();
            long endTs = System.currentTimeMillis();
            System.out.println("方法" + invocation.getMethod().getName() + "耗时：" + (endTs - startTs));
            return proceed;
        } catch (Exception e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }
}

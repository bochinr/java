package com.javaee.ex05.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class XmlAspect {
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("目标类：" + joinPoint.getTarget());
        System.out.println("被织入的方法：" + joinPoint.getSignature().getName());
        System.out.println("前置通知");
    }
    public void afterReturningAdivce(JoinPoint joinPoint){
        System.out.println("后置通知");
    }
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束");
        return object;
    }
    public void exceptionAdvice(Exception e){
        System.out.println("异常通知，异常信息是：" + e.toString());
    }
    private void afterAdvice(){
        System.out.println("最终通知");
    }
}

package com.javaee.ex05.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAspect {
    @Pointcut("execution(* com.javaee.ex05.service.impl.BookServiceImpl.*(..))")
    public void pointcut(){}
    @Before(value="pointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("目标类：" + joinPoint.getTarget());
        System.out.println("被织入的方法：" + joinPoint.getSignature().getName());
        System.out.println("前置通知");
    }
    @AfterReturning("pointcut()")
    public void afterReturningAdivce(JoinPoint joinPoint){
        System.out.println("后置通知");
    }
    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束");
        return object;
    }
    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void exceptionAdvice(Exception e){
        System.out.println("异常通知，异常信息是：" + e.toString());
    }
    @After("pointcut()")
    private void afterAdvice(){
        System.out.println("最终通知");
    }
}

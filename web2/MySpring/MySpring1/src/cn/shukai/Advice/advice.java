package cn.shukai.Advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class advice {
    public advice() {
    }
    @Before("execution(* cn.shukai.UserService.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("前置通知");
    }
    @AfterReturning("execution(* cn.shukai.UserService.UserServiceImpl.*(..))")
    public void afterReturing(){
        System.out.println("有异常就不会调用的后置通知");
    }
    @Around("execution(* cn.shukai.UserService.UserServiceImpl.*(..))")
    public void arround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("方法调用前的环绕通知");
        Object o=pjp.proceed();
        System.out.println("方法调用后的环绕通知");
    }
    @AfterThrowing("execution(* cn.shukai.UserService.UserServiceImpl.*(..))")
    public void afterThrowing(){
        System.out.println("出事啦，小老弟");
    }
    @After("execution(* cn.shukai.UserService.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("有异常也会调用的后置通知");
    }
}

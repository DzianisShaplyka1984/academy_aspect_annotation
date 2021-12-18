package com.academy.aspect;

import java.util.Date;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Work {

  @Pointcut("execution(* com.academy.service.TaskService.performJob(..))")
  public void performJobPointCut(){
  }

  @Pointcut("execution(* com.academy.service.TaskService.performExceptionJob())")
  public void performExceptionJobPointCut(){
  }

  @Pointcut("execution(* com.academy.service.TaskService.performJobAround())")
  public void performAroundJobPointCut(){
  }

  @Pointcut("execution(* com.academy.service.TaskService.performJobWithName(String)) && args(name))")
  public void performInterceptJobPointCut(String name){
  }

  @Before("performJobPointCut()")
  public void beforeWork() {
    System.out.println("Invoke code before work");
  }

  @After("performJobPointCut()")
  public void afterWork() {
    System.out.println("Invoke code after work");
  }

  @AfterThrowing("performExceptionJobPointCut()")
  public void afterExceptionWork() {
    System.out.println("Invoke code after exception work");
  }

  @Around("performAroundJobPointCut()")
  public void aroundWork(ProceedingJoinPoint point) {
    try {
      System.out.println("Start");
      var start = new Date().getTime();

      var result = (String) point.proceed();

      var end = new Date().getTime();
      System.out.println("End result " + result + " time " + (end - start));
    } catch (Throwable e) {
      System.out.println(e);
    }
  }

  @Before("performInterceptJobPointCut(name)")
  public void beforeJobWithName(String name) {
    System.out.println("Invoke code before exception with name " + name);
  }
}

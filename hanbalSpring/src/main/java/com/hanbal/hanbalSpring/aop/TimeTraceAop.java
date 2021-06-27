package com.hanbal.hanbalSpring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect /* AOP는 무조건 작성! */
@Component
public class TimeTraceAop {

    @Around("execution(* com.hanbal.hanbalSpring..*(..))") /* package 경로인듯..? */
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("Strat : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("End : " + joinPoint.toString() + " " + timeMs + " ms");
        }
    }

   }

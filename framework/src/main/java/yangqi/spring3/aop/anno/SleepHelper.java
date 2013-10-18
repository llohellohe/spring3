/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 类SleepHelper.java的实现描述：TODO 类实现描述
 * 
 * @author yangqi 2013-10-18 上午10:05:07
 */
@Aspect
public class SleepHelper {

    public SleepHelper() {
        System.out.println("INITING......");
    }

    @Pointcut("execution(* *.sleep(..))")
    public void sleeppoint() {
        System.out.println("SLEEPING POINT");
    }

    @Before("sleeppoint()")
    public void beforeSleep() {
        System.out.println("before sleep===");
    }

    @AfterReturning("sleeppoint()")
    public void afterSleep() {
        System.out.println("after sleep");
    }

    @Around("sleeppoint()")
    public void aroundSleep(ProceedingJoinPoint joinpoint) {
        System.out.println("====around===");
        try {
            joinpoint.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("====around===end");
    }

    @Pointcut("execution(* *.speak(String)) && args(talk)")
    public void speakpoint(String talk) {

    }

    @Before("speakpoint(talk)")
    public void beforeSpeak(String talk) {
        System.out.println("before speak " + talk);
    }
}

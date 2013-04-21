/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.aop;

import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 类Audience.java的实现描述：TODO 类实现描述
 * 
 * @author yangqi 2013-4-21 下午2:10:58
 */
public class Audience {

    public void takeSeats() {
        System.out.println("The audience is taking their seats.");
      }

    public void turnOffCellPhones() {
      System.out.println("The audience is turning off their cellphones");
    }

    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }
      public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }

    public void watchPerformance(ProceedingJoinPoint joinpoint) {
          try {
            System.out.println("WATCHING=============");
            System.out.println("The audience is taking their seats.");
            System.out.println("The audience is turning off their cellphones");
            long start = System.currentTimeMillis();
            joinpoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("CLAP CLAP CLAP CLAP CLAP");
            System.out.println("The performance took " + (end - start) + " milliseconds.");
            System.out.println("WATCHING END=============");
        } catch (Throwable t) {
            System.out.println("Boo! We want our money back!");
        }
}
}

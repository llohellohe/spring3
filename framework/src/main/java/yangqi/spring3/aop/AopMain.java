/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类AopRun.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-4-21 下午2:19:13
 */
public class AopMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

        Performer performer = (Performer) context.getBean("performer");

        System.out.println("START NOW");

        performer.perform();

        System.out.println("shit");
    }

}

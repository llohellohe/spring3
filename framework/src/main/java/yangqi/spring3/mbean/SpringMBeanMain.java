/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.mbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类AnnoMain.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-4-18 下午7:41:29
 */
public class SpringMBeanMain {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("mbean.xml");
    
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        AnnotationTestMBean bean = (AnnotationTestMBean) context.getBean("annotationTestMBean");
        while (true) {
           String name= bean.getName();
           System.out.println(name);
            Thread.sleep(1000);
        }

    }

}

/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类FactoryBeanMain.java的实现描述：TODO 类实现描述
 * 
 * @author yangqi 2013-10-19 下午8:28:06
 */
public class FactoryBeanMain {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");

    public static void main(String[] args) {
        Object obj1 = context.getBean("car");
        Object obj2 = context.getBean("car");
        System.out.println(obj1 == obj2);

        System.out.println(context.getBean("&car"));
    }
}

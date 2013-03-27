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
 * 类KnightMain.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-3-24 下午9:34:13
 */
public class KnightMain {

    /**
     * @param args
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");

        Knight knight = (Knight) context.getBean("knight");
        knight.embarkOnQuest();

        System.out.println("ID:" + context.getId());
        System.out.println("Name:" + context.getApplicationName());
        System.out.println("Display Name:" + context.getDisplayName());

        System.out.println("BEAN IS :");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

}

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

    private static ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
    /**
     * @param args
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Knight knight = (Knight) context.getBean("knight");
        knight.embarkOnQuest();

        System.out.println("ID:" + context.getId());
        System.out.println("Name:" + context.getApplicationName());
        System.out.println("Display Name:" + context.getDisplayName());
        System.out.println("Startup Date:" + context.getStartupDate());
        System.out.println("Parent:" + context.getParent());
        System.out.println("AutowireCapableFactory:" + context.getAutowireCapableBeanFactory());

        System.out.println("BEAN IS :");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        
        
        singletonAndPrototype();

        collectionBean();

    }

    /**
     * 
     */
    private static void collectionBean() {
        System.out.println("===========collectionBean===========");

        CollectionBean collection = (CollectionBean) context.getBean("collectionBean");

        if (collection.getStringList() != null) {
            for (String str : collection.getStringList()) {
                System.out.println("LIST: " + str);
            }
        }

        System.out.println("MAP: " + collection.getMap());

        System.out.println("SET: " + collection.getStringSet());

    }

    private static void singletonAndPrototype() {
        System.out.println("===========singletonAndPrototype===========");
        Knight knight1 = (Knight) context.getBean("knight");
        Knight knight2 = (Knight) context.getBean("knight");

        System.out.println(knight1 == knight2);

        Knight knight3 = (Knight) context.getBean("prototypeKnight");
        Knight knight4 = (Knight) context.getBean("prototypeKnight");
        System.out.println(knight1 == knight3);
        System.out.println(knight3 == knight4);
    }

}

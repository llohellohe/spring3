/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.aop.anno;

/**
 * 类Human.java的实现描述：TODO 类实现描述
 * 
 * @author yangqi 2013-10-18 上午10:17:50
 */
public class Human {

    public void sleep() {
        System.out.println("human sleep");
    }

    public void speak(String talk) {
        System.out.println("stark speaking of " + talk);
    }
}

/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.aop.anno;

/**
 * ��Human.java��ʵ��������TODO ��ʵ������
 * 
 * @author yangqi 2013-10-18 ����10:17:50
 */
public class Human {

    public void sleep() {
        System.out.println("human sleep");
    }

    public void speak(String talk) {
        System.out.println("stark speaking of " + talk);
    }
}

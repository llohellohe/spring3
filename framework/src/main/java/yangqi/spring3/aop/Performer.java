/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.aop;

/**
 * ��Performer.java��ʵ��������TODO ��ʵ������ 
 * @author yangqi 2013-4-21 ����2:37:49
 */
public class Performer {

    public String perform() {
        System.out.println("Perform " + System.currentTimeMillis());
        return "ok";
    }
}

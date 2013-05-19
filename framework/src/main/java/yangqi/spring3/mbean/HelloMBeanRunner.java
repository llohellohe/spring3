/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package yangqi.spring3.mbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * ��HelloMBeanRunner.java��ʵ��������TODO ��ʵ������
 * 
 * @author yangqi 2013-5-17 ����7:49:01
 */
public class HelloMBeanRunner {

    public static void main(String[] args) throws Exception {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("yangqi.mbean:type=Hello");
        Hello mbean = new Hello();
        mbs.registerMBean(mbean, name);

        while (true) {
            System.out.println(mbs.getAttribute(name, "CacheSize"));
            Thread.sleep(5000);
        }
    }

}

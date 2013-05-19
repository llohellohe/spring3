/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.mbean;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

/**
 * 类MbeanRunner.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-5-17 下午7:16:19
 */
public class MbeanRunner {

    private static ObjectName  objectName;
    private static MBeanServer mBeanServer;

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        init();
        manage();
    }

    private static void init() throws Exception {

        ServerImpl serverImpl = new ServerImpl();
        ServerMonitor serverMonitor = new ServerMonitor(serverImpl);

        mBeanServer = MBeanServerFactory.createMBeanServer();

        objectName = new ObjectName("objectName:type=ServerMonitor");

        mBeanServer.registerMBean(serverMonitor, objectName);

    }

    private static void manage() throws Exception {
        Long upTime = (Long) mBeanServer.getAttribute(objectName, "UpTime");
        System.out.println(upTime);
    }

}

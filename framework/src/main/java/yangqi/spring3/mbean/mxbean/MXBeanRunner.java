/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.mbean.mxbean;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 * 类MXBeanRunner.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-5-19 上午10:07:05
 */
public class MXBeanRunner {

    /**
     * @param args
     * @throws NullPointerException
     * @throws MalformedObjectNameException
     * @throws NotCompliantMBeanException
     * @throws MBeanRegistrationException
     * @throws InstanceAlreadyExistsException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws MalformedObjectNameException, NullPointerException,
                                          InstanceAlreadyExistsException, MBeanRegistrationException,
                                          NotCompliantMBeanException, InterruptedException {
        // TODO Auto-generated method stub
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName mxbeanName = new ObjectName("yangqi.mebean:type=GoQueueSampler");

        Queue<String> queue = new ArrayBlockingQueue<String>(10);
        queue.add("Request-1");
        queue.add("Request-2");
        queue.add("Request-3");
        QueueSampler mxbean = new QueueSampler(queue);

        mbs.registerMBean(mxbean, mxbeanName);

        System.out.println("Waiting...");

        while (true) {

            System.out.println(mxbean.getQueueSample());
            Thread.sleep(5000);
        }

    }

}

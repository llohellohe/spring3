/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Innterformation and shall use it
 * only in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package yangqi.spring3.mbean.mxbean;

/**
 * 类QueueSamplerMXBean.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-5-19 上午10:02:01
 */
public interface QueueSamplerMXBean {

    public QueueSample getQueueSample();

    public void clearQueue();

}

/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.mbean;

/**
 * ��ServerMonitor.java��ʵ��������TODO ��ʵ������ 
 * @author yangqi 2013-5-17 ����7:14:26
 */
public class ServerMonitor implements ServerMonitorMBean {

    private final ServerImpl target;

    private long             upTime;

    public ServerMonitor(ServerImpl target) {
        this.target = target;
    }

    public long getUpTime() {
        upTime = System.currentTimeMillis() - target.startTime;
        return upTime;
    }
}

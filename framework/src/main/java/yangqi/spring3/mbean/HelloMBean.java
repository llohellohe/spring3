/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the confidential and proprietary information of
 * Alibaba.com ("Confidential Information"). You shall not disclose suchnte Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package yangqi.spring3.mbean;

/**
 * ��HelloMBean.java��ʵ��������TODO ��ʵ������ 
 * @author yangqi 2013-5-17 ����7:44:20
 */
public interface HelloMBean {

    public void sayHello();

    public int add(int x, int y);

    public String getName();

    public int getCacheSize();

    public void setCacheSize(int size);

}

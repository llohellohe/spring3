/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3;

import org.springframework.beans.factory.FactoryBean;

/**
 * ��CarFactoryBean.java��ʵ��������TODO ��ʵ������
 * 
 * @author yangqi 2013-10-19 ����8:28:44
 */
public class CarFactoryBean implements FactoryBean {

    private String colors;

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObject()
     */
    @Override
    public Object getObject() throws Exception {
        String colorArray[] = colors.split(",");

        return colorArray[0];
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#getObjectType()
     */
    @Override
    public Class getObjectType() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.FactoryBean#isSingleton()
     */
    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

}

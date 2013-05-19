/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.mbean.mxbean;

import java.beans.ConstructorProperties;
import java.util.Date;

/**
 * 类QueueSample.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-5-19 上午10:02:27
 */
public class QueueSample {

    private final Date   date;
    private final int    size;
    private final String head;

    @ConstructorProperties({ "date", "size", "head" })
    public QueueSample(Date date, int size, String head) {
        this.date = date;
        this.size = size;
        this.head = head;
    }

    public Date getDate() {
        return date;
    }

    public int getSize() {
        return size;
    }

    public String getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "QueueSample [date=" + date + ", size=" + size + ", head=" + head + "]";
    }

}

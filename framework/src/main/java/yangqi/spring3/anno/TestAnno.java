/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.anno;



/**
 * 类TestAnno.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-4-18 下午8:21:18
 */
public class TestAnno {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Men men = new Men();

        Bind anno = men.getClass().getAnnotation(Bind.class);
        System.out.println(anno);


    }

}

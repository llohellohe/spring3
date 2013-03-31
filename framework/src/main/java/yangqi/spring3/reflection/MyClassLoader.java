/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.reflection;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 类MyClassLoader.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-3-31 下午5:00:41
 */
public class MyClassLoader extends ClassLoader {

    private String BASE = "/Users/yangqi/Dropbox/open-code/spring3/framework/ext-lib/";

    private int    size = 0;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String direName = name.replace(".", "/");
        byte[] data = getData(direName);
        
        return defineClass("name", data, 0, size);
    }

    /**
     * @param direName
     * @return
     */
    private byte[] getData(String dirName) {
        byte[] b = new byte[] {};
        try {
            String path = BASE + dirName + ".class";

            System.out.println("LOAD CLASS FROM " + path);
            InputStream reader = new FileInputStream(path);
            size = reader.read(b);


            reader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return b;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
                                          IllegalAccessException {
        MyClassLoader mcl = new MyClassLoader();
        Class c = mcl.loadClass("yangqi.spring3.reflection.Men", true);

        c.newInstance();


    }

}

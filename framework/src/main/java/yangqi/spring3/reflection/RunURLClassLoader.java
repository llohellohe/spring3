/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.reflection;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 类RunURLClassLoader.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-4-5 下午7:42:01
 */
public class RunURLClassLoader {

    /**
     * @param args
     * @throws MalformedURLException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     */
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException,
                                          InstantiationException, IllegalAccessException, SecurityException,
                                          NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        File classFolder = new File("/Users/yangqi/opensource/cp/bin/");

        URL url = new URL("file:///Users/yangqi/opensource/cp/bin/");

        ClassLoader classLoader = new URLClassLoader(new URL[] { url });

        String className = "yangqi.agent.WWE";

        Class clazz = Class.forName(className, true, classLoader);
        // Class clazz = classLoader.loadClass(className);
        System.out.println("===========NEW INSTANCE===========");
        Object obj = clazz.newInstance();

        Method m = clazz.getMethod("speak");

        m.invoke(obj);

        // Class clazz2 = classLoader.loadClass("yangqi.agent.WWE");
        // Object obj2 = clazz2.newInstance();

    }

}

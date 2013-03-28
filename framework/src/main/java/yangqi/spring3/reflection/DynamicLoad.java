/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 类DynamicLoad.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-3-27 下午10:25:54
 */
public class DynamicLoad {

    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
                                          IllegalAccessException, SecurityException, NoSuchMethodException {
        Class cls = Class.forName("yangqi.spring3.reflection.Men");
        System.out.println(cls);
        Object obj = cls.newInstance();
        Class cls2 = Class.forName("yangqi.spring3.reflection.Men");
        System.out.println(cls2);
        Object obj2 = cls2.newInstance();
        if (cls == cls2) {
            System.out.println("FUCK");
        }
        
        constructors();

    }

    public static void constructors() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
        Class cls = Class.forName("yangqi.spring3.reflection.Men");
        Constructor[] cons = cls.getConstructors();

        for (Constructor con : cons) {
            StringBuilder sb = new StringBuilder();
            sb.append(con.getName());

            for (Class<?> c : con.getParameterTypes()) {
                sb.append(" ").append(c);
            }
            System.out.println(sb.toString());
        }

        Constructor con = cls.getConstructor(new Class[] { String.class, int.class });
        try {
            con.newInstance(new Object[] { "yangqi", 16 });
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(con.getName());
    }

}

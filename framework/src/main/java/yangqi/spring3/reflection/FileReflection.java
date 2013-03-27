/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 类FileReflection.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-3-25 下午11:46:05
 */
public class FileReflection {

    /**
     * @param args
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

        Men men = new Men();
        Field[] fields = Men.class.getFields();
        System.out.println("===FIELDS===");

        men.setPrivateMenName("yangqi");

        int[] gs = { 1, 3, 4 };

        men.setGrades(gs);

        for (Field f : fields) {
            // f.setAccessible(false);
            System.out.println(f.getName() + f.get(men));
        }

        Field[] declareFields = Men.class.getDeclaredFields();
        System.out.println("===DECLARE FIELDS===");

        for (Field f : declareFields) {
            f.setAccessible(true);
            System.out.println(f.getName() + " : " + f.get(men));
        }

        System.out.println("===ALL FIELDS===");
        Class<? super Men> cls = Men.class;
        while (cls != null) {
            for (Field f : declareFields) {
                f.setAccessible(true);
                System.out.println(f.getModifiers() + f.getName() + f.getType() + f.getDeclaringClass() + f.get(men));

                if (f.getType() == int[].class) {
                    Object arrayField = f.get(men);
                    System.out.println("ARRAy type " + f.getType());
                    int length = Array.getLength(arrayField);
                    System.out.println("ARRAy length " + Array.getLength(arrayField));
                    for (int i = 0; i < length; i++) {
                        System.out.println(Array.get(arrayField, i));
                    }
                }
            }
            cls = cls.getSuperclass();
        }

        System.out.println(Modifier.toString(Modifier.PUBLIC));
    }

}

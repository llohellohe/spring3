/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

import yangqi.spring3.Knight;
import yangqi.spring3.KnightImpl;

/**
 * 类ProxyLoad.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-3-28 下午8:24:14
 */
public class ProxyLoad {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Knight k = new KnightImpl();
        Knight proxy = (Knight) Proxy.newProxyInstance(KnightImpl.class.getClassLoader(),
                                                       KnightImpl.class.getInterfaces(),
 new InvocationHandlerImpl(k));


        proxy.embarkOnQuest();

        proxy.embarkOnQuest();

        System.out.println(proxy.getClass());

        int mod = proxy.getClass().getModifiers();

        System.out.println(Modifier.toString(mod));
    }

}

class InvocationHandlerImpl implements InvocationHandler {

    private Knight target;

    public InvocationHandlerImpl(Knight target) {
        this.target = target;
    }


    /*
     * (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("PROXYING>>>");
        method.invoke(target, null);
        return null;
    }

}

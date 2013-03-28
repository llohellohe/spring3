Proxy用于代理Java类，它通过字节码生成的方式生成代理类。

代理的类名类似：com.sun.proxy.$Proxy0

是Proxy的public final子类。

#####一.创建一个代理

Proxy.newProxyInstance(ClassLoader cl,Class<?>interfaces[],InvocationHandler h);

#####二.实现InvocationHandler

接口InvocationHandler只有一个方法

public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable;
        

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
	

JDK代理的方法调用还是走反射的机制。性能差于cglib和asm直接生成的字节码。

JDK代理只能代理接口，不能代理普通类。
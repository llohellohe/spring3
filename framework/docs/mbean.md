###一.概述
MBean代表需要被管理的设备、程序等。JVM也提供了一系列的MXBean,通过MXBean可以观察JVM的一些运行数据。

MBean包含：

1.	可读、可写或者可读写的属性的集合
2.	可以被调用的方法的集合
3.	自描述

JMX规范定义了5种MBean：

1.	Standard MBean:需要固定的接口和定义，通过反射
2.	Dynamic MBean：不需要预先固定的接口和定义，而是通过调用DynamicMBean中定义的接口，这样可以保留了运行时的可变性。
3.	Open MBean
4.	Model MBean
5.	MXMBean


###二.Standard MBean

标准的MBean以XXMBean为接口名，名为XX的类实现XXMBean这个接口。

创建MBean之后，需要创建对应的Agent：

实例代码如下：

 		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("yangqi.mbean:type=Hello");
        Hello mbean = new Hello();
        mbs.registerMBean(mbean, name);

        while (true) {
            System.out.println(mbs.getAttribute(name, "CacheSize"));
            Thread.sleep(5000);
        }
通过 ManagementFactory可以创建MBean的Server,然后通过ObjectName注册MBean。

其中yangqi.mbean是mbean的namespace

运行jconsole,可以在MBean的Tab上看到注册的MBean,然后可以动态的调整属性的值。

注意获得属性的名称是首字母大写，而非首字母小写。

在jconsole中还可以动态调用方法。

[StandardMBean实例代码参考这里](https://github.com/llohellohe/spring3/blob/master/framework/src/main/java/yangqi/spring3/mbean/HelloMBeanRunner.java)。

###三.MXBean
标准的MBean只能支持原始属性的属性值，不能支持对象属性，MXBean则提供了这个扩展。

它将对象的属性封装成`javax.management.openmbean.CompositeDataSupport` 。

[MXBean实例代码参考这里](https://github.com/llohellohe/spring3/blob/master/framework/src/main/java/yangqi/spring3/mbean/mxbean/MXBeanRunner.java)。

JDK自带了多种MXBean，通过ManagementFactory可以获得这些MXBean。

1.	ClassLoadingMXBean 获得类加载信息的MXBean，可以动态开关`-verbose:class`选项
2.	CompilationMXBean 获得相应编译信息的MXBean
3.	GarbageCollectorMXBean 垃圾回收相关的MXBean
4.	MemoryMXBean 获得堆和非堆的内存大小
5.	OperatingSystemMXBean 操作系统的相关信息，CPU数、物理内存数等。
6.	RuntimeMXBean 获得运行时的一些相关数据,class path,vm版本号等。
7.	ThreadMXBean 获得线程相关的一些数据。

###四.Spring 3 中的MBean
通过Annotation能够方便的在Spring中声明一个MBean。

	@ManagedResource(objectName = "yangqi.spring3.mbean:name=SpringMBeanTest", description = "My Managed Bean")
	
表明改类是个MBean，它注册了objectName。

@ManagedAttribute用来声明MBean的属性，@ManagedOperation声明MBean的操作。

通过简单的配置：

	<context:mbean-server />
	  
	   <context:mbean-export default-domain="ShowCase" registration="replaceExisting" />
	 
	  <bean id="annotationTestMBean" class="yangqi.spring3.mbean.AnnotationTestMBean">  
	        <property name="name" value="TEST"/>  
	        <property name="age" value="100"/>  
	    </bean>
	    
就可以完成相应的MBean注册。

[参考代码](https://github.com/llohellohe/spring3/blob/master/framework/src/main/java/yangqi/spring3/mbean/SpringMBeanMain.java)

###附录
1.官方教程：http://docs.oracle.com/javase/tutorial/jmx/mbeans/index.html

2.IBM教程：http://www.ibm.com/developerworks/cn/java/j-lo-jse63/

3.Spring MBean :http://lionbule.iteye.com/blog/771727
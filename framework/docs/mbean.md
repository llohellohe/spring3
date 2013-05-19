###概述
MBean代表需要被管理的设备、程序等。

MBean包含：

1.	可读、可写或者可读写的属性的集合
2.	可以被调用的方法的集合
3.	自描述

JMX规范定义了5种MBean：

1.	Standard MBean
2.	Dynamic MBean
3.	Open MBean
4.	Model MBean
5.	MXMBean


###Standard MBean

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

	

可以注册一个MBean 的 Server。

注册MBean需要一个ObjectName,因此

###附录
1.官方教程：http://docs.oracle.com/javase/tutorial/jmx/mbeans/index.html

2.IBM教程：http://www.ibm.com/developerworks/cn/java/j-lo-jse63/
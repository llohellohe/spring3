####ClassLoader
###一.findClass

抽象类 ClassLoader中定义了寻找类的方法：

protected Class findClass(String name) throw ClassNotFoundException 。

子类必须实现findClass()方法，先找到类的字节数组，然后调用：

final Class<?> defineClass(String name,byte[] ,int offset,int lenth)

来获得 Class定义。



#######注意
1.	defineClass方法是final的，不可覆盖。
2.	findClass方法必须被实现

###二.loadClass
loadClass(String name,boolean resolve)方法可以指定是否解析类。解析是指是否将符号引用替换成直接引用，

虚拟机可以推迟解析这个步骤。

loadClass方法:

1.	public Class<?> loadClass(String name)
2.	protected synchronized Class<?> loadClass(String name, boolean resolve) 使用代理模型，先通过父类加载器加载，加载不到的时候用findClass()来加载。
3.	 private synchronized Class loadClassInternal(String name) 给虚拟机调用的方法，内部调用loadClass(String name)这个方法。


###三.URLClassLoader
基本上URLClassLoader可以完成一般的类加载功能。

它通过提供的URL来findClass，然后通过defineClass获得类定义。


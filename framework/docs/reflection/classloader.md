####ClassLoader

类的生命周期参看：[类和对象的生命周期](http://www.hiyangqi.com/JVM/jvm-class-lifecycle.html)

ClassLoader的loadClass方法，可以简单的可以对应到类初始化的生命周期三步：

1.	装载 findClass()
2.	连接(验证，准备，解析(resolvedClass))
3.	初始化 这一步在loadClass的时候并不会执行，也就是说loadClass后的类是不会调用静态初始化方法的<clinit>，只有在class.newInstance()的时候才会初始化。

具体的步骤是，调用ClassLoader的公开方法loadClass(String name)后，会经过以下步骤：

1.	调用 findLoadedClass()判断类是否已经加载，最终会调用native的findLoadedClass0（）方法。
2.	如果步骤1找到了的话，按需解析class。否则调用父class loader的loadClass()方法。这样就实现了代理加载。
3.	如果没找到，则调用findClass()方法，先找到字节数组，然后调用defineClass方法，将字节数组转化成Class定义。否则抛出ClassNotFoundException 。


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


###四.Class
使用Class.forName也可以获得一个类的定义。

1.	forName(String name)：内部调用native 的 forName0(String name,true,ClassLoader.getCallerClassLoader())
2.	forName(String name,boolean initialize,ClassLoader cl)

其中如果initialize为true，则会初始化类的静态初始化语句<clinit>

参考[URLClassLoader](https://github.com/llohellohe/spring3/blob/master/framework/src/main/java/yangqi/spring3/reflection/RunURLClassLoader.java)
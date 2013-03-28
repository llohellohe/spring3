###构造器Constructor

####一.简介
Constructor同Field类似，也是实现了Member接口，继承了AccessableObject。

Class.newInstance()的相当于new XX()。这样只是调用了默认的无参数构造器，如果需要调用有参数的构造器，则必须使用Constructor。




####二.反射获得构造器
1.	Class.getConstructors()可以获得PUBLIC的构造器。
2.	Class.getDeclaredConstructors()获得所有声明的构造器。
3.	Constructor<T> getConstructor(Class<?>... parameterTypes) 根据参数类型获得构造器

####三.Constructor的常用方法

1.	T newInstance(Object ... initargs)按照参数初始化一个实例
2.	 Class<?>[] getParameterTypes() 获得参数的类型




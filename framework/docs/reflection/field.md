###字段Filed

####一.简介
Filed代表类的字段，Filed实现了接口Member，继承了AccessibleObject 。

同样实现Member接口的还有Method。

AccessibleObject通过setAccessable(boolean flag)来设置是否允许访问非PUBLIC的成员。



#####(一).Member
Member接口定义了以下几个方法：

1.	定义的类：Class<?> getDeclaringClass();
2.	成员名称：String getName();
3.	获得修饰符：int getModifiers();
4.	是否有编译器引入：boolean isSynthetic();（Method的时候测试下）

#####(二).Modifier

其中Modifier定义了PUBLIC\PRIVATE\PROTECTED等修饰符。

判断是否是public:Modifier.isPublic(int mod)

根据mod获得modifier名称:Modifier.toString(Modifier.PUBLIC)


####三.反射Filed

Filed的常见方法有：

1.	getName()获得名称
2.	get(Object obj)获得字段值
3.	getInt(Object obj)获得int值,类似的还有getBoolean(Object obj)等等
4.	set(Object obj,Object value)设置字段值，类似的有setInt()等等
5.	class<?> getType()获得字段类型

#####(一).获得Public的字段:Class.getFields()

获得Modifier为PUBLIC的字段。

#####(二).获得所有定义的字段:Class.getDeclaredFields()

获得所有类中定义的字段。

以上两个方法都只能获得当前类中定义的字段，无法获得父类的字段。

需要通过当前类的getSuperClass()来获得父类。

	   Class<? super Men> cls = Men.class;
       while (cls != null) {
           for (Field f : declareFields) {
               f.setAccessible(true);
               System.out.println(f.getModifiers() + f.getName() + f.getType() + f.getDeclaringClass() + f.get(men));

           }
            cls = cls.getSuperclass();
        }


#####(三).数组类型

判断数组类型：filed.getType()==int[].class

可以通过Object obj=filed.get(instatce)来活的数组类型的值。

然后通过Array.getLength(obj)来判断长度。

Array.get(obj,index)来获得对应的值。


查看[代码例子](https://github.com/llohellohe/spring3/blob/master/framework/src/main/java/yangqi/spring3/reflection/FileReflection.java)
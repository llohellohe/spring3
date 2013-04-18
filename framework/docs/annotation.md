###注解Annotation
####一.定义

	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Bind {
	
	    public String value() default "";
	
	    public String name() default "yangqi";
	
	    int age();
	
	    boolean man();
	
	}

######@Target	
其中@Target表示注解的应用的范围，有:

 1.	TYPE 类
 2.	FIELD 字段
 3.	METHOD 方法
 4.	PARAMETER 参数
5.	CONSTRUCTOR 构造函数
6.	LOCAL_VARIABLE 本地变量
7.	ANNOTATION_TYPE 注解
8.	PACKAGE 包

如果注解没用应用在Target指定的范围，编译器会做提示。


######@Retention
定义注解的保留时期

RetentionPolicy定义了三个保留时期

1.	RUNTIME 运行时
2.	CLASS 编译期
3.	SOURCE 源代码

####二.解析注解
通过反射可以获得Annotaion，然后可以做相应解析。

	 Bind anno = men.getClass().getAnnotation(Bind.class);
	 
	 
[代码实例](https://github.com/llohellohe/spring3/blob/master/framework/src/main/java/yangqi/spring3/anno/TestAnno.java)
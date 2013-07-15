Spring通过依赖注入(Dependency Injection)和AOP来实现企业级Java编程以及代码间的松散耦合。

通过DI，应用的对象并不需要通过硬编码的方式知道依赖的对象从哪里来，或者如何实现的。

通常只是通过接口依赖，保持低耦合。

通过AOP,可以更加专注于核心的业务逻辑开发，其它的行为通过切面的方式进行。

和其它框架解决和简化特定领域问题不同，Spring从广义上简化Java的开发。

它通过以下四个关键点来实现：

1.	通过POJO(plain old java objects)实现最轻量级和最简化的开发。
2.	通过依赖注入和面向接口编程来解耦。
3.	声明式的面相切面的开发和按照约定开发
4.	通过模板类简化代码


#####关于第一点：

在EJB中，实现一个session功能，业务逻辑的代码可能必须继承SessionBean这个类，被迫添加一些不相关的方法。而在Spring中，你可以直接通过一个POJO，只需要关注你的业务逻辑即可。

#####关于第二点：

完全的不耦合是不可能的，但是必须妥善的管理各个依赖关系，做到最大程度的解耦。

#####关于第三点：

对于一些功能，比如事务、安全、日志等，系统的各个模块或者组件都会用到，如果按照普通的模式，可能会为各个组件带来两方面的复杂性：

1.	相关代码在各个组件中重复
2.	组件除了需要完成自己的业务逻辑外，还得关心如何管理事务，如何实现安全等。

通过AOP，可以将事务、安全等服务模块化，通过声明式的方法，为各个组件添加各个服务。

使业务逻辑更加内聚。


#####关于第四点：
比如开发JDBC代码，通常需要重复写些代码：获得连接、拼装statementet、获得数据等。

Spring将一些重复的代码抽成模板类，以此简化开发。





####一.BeanFactory和ApplicationContext区别

BeanFactory只提供基本的依赖注入支持，由接口org.springframework.beans.factory.BeanFactory接口定义。

ApplicationContext则除了BeanFactory的基本功能外，还提供了更复杂的功能。

如从properties文件上解析出文本消息，和发布事件到监听器上；

ApplicationContext由接口org.springframework.context.ApplicationContext定义，继承了BeanFactory接口。


####二.BeanFactory定义

1.	Object getBean(String name) throws BeansException;
2.	<T> T getBean(String name, Class<T> requiredType) throws BeansException;
3.	<T> T getBean(Class<T> requiredType) throws BeansException;
4.	Object getBean(String name, Object... args) throws BeansException;
5.	boolean containsBean(String name);
6.	boolean isSingleton(String name) throws NoSuchBeanDefinitionException;
7.	boolean isPrototype(String name) throws NoSuchBeanDefinitionException;
8.	boolean isTypeMatch(String name, Class<?> targetType) throws NoSuchBeanDefinitionException;
9.	Class<?> getType(String name) throws NoSuchBeanDefinitionException;
10.	String[] getAliases(String name);



####三.ApplicationContext定义


1.	String getId(); 返回唯一ID 实现名+内存地址。
2.	String getApplicationName(); 默认返回空。
3.	String getDisplayName(); 返回友好的名称
4.	long getStartupDate(); 返回启动时间
5.	ApplicationContext getParent(); 
6.	AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;

    

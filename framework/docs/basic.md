Spring通过依赖注入(Dependency Injection)和AOP来实现企业级Java编程以及代码间的松散耦合。

通过DI，应用的对象并不需要通过硬编码的方式知道依赖的对象从哪里来，或者如何实现的。

通常只是通过接口依赖，保持低耦合。

通过AOP,可以更加专注于核心的业务逻辑开发，其它的行为通过切面的方式进行。

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

    

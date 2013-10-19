不同于普通的bean，FactoryBean是创建Bean的Bean。

如果一个Bean的实现类实现了FactoryBean接口。

那么获得这个bean时，并不直接获得这个类的实例，而是返回getObject()方法返回的实例。

FactoryBean接口定义了三个方法：

1.	T getObject()  获得真正的Bean实例
2.	Class<?> getObjectType(); 获得实例的类型
3.	boolean isSingleton(); 获得的实例是否是单例

如果要获得FactoryBean实例本身，则需要在bean名称前加&

	ApplicationContext.getBean("&car");
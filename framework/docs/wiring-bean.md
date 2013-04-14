
###一.Bean配置的基本属性

####单例
默认bean是单例的，但是可以通过scope="prototype"来指定bean为每次都实例化一个新的原型出来。

Spring总共有5个Scope:

1.	singleton
2.	prototype
3.	request
4.	sessiong
5.	global session

####Factory Method
通过指定`factory-method`属性来执行构造bean的方法，该方法必须是无参数，static，且返回值为bean实例的，如

	public static KnightImpl instance() {
        System.out.println("GO INSTANCE");
        return new KnightImpl();
    }
    
    
Spring会通过指定方法来构造一个bean


####init-method和destroy-method
用于指定bean初始化后和bean被容器清除时调用的方法。

额外的，也可以通过继承InitializingBean和DisposableBean来实现init.

这样做的好处是不需要额外的配置，坏处是将代码和Spring的API代码耦合在一起。

org.springframework.beans.factory.InitializingBean的定义:

void afterPropertiesSet() throws Exception;


org.springframework.beans.factory.DisposableBean的定义:

void destroy() throws Exception;

如果多个bean需要初始化或者销毁方法，可以在beans中指定default-init-method和default-destroy-method 。

###二.构造函数注入
默认bean的初始化是调用无参数的构造函数，但是可以通过

`<constructor-arg value="xx" />`或者`<constructor-arg ref="xx-bean-name" />`注入。




###三.属性注入
通过<property value="xx">注入int string等基本属性的值，通过ref="xx"引用其它bean 。

####集合注入

######a.注入List
普通List值:

	<property name="stringList">
  		<list>
  			<value>book</value>
  			<value>car</value>
  		</list>
  	</property>


bean引用:

	<list>      <ref bean="guitar" />      <ref bean="cymbal" />      <ref bean="harmonica" />    </list>

######b.注入Set

普通Set值:

	<set>
  			<value>bookSet</value>
  			<value>carSet</value>
  	</set>

bean引用:

	 <set>      <ref bean="guitar" />      <ref bean="cymbal" />      <ref bean="harmonica" />      <ref bean="harmonica" />    </set>
    
######c.注入Map

普通Map值:

		<map>
  			<entry key="key1" value="1"/>
  			<entry key="key2"  value="2"/>
  		</map>
  		
  		
bean引用:
	
	key-ref和value-ref
	
	
	
###四.Spring Expressiong Language
通过spEL可以实现更加复杂的表达是配置，#{} 内表示的就是spEL语句。它可以做数学运算，字符串等处理    

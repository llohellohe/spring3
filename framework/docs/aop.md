

####一.术语解释：


#####横切关注点（cross-cutting concerns）
分散在应用各个点上的功能，叫做横切关注点，比如事务处理、安全处理、日志记录等。

AOP就是为了将横切关注点的逻辑从业务逻辑中剥离出来。

DI是为了对象间的解耦，AOP是为了将横切关注点和应用的对象间的解耦。

模块化的横切关注点可以被成为切面（Aspect）。

#####通知(Advice)
在特定的连接点，AOP框架执行的动作。通知定义了切面的what和when 。

一共有五种类型的通知:

1.	Before
2.	After
3.	After Returning
4.	After Throwing
5.	Around


#####连接点(Join Points)
切面可以插入的点。可以理解成，将切面代码插入到正常流程点中，以添加新的行为。

比如方法的调用、字段的修改、抛出异常等。

#####切入点（Pointcuts）
切入点定义了切面的where，即通知会被在哪个或者哪个几个连接点中被织入。

可以将切入点理解成连接点的子集。

#####切面(Aspect)
通知和切入点分别定义了切面的when\what和where 。即在那个时间点，在哪里应该切面应该做些什么。


#####引入（Introductions）
添加新的方法或者字段到现有的类中，以添加新的行为，但是不改变类身。

#####织入(Weaving)
织入是将切面应用的目标对象的过程，织入可以发生在以下三个时期：

1.	编译期
2.	类加载期
3.	运行期


####二.代码实例

	 <bean id="audience"
	      class="yangqi.spring3.aop.Audience" />
	      
	  <bean id="performer"
	      class="yangqi.spring3.aop.Performer" />
	      
	      
	 
	 <aop:config>
	  
	  	<aop:aspect ref="audience">
	  	
	  	<aop:pointcut id="performance" expression="execution(* yangqi.spring3.aop.Performer.perform(..))"/>
	  	
		  	<aop:before pointcut="execution(* yangqi.spring3.aop.Performer.perform(..))" method="takeSeats" />
		    <aop:before pointcut="execution(* yangqi.spring3.aop.Performer.perform(..))" method="turnOffCellPhones" />
		    <aop:after-returning pointcut-ref="performance" method="applaud" />
		    <aop:after-throwing pointcut="execution(* yangqi.spring3.aop.Performer.perform(..))" method="demandRefund" />
		    
		    <aop:around pointcut-ref="performance"  method="watchPerformance" />
		    
		</aop:aspect>
	  </aop:config>


其中<aop:before>、<aop:after>等定义了不同类型的通知，切入点为执行perform方法的时候，具体代码实例可以参看[这里](http://)。

###Spring AOP
横跨多层的功能点，被称为横切关注点，比如日志、安全、缓存等。

将软件的商业逻辑和横切关注点分割开来，正式AOP所需要完成的事情。

aspect使横切关注点模块化，这样横切点自己的逻辑，就可以统一维护，而不需要分布到各个层里面。

Spring使用JDK动态代理或者CGLIB，动态代理只能代理接口，而CGLIB则可以使Spring代理类。
###一.Spring AOP的一些概念
####(一).Joinpoint 连接点
程序执行中明确的点，比如方法的执行，异常的抛出。在Spring中，joinpoint就是方法的执行。

Joinpoint是切面应用的机会点，并不是所有的joinpoint都可以被切面应用。

####(二).Advice 通知
在特定的切入点，AOP框架执行的动作被称为advice,advice表示aspect在何时做什么事。通知的类型包含before\after\around等。

Spring使用了AOP联盟的标准接口 `org.aopalliance.aop.Advice`

实现了BeforeAdvice\AfterReturningAdvice\ThrowsAdvice等接口。

如果使用around通知，则必须实现类似的方法：

	public void watchPerformance(ProceedingJoinPoint joinpoint)
	
而且得在方法体中调用`ProceedingJoinPoint`的proceed()方法。

Advice实例配置参看[此处](https://github.com/llohellohe/spring3/blob/master/framework/src/main/resources/aop.xml)。

####(三).Pointcut 切入点
Pointcut是连接点的集合，AOP框架可以允许开发选择连接点，比如使用正则表达式。

Pointcut表示aspect在什么地方执行。

`org.springframework.aop.Pointcut`接口定义了两个重要的方法：
   
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

ClassFilter 用于判断该类是不是匹配切入点指定的类，

MethodMatcher 用于判断该方法是不是匹配切入点指定的方法。

#####静态切入点和动态切入点
静态切入点可以在方法第一次被调用的时候计算，这样可以缓存计算结果。

而动态切入点还会判断方法的参数等，因此不能缓存切入点计算结果。

####(四).aspect
advisor是aspect的模块化完整表示，包含advice和pointcut。

aspect包含advice和pointcut。

####(五).Weaving 织入
weaving是指应用aspect到目标类中，生成代理类的过程。

weaving可以发生在编译时、类加载时和运行时。

####二.使用annotation
annotation的用法可以参看[SleepHelper](https://github.com/llohellohe/spring3/blob/master/framework/src/main/java/yangqi/spring3/aop/anno/SleepHelper.java) 。

包含@Around和传递参数的用法。

其中@Pointcut注解的是个空方法（作为注解的载体），方法名即这个pointcut名称。

待补充4.4.3和4.5


####参考资料
1.《Spring Framework 开发参考手册》第 5 章 Spring AOP: Spring之面向方面编程 http://oss.org.cn/ossdocs/framework/spring/zh-cn/aop.html
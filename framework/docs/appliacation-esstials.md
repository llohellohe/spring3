####一.数据库操作支持
Spring通过Template和Callback这样的设计风格，简化数据库的访问逻辑。

其中Template是访问数据库的既定步骤，比如取得连接，提交事务，关闭连接等。

Callback则执行自定义的数据访问服务。

DAOSupport类则提供数据源相关的简便方法，应用的DAO可以继承这个支持类，来获得一些有用的功能，比如获得template进行插入等。


#####通过JNDI获得数据源
JNDI(Java Naming and Directory Interface),[参考](http://blog.csdn.net/adverse/article/details/1923242)

通过JNDI可以获得数据源，然后进行数据库操作。

	 try {
	            Context ctx = new InitialContext();
	     if (ctx == null) throw new Exception("No Context");
	     DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
	            if (ds == null) throw new Exception("jdbc/oracle is an unknown DataSource");
	            conn = ds.getConnection();
	            stmt = conn.createStatement();
	        } catch (Exception e) {
	            System.out.println("naming:" + e.getMessage());
	        }


在Spring 中可以这样配置获得datasource,

	<bean id="dbDataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
    	<property name="jndiName" value="java:comp/env/jdbc/DatabaseName"/>
	</bean>
	
	
也可以直接通过驱动配置获得数据源。

     <bean id="dataSource"              class="org.springframework.jdbc.datasource.                 DriverManagerDataSource">          <property name="driverClassName"                    value="org.hsqldb.jdbcDriver" />          <property name="url"                    value="jdbc:hsqldb:hsql://localhost/spitter/spitter" />          <property name="username" value="sa" />          <property name="password" value="" />        </bean>
        
####二.事务
事务：要么全部成功，要么全部失败。事务保证数据不会处于不一致的状态。
因此事务具有ACDI的特性，即：
1.	原子性
2.	一致性
3.	持续性
4.	隔离性
#####(一).定义事务
定义事务的manager
	<bean id="transactionManager" class="org.springframework.jdbc.  ̄datasource.DataSourceTransactionManager">          <property name="dataSource" ref="dataSource"/>        </bean>
        
#####编码式事务：TransactionTemplate

	 <bean id="spitterService"	              class="com.habuma.spitter.service.SpitterServiceImpl">	         ...	          <property name="transactionTemplate ">	<bean class="org.springframework.transaction.support. TransactionTemplate">	<property name="transactionManager" ref="transactionManager" />	            </bean>	          </property>	</bean>        

	public void saveSpittle(final Spittle spittle) {	  txTemplate.execute(new TransactionCallback<Void>() {	    public Void doInTransaction(TransactionStatus txStatus) {	      try {	      spitterDao.saveSpittle(spittle);	      } catch (RuntimeException e) {	        txStatus.setRollbackOnly();	throw e; }	      return null;	    }	}); }       
       
 在代码中使用TransactionTemplate的excute方法来达到事务的功能。
 
#####(二).声明式事务
 声明式事务通过Spring AOP实现。
 
 接口TransactionDefinition 定义了事务的传播行为(propagation behavior)和隔离级别(isolation level)。

TransactionDefinition的方法如下：

1.	int getPropagationBehavior();获得传播行为
2.	int getIsolationLevel();获得隔离级别
3.	int getTimeout();获得事务超时时间
4.	boolean isReadOnly();是否只读事务
5.	String getName();获得事务名称 
 
#####(1).传播行为 事务的传播行为（propagation）：定义了何时该新起或者挂起一个事务，或者何时改使用已经存在的事务。
 
1.	PROPAGATION_MANDATORY：方法必须在事务中执行，否则抛出异常。
2.	PROPAGATION_NEVER：从不在事务中执行，否则抛出异常。
3.	PROPAGATION_REQUIRED：如果已经存在事务，则在加入当前事务，否则新建一个事务。
4.	PROPAGATION_REQUIRES_NEW：必须在自己的事务中进行，如果已经存在一个事务，则挂起当前事务，新建一个事务。
5.	PROPAGATION_SUPPORTS：可以不在事务进行，但是也支持在已有事务中进行。
6.	PROPAGATION_NOT_SUPPORTED：以非事务进行，如果存在事务则挂起当前事务。
7.	PROPAGATION_NESTED：如果存在当前事务，则创建一个事务，作为嵌套事务执行；如果不存在事务，则以PROPAGATION_REQUIRED方式进行。

事务的传播行为定义在TransactionDefinition 接口中。


#####(2).隔离性

并发可能导致以下的问题：

1.	脏读：事务1读到事务2中没有提交的数据
2.	不可重复读：事务1重复查询，获得不同的结果。通常是由于事务2在同时更新数据。
3.	幻读：事务1在子查询中，查到比第一次多的数据，通常是事务2在同时插入数据。

事务的完全隔离可以避免上述问题，但是完全隔离会因为锁导致性能的损耗，因此定义了不同级别的隔离。

1.	ISOLATION_DEFAULT：使用底层数据源的默认隔离级别
2.	ISOLATION_READ_UNCOMMITTED：允许读到还没有提交的数据，会导致脏读、不可重复读和幻读。
3.	ISOLATION_READ_COMMITTED：只能读到已经提交的数据，可以避免脏读，但是会用不可重复读和幻读。
4.	ISOLATION_REPEATABLE_READ：有可能产生幻读。
5.	ISOLATION_SERIALIZABLE：可以避免脏读、不可重复读和幻读。

隔离级别同样定义在TransactionDefinition中。


#####(3).超时时间
定义事务的超时时间，如果超时时间到了，则该事务被自动回滚。

#####(4).只读属性
标注事务是只读还是读写，可以讲事务标注为只读，以提高性能。

#####(5).回滚规则
默认抛异常时（check and uncheck exception），事务将被回滚，通过回滚规则可以定义回滚的行为，比如只在某些异常的时候才回滚事务，而不是所有异常均回滚。


####(三).源码分析
#####(1).DataSourceTransactionManager
类图如下：

![image](https://raw.github.com/llohellohe/spring3/master/framework/docs/transaction-class.png)

接口 PlatformTransactionManager 定义了:

1.	获得事务状态：TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException;
2.	回滚事务：void commit(TransactionStatus status) throws TransactionException;
3.	提交事务：void rollback(TransactionStatus status) throws TransactionException;


接口TransactionStatus定义了事务的状态，

1.	是否新事务：boolean isNewTransaction();
2.	是否有保存点：boolean hasSavepoint();
3.	设置回滚：void setRollbackOnly();
4.	是否只回滚：boolean isRollbackOnly();
5.	刷新：void flush();
6.	是否完成：boolean isCompleted();

接口TransactionStatus继承了接口SavepointManager，在改接口中定义了:

1.	创建保存点：Object createSavepoint() throws TransactionException;
2.	回滚到保存点：void rollbackToSavepoint(Object savepoint) throws TransactionException;
3.	释放保存点：void releaseSavepoint(Object savepoint) throws TransactionException;

接口ResourceTransactionManager继承了PlatformTransactionManager，添加了:

Object getResourceFactory(); 方法获得资源工厂。

DataSourceTransactionManager继承了DataSourceTransactionManager类，实现了接口ResourceTransactionManager和InitializingBean

#####(1).TransactionTemplate

类图：
![image](https://raw.github.com/llohellohe/spring3/master/framework/docs/transaction-template.png)


TransactionTemplate继承了DefaultTransactionDefinition，实现了接口TransactionOperations和InitializingBean。

接口TransactionOperations 定义了事务的基本行为：

	<T> T execute(TransactionCallback<T> action) throws TransactionException;

接口TransactionCallback 定义了事务中的操作：

	T doInTransaction(TransactionStatus status);
	
DefaultTransactionDefinition 定义了默认的事务（传播行为为PROPAGATION_REQUIRE,隔离级别为默认，超时为-1,非只读）。

TransactionTemplate通过PlatformTransactionManager来获得事务，执行事务和提交事务。

它有个重要的方法：

	public <T> T execute(TransactionCallback<T> action) throws TransactionException ;
	




[参考资料](http://www.ibm.com/developerworks/cn/education/opensource/os-cn-spring-trans/index.html)

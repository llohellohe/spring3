###一.概述

Spring MVC 框架的入口就是`org.springframework.web.servlet.DispatcherServlet` 这个Servlet类，

配置如下：

	  <servlet>
            <servlet-name>spitter</servlet-name>
            <servlet-class>
               org.springframework.web.servlet.DispatcherServlet
             </servlet-class>
            <load-on-startup>1</load-on-startup>
      </servlet>
      
      
      <servlet-mapping>
            <servlet-name>spitter</servlet-name>
            <url-pattern>/</url-pattern>
      </servlet-mapping>
      
      
它将所有请求都代理到这个类上，请求会被如下的流程处理：

1.	处理映射，特定URL将被映射到特定的controller上
2.	controller处理逻辑，将数据绑定到model上，并返回逻辑view的名称
3.	通过view resolver解析逻辑的view,并将结果返回给DispatcherServlet
4.	返回response

#####静态资源
对于静态资源可以通过以下标签来处理：

	<mvc:resources mapping="/resources/**" location="/resources/" />
	
#####使用annotation
	<mvc:annotation-driven/>
	
###二.Controller

#####声明controller
使用@Controller可以声明一个类为Controller。@Controller同时是一个@Component，Spring会将此类作为一个Bean来处理。通过

	<context:component-scan base-package="XXX" />
	
将会扫描这个包下，来获得响应的类。

@RequestMapping注释的方法，可以声明Controller应该处理的url映射。

Controller可以脱离Web容器，进行方便的单元测试。

#####解析view
@RequestMapping声明的方法，返回逻辑的view名称，特定的ViewResolver解析这个逻辑名称，获得真正的view输出。

接口 `org.springframework.web.servlet.ViewResolver` 定义了唯一的方法,通过View的逻辑名称，获得View。

	View resolveViewName(String viewName, Locale locale) throws Exception;
	
接口View中定义了通过Model渲染view的方法：

	void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
UrlBasedViewResolver 通过Url来解析view，因此，具有prefix和suffix两个属性。

我们熟悉的VelocityViewResolver和InternelResourceViewResolver均继承自VelocityViewResolver 。


ViewResolver是通过byType形式组装给DispatchServlet的。


	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
     <property name="prefix" value="/WEB-INF/views/"></property>
     <property name="suffix" value=".jsp"></property>
 	</bean> 

处理请求参数
@RequestParam("xx")String xx，可以将请求参数绑定到xx上。



	
###附：
#####Jboss 7 中配置URI的编码

加在extentions标签后面
	
    <system-properties>
        <property name="org.apache.catalina.connector.URI_ENCODING" value="UTF-8"/>
        <property name="org.apache.catalina.connector.USE_BODY_ENCODING_FOR_QUERY_STRING" value="true"/>
    </system-properties>
[示例源代码](https://github.com/llohellohe/winstone/tree/master/code-src/o2-web)

处理参数：：http://localhost:8080/o2-web/student/show?name=o22

首页：http://localhost:8080/o2-web/home
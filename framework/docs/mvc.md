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


###三.REST
REpresentional State Transfer,REST是种面向资源的设计风格。

Representional:REST的资源可以被表示为多种形式，比如JSON\XML等。

State:REST更关注资源的状态而不是行为。

Transfer:资源可以被转移，或者理解成状态的变化（物理位置变化了也属于状态变化的一种）。

因此REST可以理解成：资源的状态转移。
￼
￼￼￼￼￼/book/show?id=XX 并不是RESTFull风格的URI，因为它是面向行为的，而非面向资源。

而/book/id/XXX 则是一个RESTFull风格的URI。

#####PathVariable
通过@RequestMapping和@PathVariable 两个注释，可以从URL中获得变量，如：

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@PathVariable("id") long id

可以从url中截取id这个变量。

#####Spring支持的4个动词

1.	GET:仅获得资源，不更新和删除资源
2.	PUT：新增资源
3.	POST：更新资源
4.	DELETE：删除资源

通过不同的动词，针对同个URI，可以产生不同的行为。

比如 GET /book/id/xx表示获得id为xx的书，而 POST /book/id/xx 表示更新id为xx的书。

HTTP定义了更多的动词：

1.	HEAD:只返回header
2.	TRACE:返回客户端的request body
3.	OPTIONS:返回客户端支持的访问方式

#####两种资源表现方法
Spring支持两种方法来表现资源：

1.	Negotiated view-based rendering
2.	Http Message Convertor

	
#####a.Negotiated view

	<bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">	  <property name="mediaTypes">	    <map>	      <entry key="json" value="application/json" />	      <entry key="xml" value="text/xml" />	      <entry key="htm" value="text/html" />	    </map>	  </property>	  <property name="defaultContentType" value="text/html" />	</bean>
	
ContentNegotiatingViewResolver首先判断客户端倾向什么格式的资源：

1.	从请求URI中找到合适资源类型，可以通过属性`favorPathExtension`来指定是否跳过这一步。
2.	从Header中解析accept头来解析合适的资源类型	
	
	
然后将view的解析代理给view resolver来渲染出具体的view。

#####b.HttpMessage Convertor
当处理请求的类返回的值是个对象的时候，如果通过@ResponseBody,可以调用对应的http message convertor来转换处理。

	  @RequestMapping(value = "/{username}", method = RequestMethod.GET,                        headers = {"Accept=text/xml, application/json"})        public @ResponseBody        Spitter getSpitter(@PathVariable String username) {          return spitterService.getSpitter(username);        }

@ResponseBody表明将返回一个资源，并且只接受请求时为headers指定的头的请求。



###附：
#####Jboss 7 中配置URI的编码

加在extentions标签后面
	
    <system-properties>
        <property name="org.apache.catalina.connector.URI_ENCODING" value="UTF-8"/>
        <property name="org.apache.catalina.connector.USE_BODY_ENCODING_FOR_QUERY_STRING" value="true"/>
    </system-properties>
[示例源代码](https://github.com/llohellohe/winstone/tree/master/code-src/o2-web)

处理参数：：http://localhost:8080/o2-web/student/show?name=o22

http://localhost:8080/o2-web/student/show?name=你好

首页：http://localhost:8080/o2-web/home
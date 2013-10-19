Spring Schema允许自定义schema来定义一个bean。而不是使用传统的bean定义方式。

比如：

	<aop:aspectj-autoproxy/>

创建的步骤很简单：

1.	创建XSD文件，描述bean的定义标签。
2.	创建NamespaceHandler实现，用来注册一个bean定义的解析器
3.	创建bean定义解析器BeanDefinitionParser
4.	注册namespace handler和xsd。

详细例子可以参看[文档](http://docs.spring.io/spring/docs/2.5.6/reference/extensible-xml.html)。
###spring.schemas
在spring.schemas文件中增加xsd的描述地址，比如：

	http\://code.alibabatech.com/schema/dubbo/dubbo.xsd=META-INF/dubbo.xsd

###spring.handlers
spring.handlers中定义具体的解析类，比如：

	http\://code.alibabatech.com/schema/dubbo=com.alibaba.dubbo.config.spring.schema.DubboNamespaceHandler
	
该Handler会负责去解析XML中的属性等信息。

###参考资料
1.	webx中的SpringExt http://openwebx.org/docs/springext.html
2.	基于Spring可扩展Schema提供自定义配置支持 http://blog.csdn.net/cutesource/article/details/5864562
3.	Extensible XML authoring http://docs.spring.io/spring/docs/2.5.6/reference/extensible-xml.html
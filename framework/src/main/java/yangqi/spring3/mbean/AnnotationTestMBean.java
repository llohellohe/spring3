/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.mbean;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "yangqi.spring3.mbean:name=SpringMBeanTest", description = "My Managed Bean")
public class AnnotationTestMBean {

    private String name;
    private int    age;

    @ManagedAttribute(description = "The Name Attribute")
    public void setName(String name) {
        this.name = name;
    }

    @ManagedAttribute()
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManagedOperation(description = "Add two numbers")
    @ManagedOperationParameters({ @ManagedOperationParameter(name = "x", description = "The first number"),
            @ManagedOperationParameter(name = "y", description = "The second number") })
    public int add_1(int x, int y) {
        return x + y;
    }

    @ManagedOperation
    public int add_2(int x, int y) {
        return x + y;
    }

    public void dontExposeMe() {
        throw new RuntimeException();
    }

}

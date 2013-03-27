/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.reflection;

/**
 * 类Person.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-3-25 下午11:43:53
 */
public class Person {

    private String   privateName;

    public String    publicName;

    protected String protectedName;

    String           packName;

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getProtectedName() {
        return protectedName;
    }

    public void setProtectedName(String protectedName) {
        this.protectedName = protectedName;
    }


}

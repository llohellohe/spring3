/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package yangqi.spring3.reflection;

/**
 * 类Men.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-3-25 下午11:45:05
 */
public class Men extends Person {

    private String   privateMenName;
    protected String protectedMenName;
    public String    publicMenName;
    String           packMenName;

    public int[]     grades;

    static {
        System.out.println("INIT STATIC OF MEN");
    }

    public Men() {
        System.out.println("MEN I AM COMMON INIT ");
    }

    public Men(int i) {
        System.out.println("MEN I AM INT INIT WITH " + i);
    }

    public Men(String s, int i) {
        System.out.println("MEN I AM STRING INT INIT WITH " + s + " " + i);
    }

    public String getPrivateMenName() {
        return privateMenName;
    }

    public void setPrivateMenName(String privateMenName) {
        this.privateMenName = privateMenName;
    }

    public String getProtectedMenName() {
        return protectedMenName;
    }

    public void setProtectedMenName(String protectedMenName) {
        this.protectedMenName = protectedMenName;
    }

    public String getPublicMenName() {
        return publicMenName;
    }

    public void setPublicMenName(String publicMenName) {
        this.publicMenName = publicMenName;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

}

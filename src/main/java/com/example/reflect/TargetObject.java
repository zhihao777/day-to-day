package com.example.reflect;

/**
 * @ClassName TargetObject
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/3/5
 * @Version V1.0
 **/
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}

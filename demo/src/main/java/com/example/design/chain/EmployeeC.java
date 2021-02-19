package com.example.design.chain;

/**
 * @ClassName EmployeeC
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/2/19
 * @Version V1.0
 **/
public class EmployeeC extends AbstractChain {
    public void doChain(String name) {
        System.out.println("基层员工开始"+name);
        chain.doChain(name);
        System.out.println("基层员工"+name+"完毕");
    }
}

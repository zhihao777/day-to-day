package com.example.design.chain;

/**
 * @ClassName EmployeeA
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/2/19
 * @Version V1.0
 **/
public class EmployeeA extends AbstractChain {
    public void doChain(String name) {
        if("离职".equals(name)){
            System.out.println("员工A无法解决离职问题，移送boss");
            chain.doChain(name);
        }else {
            System.out.println("员工A解决"+name);
        }
    }
}

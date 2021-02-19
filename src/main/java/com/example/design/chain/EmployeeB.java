package com.example.design.chain;

/**
 * @ClassName EmployeeB
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/2/19
 * @Version V1.0
 **/
public class EmployeeB extends AbstractChain {
    public void doChain(String name) {
        if("请假".equals(name)||"离职".equals(name)){
            System.out.println("员工B无法解决请假或者离职问题，移送员工A");
            chain.doChain(name);
        }else {
            System.out.println("员工B解决"+name);
        }
    }
}

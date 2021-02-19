package com.example.design.chain;

/**
 * @ClassName TestAbstractChain
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/2/19
 * @Version V1.0
 **/
public class TestAbstractChain {
    public static void main(String[] args) {
        Boss boss = new Boss();
        AbstractChain.Buider buider = new AbstractChain.Buider();
        buider.addChain( new EmployeeC())
                .addChain( new EmployeeB())
                .addChain( new EmployeeA())
                .addChain(new Boss()).build();
        //buider.build().doChain("离职");
        buider.build().doChain("请假");
    }
}

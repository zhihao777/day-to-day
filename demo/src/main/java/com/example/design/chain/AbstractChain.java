package com.example.design.chain;

/**
 * @ClassName AbstractChain
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/2/8
 * @Version V1.0
 **/
public abstract class AbstractChain<T> {
    protected AbstractChain<T> chain;

    public void next(AbstractChain<T> chain){
        this.chain = chain;
    }

    public void doChain(String name){
        System.out.println("开始做某事");
    }

    public static class Buider<T>{
        private AbstractChain<T> header;
        private AbstractChain<T> tail;

        public Buider<T> addChain(AbstractChain<T> chain){
            if(header == null){
                this.header = this.tail = chain;
                return this;
            }
            this.tail.next(chain);
            this.tail = chain;
            return this;
        }

        public AbstractChain<T> build(){
            return this.header;
        }
    }

}

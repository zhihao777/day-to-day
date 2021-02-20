package com.example.thread;

/**
 * @ClassName ABC_Condition_2
 * @Description: TODO
 * @Author zhiHao
 * @Date 2021/2/20
 * @Version V1.0
 **/

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 问题：实现一个多线程类，并用该线程类实例化3个线程A,B,C；A线程打印字符A,B线程打印字符B，C线程打印字符C；
 * 启动这3个线程，要求启动线程的顺序为C线程->B线程->A线程，并且最后输出内容为：
 * A
 * B
 * C
 * 不能用sleep函数，注意考虑线程安全问题。
 */
public class ABC_Condition_2 {

    private static Lock lock = new ReentrantLock();
    private static Condition condition_A = lock.newCondition();
    private static Condition condition_B = lock.newCondition();
    private static Condition condition_C = lock.newCondition();
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        new Thread("线程C") {
            public void run() {
                try {
                    lock.lock();
                    while(atomicInteger.get() != 3){
                        condition_C.await();
                    }
                    System.out.println("C");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while(atomicInteger.get() != 2){
                        condition_B.await();
                    }
                    System.out.println("B");
                    atomicInteger.incrementAndGet();
                    condition_C.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "线程B").start();

        new Thread(()->{
            try {
                lock.lock();
                while(atomicInteger.get() != 1){
                    condition_A.await();
                }
                System.out.println("A");
                atomicInteger.incrementAndGet();
                condition_B.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"线程A").start();

    }

}

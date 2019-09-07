package com.mz.write;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
public class Ticket {

    private Lock lock = new ReentrantLock();

    private int max =0;

    public synchronized void jia() {
        try {
            while (max!=0){
                this.wait();
                Condition condition = lock.newCondition();
            }
            ++max;
            System.out.println(Thread.currentThread().getName()+"\t"+max);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }


    public synchronized void jian() {
        try {
            while (max==0){
                this.wait();
            }
            --max;
            System.out.println(Thread.currentThread().getName()+"\t"+max);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}

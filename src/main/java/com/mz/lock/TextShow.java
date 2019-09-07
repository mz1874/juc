package com.mz.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TextShow {

    private Integer num = 1;

    /**
     * 线程类
     */
    private Lock lock = new ReentrantLock();
    //线程调度对象 用于替换synchronized Write和this.notifyAll();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (num != 1) {
                /*使 c1 休眠*/
                c1.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t5");
            //唤醒C2
            num=2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (num != 2) {
                /*使 c1 休眠*/
                c2.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t10");
            //唤醒C2
            num=3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (num != 3) {
                /*使 c3休眠*/
                c3.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t15");
            //唤醒C1
            num=1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

package com.mz.lockwrite;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
public class LockTicket {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int max = 0;

    public void jia() {
        lock.lock();
        try {
            while (max != 0) {
                /*休眠  释放锁*/
                condition.await();
            }
            TimeUnit.MILLISECONDS.sleep(50);
            ++max;
            /*唤醒其他休眠的线程 所有*/
            System.out.println(Thread.currentThread().getName() + "\t" + max);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void jian() {
        lock.lock();
        try {
            while (max == 0) {
                /*休眠  释放锁*/
                condition.await();
            }
            TimeUnit.MILLISECONDS.sleep(50);
            --max;
            /*唤醒其他休眠的线程 所有*/
            System.out.println(Thread.currentThread().getName() + "\t" + max);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

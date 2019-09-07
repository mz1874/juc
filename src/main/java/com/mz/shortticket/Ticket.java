package com.mz.shortticket;

import java.security.acl.LastOwnerException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
public class Ticket {

    private Lock lock = new ReentrantLock();

    private int max = 120;

    public void reduce() {
        lock.lock();
        try {
            max--;
            System.out.println(Thread.currentThread().getName()+"剩余->"+max+"张");
        } finally {
            lock.unlock();
        }
    }
}

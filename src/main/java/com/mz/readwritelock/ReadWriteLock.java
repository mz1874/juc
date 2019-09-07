package com.mz.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    private Object objec;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public void write() {
        lock.writeLock().lock();
        try {
            this.objec = "原来你是我最想留住的幸运";
        } finally {
            lock.writeLock().unlock();
        }

    }

    public void read() {
        lock.readLock().lock();
        try {
            System.out.println(objec+"\t"+Thread.currentThread().getName());
        } finally {
            lock.readLock().unlock();
        }
    }
}

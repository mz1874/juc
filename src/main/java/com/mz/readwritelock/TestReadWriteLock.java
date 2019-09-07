package com.mz.readwritelock;

import java.util.concurrent.TimeUnit;

public class TestReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock readWriteLock=new ReadWriteLock();

        new Thread(()->{
            readWriteLock.write();
        },"AA").start();
        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                readWriteLock.read();
            },String.valueOf(i)).start();
        }

    }

}

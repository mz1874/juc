package com.mz.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * seməfɔː
 */
public class TestSemaphore {
    public static void main(String[] args) {

        //多个线程争抢有限的资源，如果Semaphore 为1 则和synchronized一致
        Semaphore semaphore=new Semaphore(2);
        for (int i=0;i<6;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"获得");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(7));
                    System.out.println(Thread.currentThread().getName()+"离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}

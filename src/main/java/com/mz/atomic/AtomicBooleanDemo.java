package com.mz.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDemo {
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    private boolean index = true;


    public static void testCas() {

        System.out.println(Thread.currentThread().getName() + "\t" + atomicBoolean.get());

        /*如果当前的状态为 expect 预期值的话  则更改为 update*/
        if (atomicBoolean.compareAndSet(true, false)) {
            System.out.println(Thread.currentThread().getName() + "\t" + atomicBoolean.get()+"\t"+"进入");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicBoolean.set(true);
            System.out.println(Thread.currentThread().getName() + "\t" + "离开-->结束");
        } else {
            System.out.println("重试中"+Thread.currentThread().getName() + "\t" + atomicBoolean.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            testCas();
        }

    }

    public static void main(String[] args) {
        new Thread(() -> {
            testCas();
        }, "AA").start();

        new Thread(() -> {
            testCas();
        }, "BB").start();
    }

}

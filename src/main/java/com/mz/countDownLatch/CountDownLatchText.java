package com.mz.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchText {
    private static final int NUM = 2;

    public static void main(String[] args) throws InterruptedException {

        /**
         * 调用一次  减少一次
         */
        CountDownLatch countDownLatch = new CountDownLatch(NUM);
        for (int i = 0; i < NUM; i++) {
            new Thread(() -> {
                System.out.println(countDownLatch.getCount());
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
                /*从枚举类中获取线程的名字*/
            }, ResponseEnum.ResponseEnumForeach(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println("主线程结束");
    }
}

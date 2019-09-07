package com.mz.lock;

public class TestThread {
    public static void main(String[] args) {
        TextShow textShow=new TextShow();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                textShow.print5();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                textShow.print10();
            }
        },"BB").start();


        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                textShow.print15();
            }
        },"CC").start();
    }
}


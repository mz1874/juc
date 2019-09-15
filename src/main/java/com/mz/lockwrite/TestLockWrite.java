package com.mz.lockwrite;

public class TestLockWrite {
    public static void main(String[] args) {
        LockTicket ticket=new LockTicket();

        new Thread(()->{
            for (int i = 0; i <10 ; i++)ticket.jia();
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++)ticket.jian();
        },"BB").start();


        new Thread(()->{
            for (int i = 0; i <10 ; i++)ticket.jia();
        },"CC").start();


        new Thread(()->{
            for (int i = 0; i <10 ; i++)ticket.jian();
        },"DD").start();


        new Thread(()->{
            for (int i = 0; i <10 ; i++)ticket.jia();
        },"EE").start();


        new Thread(()->{
            for (int i = 0; i <10 ; i++)ticket.jian();
        },"FF").start();

    }
}

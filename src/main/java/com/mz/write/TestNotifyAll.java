package com.mz.write;

public class TestNotifyAll {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> { for (int i = 0; i <20 ; i++) ticket.jia(); }, "AA").start();
        new Thread(() -> { for (int i = 0; i <20 ; i++) ticket.jian(); }, "BB").start();

        new Thread(() -> { for (int i = 0; i <20 ; i++) ticket.jia(); }, "CC").start();
        new Thread(() -> { for (int i = 0; i <20 ; i++) ticket.jian(); }, "DD").start();

        new Thread(() -> { for (int i = 0; i <20 ; i++) ticket.jia(); }, "EE").start();
        new Thread(() -> { for (int i = 0; i <20 ; i++) ticket.jian(); }, "FF").start();

        new Thread(() -> { for (int i = 0; i <20 ; i++) ticket.jia(); }, "HH").start();
        new Thread(() -> { for (int i = 0; i <20 ; i++) ticket.jian(); }, "GG").start();
    }
}

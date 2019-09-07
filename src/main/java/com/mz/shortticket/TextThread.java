package com.mz.shortticket;

public class TextThread {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.reduce();
            }

        }, "第一个").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.reduce();
            }

        }, "第二个").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.reduce();
            }

        }, "第三个").start();

    }
}

package com.youngstone.mastery.exception;

import org.junit.jupiter.api.Test;

public class ThrowUncheckedExceptionTaskTest {

    @Test
    void testRunThrowUncheckedExceptionWithHandler() {
        ThrowUncheckedExceptionTask task = new ThrowUncheckedExceptionTask();
        Thread t = new Thread(task);
        t.setUncaughtExceptionHandler(new ExceptionHandler());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("completed");
        System.out.println(t.isAlive());
        System.out.printf("Thread status: %s\n", t.getState());
    }

    @Test
    void testRunThrowUncheckedExceptionWithDefaultHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        ThrowUncheckedExceptionTask task = new ThrowUncheckedExceptionTask();
        Thread t = new Thread(task);
        // t.setUncaughtExceptionHandler(new ExceptionHandler());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("completed");
        System.out.println(t.isAlive());
        System.out.printf("Thread status: %s\n", t.getState());
    }

    @Test
    void testRunThrowUncheckedExceptionWithoutHandler() {
        ThrowUncheckedExceptionTask task = new ThrowUncheckedExceptionTask();
        Thread t = new Thread(task);
        // t.setUncaughtExceptionHandler(new ExceptionHandler());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("completed");
        System.out.println(t.isAlive());
        System.out.printf("Thread status: %s\n", t.getState());
    }
}

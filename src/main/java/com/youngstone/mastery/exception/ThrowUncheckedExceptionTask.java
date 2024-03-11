package com.youngstone.mastery.exception;

public class ThrowUncheckedExceptionTask implements Runnable {

    @Override
    public void run() {
        // try {
        int numero = Integer.parseInt("TTT");
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        System.out.println("shouldn't be reached...");
    }

}

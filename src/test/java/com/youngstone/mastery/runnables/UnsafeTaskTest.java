package com.youngstone.mastery.runnables;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class UnsafeTaskTest {

    @Test
    void testRun() {
        UnsafeTask task = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

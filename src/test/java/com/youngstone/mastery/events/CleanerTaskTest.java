package com.youngstone.mastery.events;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.junit.jupiter.api.Test;
import com.youngstone.mastery.events.Event;

public class CleanerTaskTest {

    @Test
    void testClean() {
        Deque<Event> deque = new ConcurrentLinkedDeque<Event>();

        WriterTask writer = new WriterTask(deque);
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }
        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
        try {
            cleaner.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

package ua.kpi.pti.lab12;

import org.junit.Test;

import static org.junit.Assert.*;

public class RingBufferTest {

    @Test
    public void test() throws InterruptedException {
        RingBuffer ringBuffer = new RingBuffer(2);
        ringBuffer.add("A");
        ringBuffer.add("B");
        assertTrue(ringBuffer.isFull());

        ringBuffer.clear();
        assertFalse(ringBuffer.isFull());
    }

}
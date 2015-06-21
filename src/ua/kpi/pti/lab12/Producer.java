package ua.kpi.pti.lab12;

import java.util.Random;

public class Producer implements Runnable {

    private boolean active = true;
    private RingBuffer ringBuffer;

    public Producer(RingBuffer ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (active) {
                int number = random.nextInt(100);
                ringBuffer.add(number);
                if (number % 5 == 0) {
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Error");
        }

    }

    public void close() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }
}

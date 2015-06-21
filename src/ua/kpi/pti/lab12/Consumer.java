package ua.kpi.pti.lab12;

import java.util.Random;

public class Consumer implements Runnable {

    private boolean active = true;
    private RingBuffer ringBuffer;

    public Consumer(RingBuffer ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (active) {
            int number = random.nextInt(10);
            try {
                Object el = ringBuffer.peek();
                System.out.println(el);
                if (number == 5) {
                    ringBuffer.clear();
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException("Error");
            }
        }
    }

    public void close() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }
}

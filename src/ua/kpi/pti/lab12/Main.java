package ua.kpi.pti.lab12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RingBuffer ringBuffer = new RingBuffer(10);
        Consumer consumer = new Consumer(ringBuffer);
        Producer producer = new Producer(ringBuffer);

        new Thread(consumer).start();
        new Thread(producer).start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext() || !consumer.isActive() || !producer.isActive()) {
                System.exit(0);
            }
        }
    }

}

package ua.kpi.pti.lab11;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SinParallel {

    public double sin(int threads, int n) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(-n);
        Map<SinRunnable, Thread> pool = new HashMap<>();

        //Подготовим потоки
        for (int i = 0; i < threads; i++) {
            SinRunnable runnable = new SinRunnable(n, counter);
            pool.put(runnable, new Thread(runnable));
        }

        //Запускаем потоки
        for (Thread thread : pool.values()) {
            thread.start();
        }

        //Ожидаем завершения
        double result = 0;
        for (Map.Entry<SinRunnable, Thread> entry : pool.entrySet()) {
            SinRunnable runnable = entry.getKey();
            Thread thread = entry.getValue();
            thread.join();
            result += runnable.result;
            System.out.println(thread.getName() + ": " + runnable.i);
        }

        return result;

    }

    private static class SinRunnable implements Runnable {

        private int n;
        AtomicInteger counter;
        int i;
        double result;

        public SinRunnable(int n, AtomicInteger counter) {
            this.n = n;
            this.counter = counter;
        }

        @Override
        public void run() {
            while (true) {
                int x = counter.incrementAndGet();
                if (x > n) {
                    break;
                }
                result += Math.sin(x);
                i++;
            }

        }


    }
}

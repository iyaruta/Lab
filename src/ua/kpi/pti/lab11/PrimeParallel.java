package ua.kpi.pti.lab11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeParallel {

    private ExecutorService service;

    public PrimeParallel(int threads) {
        service = Executors.newFixedThreadPool(threads);
    }

    public void prime(final int n) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                boolean isPrime = true;
                int num = 3;
                int prime = 3;
                for (int count = 2; count <= n; ) {
                    for (int j = 2; j <= num / 2; j++) {
                        if (num % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        count++;
                        prime = num;
                    }
                    isPrime = true;
                    num++;
                }
                System.out.println(prime);
            }
        });
    }

}

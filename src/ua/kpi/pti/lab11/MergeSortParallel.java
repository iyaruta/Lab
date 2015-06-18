package ua.kpi.pti.lab11;

import java.util.Arrays;

public class MergeSortParallel {

    private int threads;

    public MergeSortParallel(int threads) {
        this.threads = threads;
    }

    public void parallelMergeSort(int[] a) throws InterruptedException {
        if (a.length < 2) {
            return;
        }

        parallelMergeSort(a, threads);
    }

    private void parallelMergeSort(int[] a, int threadCount) throws InterruptedException {
        if (threadCount <= 1) {
            mergeSort(a);
        } else {

            int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

            Thread lThread = new Thread(new Sorter(left, threadCount / 2));
            Thread rThread = new Thread(new Sorter(right, threadCount / 2));
            lThread.start();
            rThread.start();

            lThread.join();
            rThread.join();
            merge(left, right, a);
        }
    }

    private void mergeSort(int[] a) {
        if (a.length < 2) {
            return;
        }

        int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
        int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, a);
    }

    public void merge(int[] left, int[] right, int[] a) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
                a[i] = left[i1];
                i1++;
            } else {
                a[i] = right[i2];
                i2++;
            }
        }
    }

    private class Sorter implements Runnable {
        private int[] a;
        private int threadCount;

        public Sorter(int[] a, int threadCount) {
            this.a = a;
            this.threadCount = threadCount;
        }

        public void run() {
            try {
                parallelMergeSort(a, threadCount);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
    }

}

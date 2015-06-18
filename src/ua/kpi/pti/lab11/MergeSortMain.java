package ua.kpi.pti.lab11;

import java.util.Random;

public class MergeSortMain {

    public static void main(String[] args) throws Throwable {
        Random random = new Random();
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }

        MergeSortParallel mergeSortParallel = new MergeSortParallel(5);
        mergeSortParallel.parallelMergeSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}

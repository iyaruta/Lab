package ua.kpi.pti.lab11;

public class PrimeMain {

    public static void main(String[] args) {
        PrimeParallel primeMain = new PrimeParallel(3);
        int var[] = {3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : var) {
            primeMain.prime(i);
        }
    }

}

package ua.kpi.pti.lab11;

public class SinMain {

    public static void main(String[] args) throws InterruptedException {
        SinParallel sinParallel = new SinParallel();
        double sin = sinParallel.sin(5, 1000000);
        System.out.println(sin);
    }

}

package ua.kpi.pti.lab2;

public class Lab_2 {

    public static void main(String[] abc) {
        Lab_2 lab_2 = new Lab_2();
        System.out.println(lab_2.num(3567));
        System.out.println(lab_2.number(123));
        System.out.println(lab_2.pow(3, 2));
        System.out.println(lab_2.factorial(4));
        System.out.println(lab_2.fib(11));
        System.out.println(lab_2.math(5, 1));
    }

    //1
    public int num(int x) {
        int y = 1;
        while (x > 9 || x < -9) {
            x /= 10;
            y++;
        }
        return y;
    }

    //2
    public int number(int x) {
        if (x < 10) {
            return x;
        }
        int y = x % 10;
        int n = number(x / 10);
        while (x > 9) {
            x /= 10;
            y *= 10;
        }
        return y + n;
    }

    //3
    public int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * pow(x, --n);
    }

    //4
    public int factorial(int x) {
        if (x == 1) {
            return x;
        }
        return x * factorial(--x);
    }

    //5
    public int fib(int n) {
        if (n > 2) {
            return fibo(n - 2, 1, 1);
        }
        return 1;
    }

    int fibo(int n, int a1, int a2) {
        if (n == 0) {
            return a2;
        }
        a1 += a2;
        return fibo(--n, a2, a1);
    }

    //6
    public double math(double x, double a) {
        if (x >= 4) {
            return Math.log(2 * (x - 4)) + Math.exp(2 * a - x);
//            return Math.log(x - 4) / Math.log(2) + Math.exp(2 * a - x);
        }
        throw new IllegalArgumentException("X should be more or equals than 4");
    }

}

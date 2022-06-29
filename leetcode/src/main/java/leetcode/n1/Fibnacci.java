package leetcode.n1;

// 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987...
public class Fibnacci {
    public static void main(String[] args) {
        //System.out.println(fib1(60));
        System.out.println(fib2(3));
    }

    public static long fib1(long num) {
        if (num == 1 || num == 2) return 1;
        return fib1(num - 1) + fib1(num - 2);
    }

    public static long fib2(long num) {
        if (num == 1 || num == 2) return 1;
        long a = 1, b = 1;
        for (int i = 2; i <= num; i++) {
            long c = a + b;
            b = a;
            a = c;
        }
        return b;
    }
}

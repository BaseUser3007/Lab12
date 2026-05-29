package Timus;

import java.util.Scanner;

public class task_1295 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;

        int n = in.nextInt();

        long sum = (1 + PowMod(2, n, 100) + PowMod(3, n, 100) + PowMod(4, n, 100)) % 100;

        if (sum == 0) {
            System.out.println(2);
        } else if (sum % 10 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static long PowMod(long base, int exp, int mod) {
        long res = 1;
        base %= mod;
        for (int i = 0; i < exp; i++) {
            res = (res * base) % mod;
        }
        return res;
    }
}

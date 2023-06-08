package org.example.ans;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum = (sum + getFactorSum(i)) % 1000000007;
        }

        System.out.println(sum);
    }

    private static long getFactorSum(long num) {
        long sum = 0;
        for (long i = 1; i <= num; i++) {
            if (num % i == 0) {
                sum = (sum + i) % 1000000007;
            }
        }
        return sum;
    }
}

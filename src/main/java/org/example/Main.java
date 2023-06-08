package org.example;

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入逗号分隔的整数:");
//        String input = scanner.nextLine();
//        int[] arr = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
//        mergeSort(arr);
//        System.out.println("排序后的数组: " + Arrays.toString(arr));
//    }
//
//    public static void mergeSort(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return;
//        }
//        int[] sorted = Arrays.stream(arr).parallel().sorted().toArray();
//        System.arraycopy(sorted, 0, arr, 0, arr.length);
//    }
//}
//import java.util.Scanner;
//import java.util.stream.IntStream;
//
//public class Main {
//    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.print("请输入盘子数量: ");
//            int n = scanner.nextInt();
//            hanoi(n, "A", "B", "C").forEach(System.out::println);
//        }
//    }
//    public static IntStream hanoi(int n, String from, String mid, String to) {
//        return n == 1 ? IntStream.of(move(from, to, n)) : IntStream.concat(hanoi(n - 1, from, to, mid), IntStream.concat(IntStream.of(move(from, to, n)), hanoi(n - 1, mid, from, to)));
//    }
//    public static int move(String from, String to, int n) {
//        System.out.println("将盘子" + n + "从" + from + "移动到" + to);
//        return n;
//    }
//}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] x = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            x[i] = scanner.nextInt();
        }

        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int channel = scanner.nextInt();
            int value = scanner.nextInt();
            a.get(channel).add(value);
        }

        int[][] f = new int[m + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            f[0][i] = -1000000000;
        }

        for (int i = 1; i <= m; i++) {
            for (int kk = 1; kk <= k; kk++) {
                f[i][kk] = f[i - 1][kk];
            }

            Collections.sort(a.get(i), Collections.reverseOrder());
            int cnt = 1;
            int sum = 0;
            for (int j = 0; j < a.get(i).size(); j++) {
                sum += a.get(i).get(j);
                for (int kk = k; kk >= cnt; kk--) {
                    f[i][kk] = Math.max(f[i][kk], f[i - 1][kk - cnt] + sum - x[i]);
                }
                cnt++;
            }
        }

        System.out.println(f[m][k]);
    }
}


package org.example;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class G {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        long count = nQueens(n).count();
        System.out.println("解的个数: " + count);
    }

    public static Stream<int[]> nQueens(int n) {
        // 生成一个长度为n的整数数组，代表每行皇后的位置
        return IntStream.range(0, n)
                .boxed()
                .flatMap(i -> placeQueen(i, n - 1)
                        .map(solution -> prepend(solution, i)));
    }

    // 在当前行上尝试放置皇后，并返回所有可能的解决方案
    public static Stream<int[]> placeQueen(int row, int remaining) {
        if (remaining == 0) {
            // 如果没有剩余的皇后需要放置，那么这是一个解决方案
            return Stream.of(new int[]{});
        } else {
            // 尝试在当前行的每一列上放置皇后，并递归地调用placeQueen()来找到更多解决方案
            return IntStream.range(0, 8)
                    .filter(column -> isSafe(row, column))
                    .boxed()
                    .flatMap(column -> placeQueen(row + 1, remaining - 1)
                            .map(solution -> prepend(solution, column)));
        }
    }

    // 判断在row行和column列放置皇后是否安全
    public static boolean isSafe(int row, int column) {
        return IntStream.range(0, row)
                .noneMatch(i -> column == i || row - i == column - 1 - i || row - i == i - column - 1);
    }

    // 将value添加到array的开头
    public static int[] prepend(int[] array, int value) {
        int[] result = new int[array.length + 1];
        System.arraycopy(array, 0, result, 1, array.length);
        result[0] = value;
        return result;
    }
}

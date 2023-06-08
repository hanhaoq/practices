package org.example.NQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueens {

    public static int solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        solveNQueens(new int[n], 0, solutions);
        return solutions.size();
    }

    private static void solveNQueens(int[] queens, int row, List<List<String>> solutions) {
        int n = queens.length;
        if (row == n) {
            addSolution(queens, solutions);
        } else {
            IntStream.range(0, n)
                    .filter(col -> isValid(queens, row, col))
                    .forEach(col -> {
                        queens[row] = col;
                        solveNQueens(queens, row + 1, solutions);
                    });
        }
    }

    private static boolean isValid(int[] queens, int row, int col) {
        return IntStream.range(0, row)
                .noneMatch(i -> queens[i] == col || Math.abs(col - queens[i]) == row - i);
    }

    private static void addSolution(int[] queens, List<List<String>> solutions) {
        int n = queens.length;
        List<String> solution = IntStream.range(0, n)
                .mapToObj(i -> IntStream.range(0, n)
                        .mapToObj(j -> queens[i] == j ? "Q" : ".")
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
        solutions.add(solution);
    }

    public static void printSolution(List<List<String>> solutions) {
        IntStream.range(0, solutions.size())
                .forEach(i -> {
                    System.out.println("Solution " + (i + 1) + ":");
                    solutions.get(i).forEach(System.out::println);
                    System.out.println();
                });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 用户自定义输入N的大小
        scanner.close();
        List<List<String>> solutions = new ArrayList<>();
        int totalSolutions = solveNQueens(n);
        System.out.println("解的个数: " + totalSolutions);
        printSolution(solutions);
    }
}



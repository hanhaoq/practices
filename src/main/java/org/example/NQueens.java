package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueens {
    public static List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> solutions = new ArrayList<>();
        solveNQueens(n, new HashSet<>(), new HashSet<>(), new HashSet<>(), new ArrayList<>(), solutions);
        return solutions;
    }

    private static void solveNQueens(int n, Set<Integer> cols, Set<Integer> diags1, Set<Integer> diags2, List<Integer> solution, List<List<Integer>> solutions) {
        if (solution.size() == n) {
            solutions.add(new ArrayList<>(solution));
            return;
        }
        int row = solution.size();
        for (int col = 0; col < n; col++) {
            int diag1 = row - col;
            int diag2 = row + col;
            if (cols.contains(col) || diags1.contains(diag1) || diags2.contains(diag2)) {
                continue;
            }
            cols.add(col);
            diags1.add(diag1);
            diags2.add(diag2);
            solution.add(col);
            solveNQueens(n, cols, diags1, diags2, solution, solutions);
            solution.remove(solution.size() - 1);
            cols.remove(col);
            diags1.remove(diag1);
            diags2.remove(diag2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> solutions = solveNQueens(n);
        for (List<Integer> solution : solutions) {
            String board = IntStream.range(0, n).mapToObj(i -> {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[solution.get(i)] = 'Q';
                return new String(row);
            }).collect(Collectors.joining("\n"));
            System.out.println(board + "\n");
        }
    }
}

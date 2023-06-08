package org.example;

import java.util.*;

public class Ds {
    private int count = 0;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];
        backtrack(res, new ArrayList<String>(), cols, diagonal1, diagonal2, 0, n);

        return res;
    }

    private void backtrack(List<List<String>> res, List<String> board, boolean[] cols, boolean[] diagonal1, boolean[] diagonal2, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(board));
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int index1 = col - row + n - 1;
            int index2 = col + row;

            if (cols[col] || diagonal1[index1] || diagonal2[index2]) {
                continue;
            }

            char[] rowChars = new char[n];
            Arrays.fill(rowChars, '.');
            rowChars[col] = 'Q';
            String rowString = new String(rowChars);

            board.add(rowString);
            cols[col] = true;
            diagonal1[index1] = true;
            diagonal2[index2] = true;

            backtrack(res, board, cols, diagonal1, diagonal2, row + 1, n);

            board.remove(board.size() - 1);
            cols[col] = false;
            diagonal1[index1] = false;
            diagonal2[index2] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入N: ");
        int n = scanner.nextInt();

        Ds nQueens = new Ds();
        List<List<String>> res = nQueens.solveNQueens(n);
        for (List<String> board : res) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
        System.out.println("解的个数: " + nQueens.count);
    }
}

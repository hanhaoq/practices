package org.example.endterm;

public class TriangleMaxSum {
    public static void main(String[] args) {
        int[][] triangle = {
                {9},
                {12, 15},
                {10, 6, 8},
                {2, 18, 9, 5},
                {19, 7, 10, 4, 16}
        };

        int result = calculateMaxSum(triangle);
        System.out.println("最大路径和为：" + result);
    }

    private static int calculateMaxSum(int[][] triangle) {
        int n = triangle.length;
        int[][] maxSum = new int[n][n];

        // 初始化最底层的路径和为对应的节点值
        for (int j = 0; j < n; j++) {
            maxSum[n - 1][j] = triangle[n - 1][j];
        }

        // 递推计算每个节点的最大路径和
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                maxSum[i][j] = Math.max(maxSum[i + 1][j], maxSum[i + 1][j + 1]) + triangle[i][j];
            }
        }

        return maxSum[0][0];
    }
}


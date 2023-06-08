package org.example.多机调度;

import java.util.Arrays;

public class MultimachineScheduling {
    public static void main(String[] args) {
        int[] jobs = {3, 1, 4, 2, 5, 7, 6}; // 任务所需时间
        int k = 3; // 机器数量
        int[] machines = new int[k]; // 机器完成任务所需的时间

        Arrays.sort(jobs); // 将任务按所需时间从小到大排序

        for (int i = jobs.length - 1; i >= 0; i--) {
            int minIndex = findMinIndex(machines);
            machines[minIndex] += jobs[i]; // 将任务分配给完成时间最短的机器
        }

        int maxTime = machines[0];
        for (int i = 1; i < machines.length; i++) {
            if (machines[i] > maxTime) {
                maxTime = machines[i]; // 找出所有机器中完成任务最长的时间
            }
        }

        System.out.println("最少需要时间：" + maxTime);
    }

    // 找出机器中完成时间最短的索引
    private static int findMinIndex(int[] machines) {
        int minIndex = 0;
        for (int i = 1; i < machines.length; i++) {
            if (machines[i] < machines[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}


package org.example.多机调度;

import java.util.*;
import java.util.stream.IntStream;

public class Tes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入作业，以逗号分隔：");
        String[] jobs = scanner.nextLine().split(",");
        System.out.print("请输入机器个数：");
        int m = scanner.nextInt();
        int[] processingTimes = new int[jobs.length];

        // 输入各作业所需的处理时间
        IntStream.range(0, jobs.length).forEach(i -> {
            System.out.printf("请输入作业 %s 的处理时间：", jobs[i]);
            processingTimes[i] = scanner.nextInt();
        });

        // 贪心算法实现多机调度
        int[] machines = new int[m];
        Arrays.sort(processingTimes);

        for (int i = processingTimes.length - 1; i >= 0; i--) {
            int minIndex = getMinIndex(machines);
            machines[minIndex] += processingTimes[i];
        }

        // 输出加工时间
        int max = Integer.MIN_VALUE;
        for (int machine : machines) {
            if (machine > max) {
                max = machine;
            }
        }
        System.out.println("加工时间：" + max);
    }

    // 获取加工时间最短的机器的下标
    private static int getMinIndex(int[] machines) {
        int minIndex = 0;
        int min = machines[0];

        for (int i = 1; i < machines.length; i++) {
            if (machines[i] < min) {
                min = machines[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}

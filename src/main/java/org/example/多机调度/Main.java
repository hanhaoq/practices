package org.example.多机调度;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入作业，以逗号分隔：");
        String[] jobs = scanner.nextLine().split(",");
        System.out.print("请输入机器个数：");
        int m = scanner.nextInt();
        int[] processingTimes = new int[jobs.length];

        // 输入各作业所需的处理时间
        IntStream.range(0, jobs.length)
                .forEach(i -> {
                    System.out.printf("请输入作业 %s 的处理时间：", jobs[i]);
                    processingTimes[i] = scanner.nextInt();
                });

        // 贪心算法实现多机调度
        int[] machines = IntStream.generate(() -> 0).limit(m).toArray();
        Arrays.stream(processingTimes)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .forEach(time -> machines[getMinIndex(machines)] += time);

        // 输出加工时间
        int max = Arrays.stream(machines).max().orElse(0);
        System.out.println("加工时间：" + max);
    }

    // 获取加工时间最短的机器的下标
    private static int getMinIndex(int[] machines) {
        return IntStream.range(0, machines.length)
                .reduce((i, j) -> machines[i] < machines[j] ? i : j)
                .orElse(0);
    }
}

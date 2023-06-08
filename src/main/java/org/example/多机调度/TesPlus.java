//package org.example.多机调度;
//
//import java.util.*;
//import java.util.stream.*;
//
//public class TesPlus {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        // 用户自定义输入
//        System.out.print("请输入作业，以逗号分隔：");
//        String[] jobs = input.nextLine().split(",");
//        System.out.print("请输入机器个数：");
//        int m = input.nextInt();
//        int[] processingTimes = new int[jobs.length];
//
//        // 输入各作业所需的处理时间
//        for (int i = 0; i < jobs.length; i++) {
//            System.out.printf("请输入作业 %s 的处理时间：", jobs[i]);
//            processingTimes[i] = input.nextInt();
//        }
//
//        // 贪心算法实现多机调度
//        int max = Arrays.stream(processingTimes)
//                .boxed()
//                .sorted(Collections.reverseOrder())
//                .reduce(new int[m], (machines, time) -> {
//                    int minIndex = getMinIndex(machines);
//                    machines[minIndex] += time;
//                    return machines;
//                }, (machines1, machines2) -> {
//                    for (int i = 0; i < m; i++) {
//                        machines1[i] += machines2[i];
//                    }
//                    return machines1;
//                })
//                .stream()
//                .max(Comparator.naturalOrder())
//                .orElse(Integer.MIN_VALUE);
//
//        // 输出加工时间
//        System.out.println("加工时间：" + max);
//    }
//
//    // 获取加工时间最短的机器的下标
//    private static int getMinIndex(int[] machines) {
//        return IntStream.range(0, machines.length)
//                .reduce((i, j) -> machines[i] <= machines[j] ? i : j)
//                .orElse(0);
//    }
//}

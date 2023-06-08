package org.example.Java_Tes_2023_6_8;

public class ProgressBarExample {
    public static void main(String[] args) {
        int totalProgress = 10;

        for (int i = 1; i <= totalProgress; i++) {
            System.out.print("Progress: " + i + "/" + totalProgress);
            System.out.print("\r"); // 回车符，使后续输出覆盖当前行

            // 模拟一些耗时操作
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Progress complete!");
    }
}

package org.example.Java_Tes_2023_6_8;

public class FloatOrDouble {
    public static void main(String[] args) {
        double p1 = 3.1415926535;
        float p2 = 3.1415926535f;
        System.out.println(p1 + "\n" + p2);
        double num1 = 2.7;
        double num2 = 8.1 / 3;//计算机默认为8.10000000
        System.out.println(num1 == num2);
        System.out.println(num1);
        System.out.println(num2);
        if (Math.abs(num1 - num2) < 0.000001) {
            System.out.println("他们两个是相等的");

        } else {
            System.out.println("不相等 ");
        }



    }
}

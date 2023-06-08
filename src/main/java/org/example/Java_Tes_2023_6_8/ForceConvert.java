package org.example.Java_Tes_2023_6_8;

public class ForceConvert {
    public static void main(String[] args) {
        // char int long float double
        // byte short int long float double
        int i = (int)1.9;//精度丢失
        byte b = (byte) 2000;//数据溢出
        System.out.println(i + "\n" +b);

    }
}

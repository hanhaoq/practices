package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("原始数据：" + numbers);
        System.out.println("只保留偶数：" + evenNumbers);
    }
}

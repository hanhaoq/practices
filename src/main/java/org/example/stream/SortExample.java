package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 1, 4, 2, 3);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("原始数据：" + numbers);
        System.out.println("排序后的数据：" + sortedNumbers);
    }
}

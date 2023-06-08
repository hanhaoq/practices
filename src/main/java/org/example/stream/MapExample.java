package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("原始数据：" + names);
        System.out.println("转换后的数据：" + upperCaseNames);
    }
}

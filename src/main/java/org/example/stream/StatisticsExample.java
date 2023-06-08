package org.example.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsExample {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(new Person("Alice", 20),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("David", 25),
                new Person("Eva", 30));

        IntSummaryStatistics ageStats = persons.stream()
                .collect(Collectors.summarizingInt(Person::getAge));

        System.out.println("年龄统计结果：");
        System.out.println("总人数：" + ageStats.getCount());
        System.out.println("最小年龄：" + ageStats.getMin());
        System.out.println("最大年龄：" + ageStats.getMax());
        System.out.println("平均年龄：" + ageStats.getAverage());
        System.out.println("年");
    }
}
package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(new Person("Alice", 20),
                new Person("Bob", 30),
                new Person("Charlie", 20),
                new Person("David", 25),
                new Person("Eva", 25));

        Map<Integer, List<Person>> groupedPersons = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println("按照年龄分组后的结果：");
        groupedPersons.forEach((age, group) -> System.out.println("年龄为 " + age + " 的人员有：" + group));
    }
}
    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


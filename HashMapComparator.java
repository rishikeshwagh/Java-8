package com.java.programs;

import lombok.Builder;
import lombok.Getter;

import java.util.*;

public class HashMapComparator {
    public static void main(String[] args) {
        HashMap<Long, Employee> employeeHashMap = new HashMap<>();
        employeeHashMap.put(1L, Employee.builder().name("A").age(19).salary(1000.0).build());
        employeeHashMap.put(2L, Employee.builder().name("B").age(20).salary(700.0).build());
        employeeHashMap.put(3L, Employee.builder().name("C").age(19).salary(500.0).build());
        List<Map.Entry<Long, Employee>> entryList = new ArrayList<>(employeeHashMap.entrySet());
        Comparator<Map.Entry<Long, Employee>> compareByAge = Comparator.comparing(p -> p.getValue().getAge());
        Comparator<Map.Entry<Long, Employee>> compareByName = Comparator.comparing(p -> p.getValue().getName());
        Comparator<Map.Entry<Long, Employee>> compareByFullName = compareByAge.thenComparing(compareByName);
        Collections.sort(entryList, compareByFullName);
        entryList.forEach(p -> System.out.println(p.getValue().getName()));
    }
}

@Getter
@Builder
class Employee {
    String name;
    int age;
    double salary;
}

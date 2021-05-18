package com.java.programs;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapOperations {
    public static void main(String args[]) {
        int[] score = {10, 20, 100, 30, 50, 90};
        int N = score.length;
        int K = 3;
        HashMap<Integer, Integer> scoreHashMap = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            scoreHashMap.put(score[i], i);
        }

        List<Integer> result = scoreHashMap.keySet()
                                            .stream()
                                            .sorted(Comparator.reverseOrder())
                                            .limit(K).sequential()
                                            .map(p -> scoreHashMap.get(p))
                                            .collect(Collectors.toList());

        result.stream().sequential().forEach(p -> System.out.println(p));


    }
}

package com.BrovkoD.tasks;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Task4 {

    public int numOfPairsWithForLoop(ArrayList<Integer> arrayList, int target) {

        System.out.println("~~~ Task #4. For loop\nInput:\narrayList: " + arrayList + "\ntarget: " + target);

        int numOfPairs = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i) + arrayList.get(j) == target) {
                    numOfPairs++;
                }
            }
        }

        return numOfPairs;
    }

    public int numOfPairsWithStream(ArrayList<Integer> arrayList, int target) {

        System.out.println("~~~ Task #4. Stream\nInput:\narrayList: " + arrayList + "\ntarget: " + target);

        return IntStream.range(0, arrayList.size())
                .map(x -> (int) IntStream.range(x + 1, arrayList.size())
                                .filter(y -> arrayList.get(x) + arrayList.get(y) == target)
                                .count())
                .sum();
    }
}

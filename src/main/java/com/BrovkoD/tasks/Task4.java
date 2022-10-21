package com.BrovkoD.tasks;

import java.util.ArrayList;

public class Task4 {

    public int numOfPairsWithForLoop(ArrayList<Integer> arrayList, int target) {

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
}

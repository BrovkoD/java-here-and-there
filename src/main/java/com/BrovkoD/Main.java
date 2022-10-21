package com.BrovkoD;

import com.BrovkoD.tasks.Task1;
import com.BrovkoD.tasks.Task2;
import com.BrovkoD.tasks.Task3;
import com.BrovkoD.tasks.Task4;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Output: " + new Task1().getIntegersFromList(Arrays.asList("a", "b", 1, 2, -4, "123")) + "\n");

        System.out.println("Output: " + new Task2().firstNonRepeatingLetter("sTreSS") + "\n");

        System.out.println("Output: " + new Task3().digitalRoot(255) + "\n");

        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1, 3, 6, 2, 2, 0, 4, 5);
        System.out.println("Output: " + new Task4().numOfPairsWithForLoop(arrayList, 5));
    }
}

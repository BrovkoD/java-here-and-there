package com.BrovkoD;

import com.BrovkoD.tasks.*;
import com.BrovkoD.tasks.extra.ExtraTask1;
import com.BrovkoD.tasks.extra.ExtraTask2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Output: " + new Task1().getIntegersFromList(Arrays.asList("a", "b", 1, 2, -4, "123")) + "\n");

        System.out.println("Output: " + new Task2().firstNonRepeatingLetter("sTreSS") + "\n");

        System.out.println("Output: " + new Task3().digitalRoot(255) + "\n");

        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1, 3, 6, 2, 2, 0, 4, 5);
        System.out.println("Output: " + new Task4().numOfPairsWithForLoop(arrayList, 5) + "\n");
        System.out.println("Output: " + new Task4().numOfPairsWithStream(arrayList, 5) + "\n");

        System.out.println("Output: " + new Task5().sortNames("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill") + "\n");

        System.out.println("Output: " + new ExtraTask1().getBiggerNumByRearrangingDigits(531) + "\n");

        System.out.println("Output: " + new ExtraTask2().getIPv4AddressFrom32BitNumber(2149583361L) + "\n");
    }
}

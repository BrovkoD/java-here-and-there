package com.BrovkoD.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

public class Task5 {

    public String sortNames(String names) {

        System.out.println("~~~ Task #5\nInput: " + names);

        List<String> fullNames = new ArrayList<>(List.of(names.toUpperCase().split(";")));
        List<List<String>> nameSurnamePairs = new ArrayList<>();
        for (String fullName : fullNames) {
            List<String> pair = new ArrayList<>(List.of(fullName.split(":")));
            Collections.reverse(pair);
            nameSurnamePairs.add(pair);
        }
        List<List<String>> sortedNames = nameSurnamePairs.stream()
                .sorted((x, y) -> {
                    if (x.get(0).compareTo(y.get(0)) != 0) {
                        return x.get(0).compareTo(y.get(0));
                    } else {
                        return x.get(1).compareTo(y.get(1));
                    }
                }).toList();

        StringBuilder namesSortedString = new StringBuilder();
        for (List<String> name : sortedNames) {
            namesSortedString.append(format("(%s, %s)", name.get(0), name.get(1)));
        }

        return namesSortedString.toString();
    }
}

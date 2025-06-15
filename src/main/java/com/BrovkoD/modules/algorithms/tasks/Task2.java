package com.BrovkoD.tasks;

import java.util.HashMap;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

public class Task2 {

    public Character firstNonRepeatingLetter(String word) {

        System.out.println("~~~ Task #2\nInput: " + word);

        char[] chars = word.toCharArray();

        HashMap<Character, Integer> countChars = new HashMap<>();
        for (char c : chars) {
            countChars.put(c, countChars.getOrDefault(c, 0) + 1);
        }

        for (char c : chars) {
            if (checkChar(c, countChars)) {
                return c;
            }
        }

        return null;
    }

    private boolean checkChar(char c, HashMap<Character, Integer> countChars) {

        Integer lowercase = countChars.getOrDefault(toLowerCase(c), 0);
        Integer uppercase = countChars.getOrDefault(toUpperCase(c), 0);

        boolean firstCondition = lowercase.equals(1) && uppercase.equals(0);
        boolean secondCondition = lowercase.equals(0) && uppercase.equals(1);

        return firstCondition ^ secondCondition;
    }
}

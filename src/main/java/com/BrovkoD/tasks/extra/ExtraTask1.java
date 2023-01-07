package com.BrovkoD.tasks.extra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExtraTask1 {

    public int getBiggerNumByRearrangingDigits(Integer number) {

        System.out.println("~~~ Extra task #1\nInput: " + number);

        List<Integer> digits = new ArrayList<>(String.valueOf(number).chars()
                        .map(Character::getNumericValue)
                        .boxed()
                        .sorted()
                        .toList()
        );

        String maxNum = "";
        while (digits.size() > 0) {
            maxNum += digits.get(digits.size() - 1);
            digits.remove(digits.size() - 1);
        }

        int result = Integer.parseInt(maxNum);

        return result == number ? -1 : result;
    }
}

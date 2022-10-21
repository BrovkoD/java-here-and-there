package com.BrovkoD.tasks;

import java.util.List;

public class Task1 {

    public List<Object> getIntegersFromList(List<Object> list) {

        System.out.println("~~~ Task #1\nInput: " + list);

        return list.stream().filter(o -> o instanceof Integer).toList();
    }
}

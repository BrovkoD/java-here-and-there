package com.BrovkoD.tasks.extra;

public class ExtraTask2 {

    public String getIPv4AddressFrom32BitNumber (long number) {

        System.out.println("~~~ Extra task #2\nInput: " + number);

        return (number >> 24 & 255) + "." +
                (number >> 16 & 255) + "." +
                (number >> 8 & 255) + "." +
                (number & 255);
    }
}

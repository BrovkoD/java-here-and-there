package com.BrovkoD.tasks;

public class Task3 {

    public Integer digitalRoot(int num) {

//        There is better solution, but you wanted to see recursive method, right? :)

        System.out.println("~~~ Task #3\nInput: " + num);

        int ans = 0;

        while (num > 0) {
            int temp = num % 10;
            ans += temp;
            num /= 10;
        }

        if (ans >= 10) {
            ans = digitalRoot(ans);
        }

        return ans;
    }
}

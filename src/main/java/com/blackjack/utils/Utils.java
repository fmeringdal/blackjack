package com.blackjack.utils;

import java.util.Random;

public class Utils {
    public static void shuffle(String[] arr) {
        int index;
        String tmp;

        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }
    }

}

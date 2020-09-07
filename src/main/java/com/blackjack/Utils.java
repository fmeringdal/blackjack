package com.blackjack;

import java.util.Random;

public class Utils {
    public static void shuffle(String[] arr) {
        int index;
        String temp;
        
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

}

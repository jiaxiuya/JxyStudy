package com.jxy.algorithm;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = new int[]{
                31, 41, 59, 26, 41, 58
        };

        for (int i = 1; i < a.length; i++) {

            int j = 0;
            int index = a[i];
            while (j < i) {
                if (a[j] < index) {
                    j++;
                    continue;
                }
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}

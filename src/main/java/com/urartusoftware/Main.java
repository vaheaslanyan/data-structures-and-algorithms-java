package com.urartusoftware;


import com.urartusoftware.algorithms.QuickSort;

import java.util.Arrays;

public class Main {

    static QuickSort qs = new QuickSort();
    static int[] arr = {1, 2, 5, 0, 7, 4, 2};
    public static void main(String[] args) {

        System.out.println(Arrays.toString(arr));
        qs.quickSort(arr);
    }
}
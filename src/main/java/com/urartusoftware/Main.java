package com.urartusoftware;

import com.urartusoftware.algorithms.MergeSort;
import java.util.Arrays;

public class Main {

    static int[] arr = {1, 2, 5, 0, 7, 4, 2};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));

        int[] sortedArr = MergeSort.mergeSort(arr);

        System.out.println(Arrays.toString(sortedArr));
    }
}
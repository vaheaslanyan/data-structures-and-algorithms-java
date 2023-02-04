package com.urartusoftware.algorithms;

// A basic sort
// Bubbling the largest item in an array to the top one iteration at a time
// In-place sort
// Space complexity O(1) and big O of O(n^2)
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}

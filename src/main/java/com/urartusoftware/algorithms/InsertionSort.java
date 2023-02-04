package com.urartusoftware.algorithms;

// A basic sort
// Always starts at second item and compares with an item before.
// If the item needs to be moved it will do so until it is correctly places it
// O(n^2) and Θ(n)
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int compValueInd = i - 1;
            while (compValueInd >= 0 && temp < arr[compValueInd]) {
                arr[compValueInd+1] = arr[compValueInd];
                arr[compValueInd] = temp;
                compValueInd--;
            }
        }
    }
}

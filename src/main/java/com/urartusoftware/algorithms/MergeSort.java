package com.urartusoftware.algorithms;

import java.util.Arrays;

// Returns the sorted array
// Divide and conquer. Very efficient, as efficient as possible.
// Uses recursion to divide in half at each recursion until we have single-item arrays
// which are by definition sorted. Then it will combine layer at a time them into sorted arrays
// until the whole initial array is completely sorted
// Space complexity of O(n)
// Time complexity of O(log n)
public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int midInd = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midInd)); // up to, but not including, midInd
        int[] right = mergeSort(Arrays.copyOfRange(arr, midInd, arr.length));

        return merge(left, right);
    }

    // Helper method to merge two sorted halves of a divided array
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] combinedArray = new int[arr1.length + arr2.length];
        int combArrInd = 0;
        int arr1Ind = 0;
        int arr2Ind = 0;

        // While both arrays have values compare values between both arrays and add the smaller one to combined array
        while (arr1Ind < arr1.length && arr2Ind < arr2.length) {
            if (arr1[arr1Ind] < arr2[arr2Ind]) {
                combinedArray[combArrInd] = arr1[arr1Ind];
                arr1Ind++;
            } else {
                combinedArray[combArrInd] = arr2[arr2Ind];
                arr2Ind++;
            }
            combArrInd++;
        }

        while (arr1Ind < arr1.length) {
            combinedArray[combArrInd] = arr1[arr1Ind];
            arr1Ind++;
            combArrInd++;
        }

        while (arr2Ind < arr2.length) {
            combinedArray[combArrInd] = arr2[arr2Ind];
            arr2Ind++;
            combArrInd++;
        }

        return combinedArray;
    }
}

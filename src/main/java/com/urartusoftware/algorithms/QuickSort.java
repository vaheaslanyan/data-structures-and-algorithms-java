package com.urartusoftware.algorithms;

import java.util.Arrays;

// In-place algorithm
// Uses pivot point to compare every item in the array to that item,
// if an item is lower than the pivot item we exchange it with the first item that is greater and so on.
// Once we iterated through the array we then move the item at pivot point to the end of newly moved smaller items.
// At this point, the item that was at pivot point is no sorted and in correct spot.
// Next, we run the quick sort on the left portion and right portion (from where we moved the item that was a pivot before,
// which should now be in the middle) of the array. Once that is done we should have a sorted array.

// Space complexity O(1)
// Time complexity Ω(n log n) and O(n^2) in case of already sorted or almost sorted array. Thus, for cases like that use Insertion sort
public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int arr[], int left, int right) {

        if (left < right) {
            // do initial sort and get new pivot index
            int newPivotIndex =  performSortAndReturnNewPivotIndex(arr, left, right);

            // run on sections left and right to pivot
            quickSort(arr, left, newPivotIndex - 1);
            quickSort(arr, newPivotIndex + 1, right);
        }

//        return;
    }


    // Returns the index of item that was the pivot when running the method, which when returned should be in middle of the section that was sorted
    private static int performSortAndReturnNewPivotIndex(int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }

        // Moving item at pivot to end of lower items
        swap(arr, pivotIndex, swapIndex);
        return swapIndex;
    }

    private static void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
}

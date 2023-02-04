package com.urartusoftware;

import com.urartusoftware.algorithms.BubbleSort;
import com.urartusoftware.algorithms.InsertionSort;
import com.urartusoftware.algorithms.SelectionSort;
import com.urartusoftware.datastructures.BinarySearchTree;
import com.urartusoftware.datastructures.Graph;
import com.urartusoftware.datastructures.HashTable;

import java.util.Arrays;

public class Main {

    static int[] arr = {1, 2, 5, 0, 7, 4, 2};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));

        InsertionSort.insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
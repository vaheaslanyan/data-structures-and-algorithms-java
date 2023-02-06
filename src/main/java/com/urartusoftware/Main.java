package com.urartusoftware;


import com.urartusoftware.algorithms.QuickSort;
import com.urartusoftware.algorithms.TreeTraversal;
import com.urartusoftware.datastructures.BinarySearchTree;

import java.util.Arrays;
import java.util.List;

public class Main {

    static BinarySearchTree bst = new BinarySearchTree();

    public static void main(String[] args) {

        bst.rInsert(78);
        bst.rInsert(12);
        bst.rInsert(5);
        bst.rInsert(18);
        bst.rInsert(19);
        bst.rInsert(9);

        List theList = TreeTraversal.DFSPreOrder(bst);

        System.out.println(theList.toString());
    }
}
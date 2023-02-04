package com.urartusoftware;

import com.urartusoftware.datastructures.BinarySearchTree;
import com.urartusoftware.datastructures.Graph;
import com.urartusoftware.datastructures.HashTable;

public class Main {

    static BinarySearchTree bst = new BinarySearchTree();
    public static void main(String[] args) {

        bst.rInsert(72);
        bst.rInsert(12);
        bst.rInsert(13);
        bst.rInsert(5);
        bst.rInsert(82);

        bst.rDeleteNode(5);

        System.out.println(bst.rContains(5));

    }
}
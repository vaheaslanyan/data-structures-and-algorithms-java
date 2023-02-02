package com.urartusoftware;

import com.urartusoftware.datastructures.BinarySearchTree;

public class Main {

    static BinarySearchTree bst = new BinarySearchTree(17);
    public static void main(String[] args) {
        bst.insert(78);
        bst.insert(12);
        bst.insert(5);
        bst.insert(18);

        System.out.println(bst.contains(12));
    }
}
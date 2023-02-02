package com.urartusoftware;

import com.urartusoftware.datastructures.BinarySearchTree;
import com.urartusoftware.datastructures.HashTable;

public class Main {

    static HashTable ht = new HashTable();
    public static void main(String[] args) {
        ht.printTable();

        ht.set("nails", 100);
        ht.set("tile", 50);
        ht.set("lumber", 10);
        ht.set("porcelain", 65);
        ht.printTable();

        System.out.println(ht.getKeys());
    }
}
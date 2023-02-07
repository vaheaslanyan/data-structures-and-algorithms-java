package com.urartusoftware;


import com.urartusoftware.algorithms.QuickSort;
import com.urartusoftware.algorithms.TreeTraversal;
import com.urartusoftware.datastructures.BinarySearchTree;
import com.urartusoftware.datastructures.DoublyLinkedList;

import java.util.Arrays;
import java.util.List;

public class Main {

    static DoublyLinkedList dll = new DoublyLinkedList(1);

    public static void main(String[] args) {

        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.append(6);
        dll.prepend(0);

        dll.insert(2, 9);

        dll.printList();
        dll.getLength();
    }
}
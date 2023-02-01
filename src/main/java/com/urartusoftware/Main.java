package com.urartusoftware;

import com.urartusoftware.datastructures.SinglyLinkedList;

public class Main {

    static SinglyLinkedList singlyLinkedList = new SinglyLinkedList(4);
    public static void main(String[] args) {
        singlyLinkedList.append(2);
        singlyLinkedList.append(7);
        singlyLinkedList.append(1);
        singlyLinkedList.printList();
        singlyLinkedList.getLength();

        singlyLinkedList.removeLast();
        singlyLinkedList.printList();
        singlyLinkedList.getLength();

        singlyLinkedList.prepend(9);
        singlyLinkedList.printList();
        singlyLinkedList.getLength();

        System.out.println(singlyLinkedList.get(1));

        singlyLinkedList.set(2, 8);
        singlyLinkedList.printList();

        singlyLinkedList.insert(2, 6);
        singlyLinkedList.printList();

        singlyLinkedList.remove(4);
        singlyLinkedList.printList();

        singlyLinkedList.reverse();
        singlyLinkedList.printList();
    }
}
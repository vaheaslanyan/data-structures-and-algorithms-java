package com.urartusoftware;

import com.urartusoftware.datastructures.Queue;
import com.urartusoftware.datastructures.SinglyLinkedList;
import com.urartusoftware.datastructures.Stack;

public class Main {

    static Queue myQueue = new Queue(7);
    public static void main(String[] args) {
        myQueue.printQueue();

        myQueue.enqueue(1);
        myQueue.enqueue(3);
        myQueue.printQueue();

        myQueue.dequeue();
        myQueue.printQueue();
    }
}
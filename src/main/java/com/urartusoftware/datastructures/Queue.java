package com.urartusoftware.datastructures;

// FIFO
// Can be implemented using ArrayList or LinkedList
// When using LinkedList make sure to enqueue on tail(last) and dequeue on head(first) to keep O(1)
// In our case queue is going last -> first
public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length < 1) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if (length < 1) {
            return null;
        } else {
            Node temp = first;
            if (length == 1) {
                first = null;
                last = null;
            } else {
                first = first.next;
                temp.next = null;
            }
            length--;
            return temp;
        }
    }

    public void getFirst() {
        System.out.println("First: " + first.value);
    }

    public void getLast() {
        System.out.println("Last: " + last.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void printQueue() {
        Node temp = first;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null) {
                System.out.print("<-");
            }
            temp = temp.next;
        }
    }

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
}

package com.urartusoftware.datastructures;

// LIFO
// Can be implemented using ArrayList or LinkedList
// When using LinkedList make sure to do add/remove operations at the head(top) to ensure O(1) for both operations
public class Stack {
    private Node top;
    private int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    // Adds a node to top of stack
    public void push(int value) {
        Node newNode = new Node(value);
        if (height < 1) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    // Removes node from top and returns it
    public Node pop() {
        if (height < 1) {
            return null;
        }

        Node temp = top;
        top = temp.next;
        height--;
        return temp;
    }

    public void getTop() {
        System.out.println("\nTop: " + top.value);
    }

    public void getHeight() {
        System.out.println("\nHeight: " + height);
    }

    public void printStack() {
        Node temp = top;
        System.out.print("Stack: ");
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

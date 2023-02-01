package com.urartusoftware.datastructures;

// For singly-linked list
// O(1) if adding to front or end
// O(n) if removing item at the end
// O(1) if removing from front
// O(n) if inserting or removing node at/from a location
public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node get(int index) {
        if (length < 1) {
            return null;
        }

        if (index < 0 || index >= length) {
            System.out.println("Index not in range");
            return null;
        }

        int currentIndex = 0;
        Node temp = head;

        while (currentIndex <= index) {
            if (currentIndex == index) {
                return temp;
            }

            temp = temp.next;
            currentIndex++;
        }
        return null;
    }

    public boolean set(int index, int value) {
        // Leveraging our get method
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            System.out.println("Index out of bounds");
            return false;
        };

        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node temp = get(index - 1);
            Node newNode = new Node(value);

            newNode.next = temp.next;
            temp.next = newNode;
            length++;
            return true;
        }

        return false;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;

        if (length < 1) {
            tail = newNode;
        }

        length++;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Index out of bounds");
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node temp = get(index - 1);
        Node removingNode = temp.next;
        temp.next = removingNode.next;

        length--;
        return removingNode;
    }

    public Node removeFirst() {
        if (length < 0) {
            return null;
        }

        Node firstNode = head;
        head = head.next;
        length--;

        return firstNode;
    }

    public Node removeLast() {

        if (length < 1) {
            return null;
        }

        Node lastNode = null;
        if (length > 0) {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }

            lastNode = temp.next;
            temp.next = null;
            tail = temp;
        }

        length--;
        return lastNode;
    }

    public boolean reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        int currentIndex = 0;
        while (currentIndex < length && after != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

        return true;
    }

    public void printList() {
        Node temp = head;
        System.out.print("\nLinkedList: ");

        while(temp != null) {
            System.out.print(temp.value);
            // Add arrow if not last node
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("\nHead: " + head.value);
    }

    public void getTail() {
        System.out.println("\nTail: " + tail.value);
    }

    public void getLength() {
        System.out.println("\nLength: " + length);
    }

    // Inner(nested) class for Node
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}


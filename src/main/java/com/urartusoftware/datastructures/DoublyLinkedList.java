package com.urartusoftware.datastructures;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length < 1) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length < 1) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length < 1) {
            return null;
        }

        Node nodeToBeRemoved = this.tail;
        if (length == 1) {
            this.tail = null;
            this.head = null;
        } else {
            this.tail = tail.prev;
            tail.next = null;
            nodeToBeRemoved.prev = null;
        }

        length--;
        return nodeToBeRemoved;
    }

    public Node removeFirst() {
        if (length < 1) {
            return null;
        }
        Node nodeToBeRemoved = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = nodeToBeRemoved.next;
            nodeToBeRemoved.next = null;
            head.prev = null;
        }
        length--;
        return  nodeToBeRemoved;
    }

    public Node get(int index) {
        if (index < 0 || index > length - 1) {
            return null;
        }
        Node temp;
        if (index < length / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node nodeToChange = get(index);
        if (nodeToChange != null) {
            nodeToChange.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }

        Node newNode = new Node(value);
        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node before = get(index - 1);
            Node after = before.next;
            before.next = newNode;
            newNode.prev = before;
            newNode.next = after;
            after.prev = newNode;
            length++;
        }
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        }

        Node nodeToBeRemoved = get(index);
        Node before = nodeToBeRemoved.prev;
        Node after = nodeToBeRemoved.next;
        before.next = after;
        after.prev = before;
        nodeToBeRemoved.prev = null;
        nodeToBeRemoved.next = null;

        length--;
        return nodeToBeRemoved;
    }

    public void getHead() {
        System.out.println(this.head.value);
    }

    public void getTail() {
        System.out.println(this.tail.value);
    }

    public void getLength() {
        System.out.println(this.length);
    }

    public void printList() {
        DoublyLinkedList.Node temp = head;
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

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }
}

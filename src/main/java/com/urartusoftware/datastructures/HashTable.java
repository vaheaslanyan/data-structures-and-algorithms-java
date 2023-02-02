package com.urartusoftware.datastructures;

// Hash Table is implemented with an array (address space) that stores key-value pairs
// Hash method runs on the key and returns an address (ASCII text numerical value) which corresponds to an index in the array.
// Hash method one way: you can run a key and get an address, but you cannot do the reverse
// Hash method is deterministic. If you run the same key you will get the same address

// There are a few ways to deal with collisions (when there is already an object at an address)
// Separate chaining - add the item to the same address along with the existing item. This can be achieved by using linked lists at addresses.
// Linear Probing (type of Open Addressing) - if address is take keep going to next spot until open and place there
// In this example we are using Separate chaining

// Θ(1) and O(n)

import java.util.ArrayList;
import java.util.List;

// It is good practice to have a prime number of indexes in our address array
public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    public List getKeys() {
        List<String> allKeysList = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeysList.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeysList;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }

        return 0;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("  " + temp.toString());
                temp = temp.next;
            }
        }
    }

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            // the char will be converted to corresponding int ASCII
            int asciiValue = keyChars[i];
            // The remainder of division by 7 is conveniently 0-6 which fits our addresses array indexes
            hash = (hash + asciiValue * 23) % dataMap.length; // 23 because prime to get more random result.
        }
        return hash;
    }
}

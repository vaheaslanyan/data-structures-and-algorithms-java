package com.urartusoftware.datastructures;

// A full tree is one where all nodes have all available pointers point to other Nodes
// A complete tree is one where it is filled with no gaps from left to right. Does not have to go all the way
// A perfect tree is one where all used levels are completely filled
// A node can only have one parent. Parent nodes can have multiple child nodes
// A node with no children is called a leaf

// A Binary Search Tree is sorted ascending with lower values starting on the left-hand side
// When adding, sort goes from top to bottom, layer by layer adding smaller values to the left and larger values to the right
// Taken any node, all child nodes on the left will be less than that node and all the ones on the right will be greater than
// Most operations in Binary Search Trees are Θ(log n) due to divide and conquer structure, however the big O is O(n)
public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int value) {
        Node newNode = new Node(value);
        root = newNode;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                } else {
                    temp = temp.left;
                }
            }

            if (newNode.value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value == temp.value) {
                return true;
            }

            if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    public class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }
}

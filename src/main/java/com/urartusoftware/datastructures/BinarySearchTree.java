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

    // Recursive approach
    public void rInsert(int value) {
        if (root == null) {
            root = new Node(value);
        }
        rInsert(root, value);
    }
    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value){
            currentNode.right = rInsert(currentNode.right, value);
        }

        return currentNode;
    }

    // Iterative approach
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

    // Recursive
    public void rDeleteNode(int value) {
        rDeleteNode(root, value);
    }
    private Node rDeleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (value < currentNode.value) {
            currentNode.left = rDeleteNode(currentNode.left, value);
        } else if(value > currentNode.value) {
            currentNode.right = rDeleteNode(currentNode.right, value);
        } else {
            // If leaf node
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.right != null) {
                // If an item to right exists we set it as current node. Because the previous node now has nothing
                // pointing to it will get garbage collected
                currentNode = currentNode.right;
            } else if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else {
                // If Node has two branches we find the min value in the subtree that starts at current node
                // and replace current node value with subtree min value on the right thus also keeping the left
                // branch of it less than the updated node value
                int subTreeMin = subtreeMinValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = rDeleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    private int subtreeMinValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    // Recursive approach
    public boolean rContains(int value) {
        return rContains(this.root, value);
    }
    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.value == value) {
            return true;
        }

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    // Iterative approach
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

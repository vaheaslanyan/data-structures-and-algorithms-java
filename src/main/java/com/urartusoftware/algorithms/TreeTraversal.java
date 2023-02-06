package com.urartusoftware.algorithms;

// Visit every node in a tree, put the values in an ArrayList and return that
// Breadth First Search (level by level) and Depth First Search (branch by branch) can be used.

// BFS - we go row by row and add numbers to ArrayList.
// Uses iteration
// We have two variables: queue and a results ArrayList.
// Row by row we will first add nodes to the queue from left to right and after all the nodes in the row are added we will
// dequeue them and add the values to the results list and add their children to the queue
// The results ArrayList ends up in a pattern of a tree

// DFS - there are three types of Depth First Search algorithms: PreOrder
// PreOrder - starting at the top and keep moving to the left childs and adding values to results list and once all the way at the bottom then
// we will move right branch by branch going from top to bottom. Uses recursion.
// PostOrder - same principal, except we go all the way to the bottom and then start adding values to the results list
// once the recursive functions return. Just a different order of adding values to the list. It will still go left to right
// but bottom up instead of top to bottom as far as adding the values to results list.
// InOrder - similar, except every node will go left, then write its own value, then go right. This results in all
// the values ending up in a numerical order due to the way tree is constructed, e.g. left < Node < right

// Can put inside BinarySearchTree class instead

import com.urartusoftware.datastructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    // Breadth First Search - uses iteration
    public static ArrayList<Integer> BFS(BinarySearchTree bst) {
        BinarySearchTree.Node currentNode = bst.getRoot();

        // We will be adding nodes row by row to the queue
        Queue<BinarySearchTree.Node> queue = new LinkedList<>();

        // After adding all Nodes in the row to the queue we will deque them and add the values to the list
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }

        return results;
    }

    // PreOrder Depth First Search - uses recursion
    public static ArrayList<Integer> DFSPreOrder(BinarySearchTree bst) {
        ArrayList<Integer> results = new ArrayList<>();

        // We can put a method inside a method in Java by creating a nested class
        class Traverse {
            Traverse(BinarySearchTree.Node currentNode) {
                results.add(currentNode.getValue());
                // Because left comes first and this is called recursively, it ends up going branch by branch from left to right
                if (currentNode.getLeft() != null) {
                    new Traverse(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    new Traverse(currentNode.getRight());
                }
            }
        }

        // We have to use the new keyword as this is a constructor
        new Traverse(bst.getRoot());
        return results;
    }

    // PostOrder Depth First Search - uses recursion
    public static ArrayList<Integer> DFSPostOrder(BinarySearchTree bst) {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(BinarySearchTree.Node currentNode) {
                if (currentNode.getLeft() != null) {
                    new Traverse(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    new Traverse(currentNode.getRight());
                }
                results.add(currentNode.getValue());
            }
        }

        new Traverse(bst.getRoot());
        return results;
    }


    public static ArrayList<Integer> DFSInOrder(BinarySearchTree bst) {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(BinarySearchTree.Node currentNode) {
                if (currentNode.getLeft() != null) {
                    new Traverse(currentNode.getLeft());
                }
                results.add(currentNode.getValue());
                if (currentNode.getRight() != null) {
                    new Traverse(currentNode.getRight());
                }
            }
        }

        new Traverse(bst.getRoot());
        return results;
    }

}

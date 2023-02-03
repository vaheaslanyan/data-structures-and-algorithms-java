package com.urartusoftware;

import com.urartusoftware.datastructures.BinarySearchTree;
import com.urartusoftware.datastructures.Graph;
import com.urartusoftware.datastructures.HashTable;

public class Main {

    static Graph g = new Graph();
    public static void main(String[] args) {
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.printGraph();

        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("A", "C");
        g.printGraph();

        g.removeVertex("O");
        g.printGraph();
    }
}
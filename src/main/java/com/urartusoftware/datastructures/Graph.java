package com.urartusoftware.datastructures;

// Vertex (Node)
// Edge (Connection) can be weighted or non-weighted. Think of traffic between two navigation route options
// There is no limit how many edges a vertex has with other vertices
// Edges can be directional or bidirectional
// Trees are a form of graph with some limitations while linked lists are form of trees with further limitations

// Graphs can be represented via Adjacency Matrix and Adjacency List
// Adjacency Matrix is essentially a two-dimensional array with the actual Vertex on one axis and items that it has edge with on the other axis
// On that matrix 1 (or value of edge if it is weighted) represents connection and 0 represents absence of connection.
// Adjacency List uses a HashMap with key of the Vertex and value of an array with all items it has an edge with

// Adjacency List has better space complexity due to not having to store the 0 for edges a Vertex doesn't have edge with
// Adjacency List is has better time complexity of O(1) for adding a Vertex you simply add a new entry into hashmap
// as opposed to having to add an array and resize all the existing arrays in case of Adjacency Matrix
// Both AL and AM are O(1) for adding an edge
// AM is better for removing an edge with O(1)
// AL is typically better due to inefficiencies of having to store all values for absent edges, especially for larger applications

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        ArrayList<String> v1edges = adjList.get(vertex1);
        ArrayList<String> v2edges = adjList.get(vertex2);
        if (v1edges != null && v2edges != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        ArrayList<String> vertexEdges = adjList.get(vertex);
        if (vertexEdges != null) {
            for (String s : vertexEdges) {
                adjList.get(s).remove(vertex);
            }
            adjList.remove(vertex);
        }
        return false;
    }
    public boolean removeEdge(String vertex1, String vertex2) {
        ArrayList<String> v1edges = adjList.get(vertex1);
        ArrayList<String> v2edges = adjList.get(vertex2);
        if (v1edges != null && v2edges != null) {
            v1edges.remove(vertex2);
            v2edges.remove(vertex1);
            return true;
        }
        return false;
    }
}

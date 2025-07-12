package Graphs;

import java.util.*;

public class Graph {
    HashMap<String, ArrayList<String>> adjlist = new HashMap<>();
    public boolean addVertex(String vertex){
        if(adjlist.get(vertex) == null){
            adjlist.put(vertex,new ArrayList<>());
            return true;
        }
        return false;
    }
    public boolean addEdge(String vertex1, String vertex2){
        if(adjlist.get(vertex1) != null && adjlist.get(vertex2)!=null){
            adjlist.get(vertex1).add(vertex2);
            adjlist.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }
    public boolean removeEdge(String vertex1, String vertex2){
        if(adjlist.get(vertex1) != null && adjlist.get(vertex2)!=null){
            adjlist.get(vertex1).remove(vertex2);
            adjlist.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }
    public boolean removeVertex(String vertex){
        if(adjlist.get(vertex) == null) return false;
        for(String otherVertex: adjlist.get(vertex)){
            adjlist.get(otherVertex).remove(vertex);
        }
        adjlist.remove(vertex);
        return true;
    }
    public void printGraph() {
        for (String vertex : adjlist.keySet()) {
            System.out.println(vertex + " -> " + adjlist.get(vertex));
        }
    }
    public static void main(String[] args){
        Graph g = new Graph();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.printGraph();

        g.removeEdge("A", "B");
        g.printGraph();

        g.removeVertex("B");
        g.printGraph();
    }
}
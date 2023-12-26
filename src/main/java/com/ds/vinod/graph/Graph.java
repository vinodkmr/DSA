package com.ds.vinod.graph;

import java.util.LinkedList;

public class Graph {
    int noOfvertex;
    int noOfEdges;
    LinkedList<Integer>[] adjacents;


    //Creating the linked list array and assigning each with new linked list
    // as it will be null by default
    Graph(int noOfvertex){
        this.noOfvertex = noOfvertex;
        adjacents = new LinkedList[noOfvertex];
        for(int i=0; i<adjacents.length; i++){
            adjacents[i] = new LinkedList<>();
        }
    }


    public void addEdge(int vertex, int edge){
        adjacents[vertex].add(edge);
        adjacents[edge].add(vertex);
        noOfEdges++;
    }

    public Iterable<Integer> getAdjacents(int vertex){
        return adjacents[vertex];
    }

    public void dfs(int staringVertex){
        boolean[] isMarked = new boolean[noOfvertex];
        dfs(staringVertex,isMarked);

    }

    private void dfs(int vertex, boolean[] isMarked) {
        System.out.println("vertex "+vertex);
        isMarked[vertex] = true;
        for (Integer element : getAdjacents(vertex)){
            if(!isMarked[element]){
                dfs(element, isMarked);
            }
        }
    }
}

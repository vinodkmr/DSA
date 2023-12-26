package com.ds.vinod.graph;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,5);
        graph.addEdge(0,6);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,6);
        graph.addEdge(4,5);



        Iterable<Integer> adjacents = graph.getAdjacents(0);
        System.out.println("Adjacent vertex of 0");
        for (Integer ele : adjacents){
            System.out.println(ele);
        }

        System.out.println("DFS");
        graph.dfs(0);
    }
}

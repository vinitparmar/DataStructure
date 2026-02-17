package graph.java.UndirectedGraoh.BFS;

import java.util.LinkedList;

public class ShortestPath {
    
    static int V;
    static LinkedList<Integer>[] adj;

    ShortestPath(int V){
        this.V = V;
        adj = new LinkedList[V];

        for(int i = 0 ; i < V ; i++){
            adj[i] =  new LinkedList<>();
        }
    }
 
    static void addEdge(int v , int w){
        adj[v].add(w);
        adj[w].add(v);
    }


    public static void main(String[] args) {
        
    }
}

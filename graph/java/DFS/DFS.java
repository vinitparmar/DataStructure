package graph.java.DFS;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    static int V;
    static LinkedList<Integer> adj[];

    DFS(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0 ; i < V ; i++){
            adj[i] = new LinkedList<>();
        }
    }

    static void addEdge(int v , int w){
        adj[v].add(w);
    }

    static void dfs(int v){


        boolean[] visited = new boolean[V];

        dfsUtil(v, visited);


    }

    static void dfsUtil(int v , boolean[] visited){

        visited[v] = true;

        System.out.print(v+" ");

        Iterator<Integer> i = adj[v].iterator();

        while(i.hasNext()){
            int n = i.next();

            if(!visited[n]){
                dfsUtil(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS d =  new DFS(4);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        dfs(2);
    }
    
}

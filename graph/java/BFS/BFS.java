package graph.java.BFS;

import java.util.Iterator;
import java.util.LinkedList;

import graph.java.DFS.DFS;

public class BFS {

    static int V;
    static LinkedList<Integer> adj[];

    BFS(int V){
        this.V = V;
        adj = new LinkedList[V];

        for(int i = 0 ; i < V ; i++){
            adj[i] =  new LinkedList<>();
        }
    }

    static void addEdge(int v , int w){
        adj[v].add(w);
    }

    static void bfs(int s){

        boolean[] visited = new boolean[V];

        LinkedList<Integer> q =  new LinkedList<>();

        visited[s] = true;

        q.add(s);

        while (!q.isEmpty()) {
            int n = q.poll();

            System.out.print(n+" ");

            Iterator<Integer> i = adj[n].iterator();

            while (i.hasNext()) {
                int t = i.next();
                if(!visited[t]){
                    visited[t] = true;
                    q.add(t);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS d =  new BFS(4);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        bfs(2);
    }
}

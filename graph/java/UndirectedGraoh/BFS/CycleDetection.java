package graph.java.UndirectedGraoh.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {
    

    static int V;
    static LinkedList<Integer>[] adj;

    CycleDetection(int V){
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


    static boolean detectCycle(boolean[] visited , int s){

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();

        parent[s] = -1;

        visited[s] = true;

        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            for(int v : adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                }else if(parent[u] != v){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean hasCycle(){

        boolean[] visited =  new boolean[V];

        for(int i = 0 ; i < V ; i++ ){
            if(!visited[i]){
                return detectCycle(visited, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

       CycleDetection c = new CycleDetection(5);
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 3);

        System.out.println(hasCycle());
        
    }
}

package graph.java.UndirectedGraoh.DFS;

import java.util.LinkedList;

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


    static boolean hasCycle(){
        boolean[] visited = new boolean[V];
          for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                 if (dfs(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false; 
    }

    static boolean dfs(int u , boolean[] visited , int parent){

         visited[u] = true;

         for(int v : adj[u]){
            if(!visited[v]){
                if(dfs(v, visited, u)){
                    return true;
                }
            }
             else if (v != parent) {
                return true;
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

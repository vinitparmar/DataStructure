package graph.GraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteDFS {

    static boolean isBipartite(List<List<Integer>> adj , int V){

        int[] color = new int[V];

        Arrays.fill(color , -1);

        for(int start = 0 ; start < V ; start++){

            if(color[start] == -1){

                if(!dfs(adj, color, start, 0)){
                    return false;
                }
            }
        }
        
        return true; 
    }

    static boolean dfs(List<List<Integer>> adj , int[] color , int node , int c){

        color[node] = c;

        for(int neighbor : adj.get(node)){
            if(color[neighbor] == -1){
              if(!dfs(adj , color , neighbor , 1-c)){
                return false;
              }   
            } else if(color[neighbor] == color[node]){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
         int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

        System.out.println(isBipartite(adj, V)); // true

    
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) adj2.add(new ArrayList<>());
        addEdge(adj2, 0, 1);
        addEdge(adj2, 1, 2);
        addEdge(adj2, 2, 0);

        System.out.println(isBipartite(adj2, 3)); // false

    }

    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

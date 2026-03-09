package graph.GraphSeries;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutes {

    static int minReorder(int n , int[][] connections){

        List<List<int[]>> graph =  new ArrayList<>();

        for(int i = 0; i < n ; i++ ){
                graph.add(new ArrayList<>());
        }

        for(int[] conn : connections){
            int u = conn[0];
            int v = conn[1];

            graph.get(u).add(new int[]{v , 1});

            graph.get(v).add(new int[]{u , 0});

        }

        boolean[] visited =  new boolean[n];

        return dfs(graph, visited , 0);
    }
    

    static int dfs( List<List<int[]>> graph , boolean[] visited , int src){

        visited[src] = true;
        int count = 0;

        for(int[] neigh : graph.get(src)){

            int next = neigh[0];
            int weight = neigh[1];



            if(!visited[next]){
                count += weight + dfs(graph, visited, next);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
        ReorderRoutes solution = new ReorderRoutes();

        int n = 6;
        int[][] connections = {
                {0,1},
                {1,3},
                {2,3},
                {4,0},
                {4,5}
        };

        System.out.println(minReorder(n, connections));
    }
}

package graph.GraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUG {
 
    
    static int[] getShortestPath(int V , int[][] edges , int src){

        //create adj list
        List<List<Integer>> adj =  new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        //initilaize dist array
        int[] dist = new int[V];
        Arrays.fill(dist,-1);
        dist[src] = 0;

        //bfs

        Queue<Integer> queue =  new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor : adj.get(node)){
                if(dist[neighbor] == -1){
                    dist[neighbor] = dist[node]+1;
                    queue.add(neighbor);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
           int n = 8;
        int[][] edges = {{0,1}, {1,2}, {0,3}, {3,4}, {4,7}, {3,7}, {6,7}, {4,5}, {4,6}, {5,6}};
        int src = 0;
        
        int[] distances = getShortestPath(n, edges, src);
        System.out.println("Distances from source 0: " + Arrays.toString(distances));
    }
}

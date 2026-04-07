package graph.GraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {
    
    static class Edge{

        int to;
        int weight ;

        Edge(int to , int weight){
            this.to = to;
            this.weight = weight;
        }
    }

     static void addEdge(List<List<Edge>> adj, int u, int v, int w) {
        adj.get(u).add(new Edge(v, w));
    }

    static void topoSort(int node , List<List<Edge>> adj , boolean[] visited , Stack<Integer> stack){
        visited[node] = true;

        for(Edge edge : adj.get(node)){
            if(!visited[edge.to]){
                topoSort(edge.to, adj, visited, stack);
            }
        }
        stack.push(node);
    }

    static int[] shortestPath(List<List<Edge>> adj , int V , int src){

        boolean[] visited =  new boolean[V];
        Stack<Integer> stack = new Stack<>();
    
        for (int i = 0; i < V ; i++) {
            if(!visited[i]){
                topoSort(i, adj, visited, stack);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        while(!stack.isEmpty()){
            int node = stack.pop();

            if(dist[node] != Integer.MAX_VALUE){
                for(Edge edge : adj.get(node)){
                    int newDist = dist[node] + edge.weight;
                    if(newDist < dist[edge.to]){
                        dist[edge.to] = newDist;
                    }
                }
            }
        }
            return dist;
    } 

    public static void main(String[] args) {
         int V = 6;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 2, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 6);
        addEdge(adj, 2, 3, 1);
        addEdge(adj, 2, 4, 2);
        addEdge(adj, 3, 4, 1);
        addEdge(adj, 3, 5, 2);
        addEdge(adj, 4, 5, 3);

        int[] dist = shortestPath(adj, V, 0);

        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < V; i++) {
            System.out.println("  To " + i + " : " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
        // Output: 0, 2, 5, 6, 7, 8

    }
}

package graph.GraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int n ;
    int dist;

    Node(int n ,  int dist){
        this.n = n;
        this.dist = dist;    
    }
}



public class DjistraPQ {

static void addEdge(List<List<int[]>> adj, int u, int v, int w) {
    adj.get(u).add(new int[]{v, w});
    adj.get(v).add(new int[]{u, w}); // remove this line for directed graph
}

    static int[]  getShortestPath(int V , List<List<int[]>> adj , int s){

    int[]  dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[s] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.dist -b.dist));
    pq.offer(new Node(s, 0));

    while(!pq.isEmpty()){
        Node curr = pq.poll();
        int u = curr.n;
        int d = curr.dist;

        if(d > dist[u]){
            continue;
        }

        for(int[] neigh : adj.get(u)){
            int v = neigh[0];
            int w = neigh[1];

            if(dist[v] > dist[u]+w){
                dist[v] = dist[u]+w;
                pq.offer(new Node(v, dist[v]));
            }
        }
    }
    return dist;
}

    public static void main(String[] args) {
        int V = 5;

    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

    addEdge(adj, 0, 1, 2);
    addEdge(adj, 0, 3, 6);
    addEdge(adj, 1, 2, 3);
    addEdge(adj, 1, 3, 8);
    addEdge(adj, 1, 4, 5);
    addEdge(adj, 2, 4, 7);
    addEdge(adj, 3, 4, 9);

    int source = 0;
    int[] distances = getShortestPath(V, adj, source);

    System.out.println("Shortest distances from node " + source + ":");
    for (int i = 0; i < V; i++) {
        System.out.println("  Node " + i + " -> " +
            (distances[i] == Integer.MAX_VALUE ? "Unreachable" : distances[i]));
    }
    }
    
}

package graph.java.BFS;

import java.util.LinkedList;
import java.util.Queue;

import graph.java.DFS.TopologicalSort;

public class KahnsAlgoTopologicalSort {
     /**
     * 
     * can be applied on Directed Acyclic(non cyclic) Graph (DAG) 
     * 
     */
    static int V;
    static LinkedList<Integer>[] adj;

    KahnsAlgoTopologicalSort(int V) {
        this.V = V;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    static void addEdge(int u, int v) {
        adj[u].add(v); // directed edge u -> v
    }

    static void topologicalSort(){

        int[] inDegree =  new int[V];

        //count indegree
        for(int i=0 ; i < V ; i++){
            for(int n : adj[i]){
                inDegree[n]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        //add nodes with indegree 0
        for(int i = 0 ; i < V ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;

    while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");
            count++;
        

        for(int n : adj[u]){
            inDegree[n]--;
            if(inDegree[n] == 0){
                q.add(n);
            }
        }
    }

        // Cycle detection
        if (count != V) {
            System.out.println("\nCycle detected! Topological sort not possible.");
        }
    }

    public static void main(String[] args) {
        KahnsAlgoTopologicalSort g = new KahnsAlgoTopologicalSort(6);

        addEdge(5, 2);
        addEdge(5, 0);
        addEdge(4, 0);
        addEdge(4, 1);
        addEdge(2, 3);
        addEdge(3, 1);

        topologicalSort();
    }
    
}

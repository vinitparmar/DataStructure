package graph.java.DFS;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    /**
     * 
     * can be applied on Directed Acyclic(non cyclic) Graph (DAG) 
     * 
     */

     static int V;
    static LinkedList<Integer>[] adj;

    TopologicalSort(int V) {
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
        boolean[] visited =  new boolean[V];
        Stack<Integer> stack =  new Stack<>();

        for(int i = 0 ; i < V ; i++){
            if(!visited[i]){
                dfs(i, visited, stack);
            }
        }

         while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void dfs(int v , boolean[] visited , Stack<Integer> stack){
        visited[v] = true;

        for(int n : adj[v]){
            if(!visited[n]){
                dfs(n, visited,stack);
            }
        }

        stack.push(v);
    }


    public static void main(String[] args) {
         TopologicalSort g = new TopologicalSort(6);

        addEdge(5, 2);
        addEdge(5, 0);
        addEdge(4, 0);
        addEdge(4, 1);
        addEdge(2, 3);
        addEdge(3, 1);

        topologicalSort();

    }
    
}

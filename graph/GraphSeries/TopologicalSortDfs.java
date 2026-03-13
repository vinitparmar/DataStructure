package graph.GraphSeries;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDfs {

    static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph){

        visited[node] = true;

        for(int neighbor :graph.get(node)){
             if(!visited[neighbor]){
                dfs(neighbor, visited, stack, graph);
            }
        }

        stack.push(node);
    }

    static List<Integer> topoSort(int V, List<List<Integer>> graph){

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();


         for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, visited, stack, graph);
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }
    

    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);


        System.out.println(topoSort(V, graph));

    }
}

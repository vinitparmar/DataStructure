package graph.GraphSeries;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionUGDfs {


    static boolean dfs(int node , int parent , boolean[] visited , List<List<Integer>> graph){

        visited[node] = true;
        for(int neighbor : graph.get(node)){

            if(!visited[neighbor]){
                if(dfs(neighbor, node, visited, graph)){
                        return true;
                }
            }else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }

    static boolean isCycle(int V , List<List<Integer>>graph){

        boolean[] visited =  new boolean[V];

        for(int i ; i < V ; i++){

            if(!visited[i]){
                if(){
                    return true;
                }
            } 
        }
        return false;
    }
    

    public static void main(String[] args) {
         int V = 5;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // edges
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(4).add(1);
        graph.get(1).add(4);

        System.out.println(isCycle(V, graph));
    }
}

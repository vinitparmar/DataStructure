package graph.GraphSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortKahnAlgoBfs {
    
    static List<Integer> topoSort(int V, List<List<Integer>> graph) {

       int[] inDegree = new int[V];
       
       for(int i = 0; i < V ; i++){
        for(int neighbor : graph.get(i)){
            inDegree[neighbor]++;
        }
       }

       Queue<Integer> queue =  new LinkedList();

       for(int i = 0; i < V ; i++){
        if(inDegree[i] == 0){
            queue.add(i);
        }
       }

       List<Integer> res = new ArrayList<>();

       while(!queue.isEmpty()){
        int node = queue.poll();
        res.add(node);

        for(int neighbor : graph.get(node)){
            inDegree[neighbor]--;
             if(inDegree[neighbor] == 0){
                    queue.add(neighbor);
                }
        }
       }
       return res;
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

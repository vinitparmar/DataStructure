package graph.GraphSeries;

import java.util.HashMap;
import java.util.Map;

public class LongestCycle {

    public static int longestCycle(int[] edges){

        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] timeVisited = new int[n];
        int longestCycle = -1;
        int time = 1;

        for(int i = 0 ; i < n ; i++){

            if(visited[i]){
                continue;
            }

            int node = i;
            Map<Integer , Integer> map =  new HashMap<>();
            while(node != -1 && !visited[node]){
                visited[node] = true;
                map.put(node, time);
                timeVisited[node] = time++;
                node = edges[node];

                if(node != -1 && map.containsKey(node)){
                    longestCycle = Math.max(longestCycle , time - map.get(node));
                    break;
                }
            }
        }
        
        return longestCycle;
    }
    
    public static void main(String[] args) {

        int[] edges = {3, 3, 4, 2, 3};

        System.out.println(longestCycle(edges));

    }
}

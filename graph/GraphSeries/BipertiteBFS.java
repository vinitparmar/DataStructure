package graph.GraphSeries;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipertiteBFS {
    
    static boolean isBipartite(int[][] graph){

        int totalNodes = graph.length;
        int[] color = new int[totalNodes];
        Arrays.fill(color , -1);

        for(int startNode = 0 ; startNode < totalNodes ; startNode++){

            if(color[startNode] != -1){
                continue;
            }

            Queue<Integer> q =  new LinkedList<>();
            q.add(startNode);
            color[startNode] = 0;

            while(!q.isEmpty()){
                int currNode = q.poll();
                int oppositeColor = (color[currNode] == 0) ? 1 : 0;

                for(int neighbor : graph[currNode]){

                    if(color[neighbor] == -1){

                         color[neighbor] = oppositeColor;
                         q.add(neighbor);
                    }else if(color[neighbor] == color[currNode]){
                        return false;
                    }
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
           int[][] square = {
            {1, 3},   
            {0, 2},   
            {1, 3},  
            {0, 2}    
        };
        System.out.println("Square graph: " + isBipartite(square));  

       
        int[][] triangle = {
            {1, 2},   
            {0, 2},   
            {0, 1}   
        };
        System.out.println("Triangle graph: " + isBipartite(triangle)); 
    }
}

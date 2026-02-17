package graph.GraphSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExist {

    static int V;
    static ArrayList<Integer> arr[];

    public FindIfPathExist(int V){
        this.V = V;
        arr =  new ArrayList[V];
        for(int i = 0; i < V ; i++){
            arr[i] = new ArrayList<>();
        }
    }
    

    static void addEdge(int u, int v){
        arr[u].add(v);
        arr[v].add(u);
    }

    static boolean ifPathExist(int s , int d){
        boolean[] visited = new boolean[V];
        visited[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int n = q.poll();

            for (int c : arr[n]) {
                
                if(c == d){
                    return true;
                }

                if(!visited[c]){
                    visited[c] = true;
                    q.add(c);
                }
            }


        }
        return false;
    }

    public static void main(String[] args) {
          FindIfPathExist g = new FindIfPathExist(5);

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(3, 4);

        System.out.println(ifPathExist(0, 2)); 
        System.out.println(ifPathExist(0, 4)); 
    }
}

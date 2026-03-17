package graph.GraphSeries;

public class NumberOfProvince {

     static int findCircleNum(int[][] isConnected){
            
        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

            for(int i = 0; i < n ; i++){

                if(!visited[i]){
                    dfs(i, isConnected, visited);
                    provinces++;

                }
            }

        return provinces;
    }

    static void dfs(int i , int[][] isConnected , boolean[] visited){

        visited[i] = true;

        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {

                if (isConnected[i][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, isConnected, visited);
            }
        }

    }

    public static void main(String[] args) {
        
        int[][] isConnected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        System.out.println(findCircleNum(isConnected));

    }
}

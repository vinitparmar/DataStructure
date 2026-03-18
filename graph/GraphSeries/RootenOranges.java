package graph.GraphSeries;

import java.util.LinkedList;
import java.util.Queue;

public class RootenOranges {

    static class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col , int time){
            this.time = time;
            this.row = row;
            this.col = col;   
        }
    }

    static int rottenOranges(int[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue =  new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j,0));
                }

                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.time;

            time = Math.max(time, t);

            for(int  i = 0 ; i < 4 ; i++){
               int nr = r + dr[i];
               int nc = c + dc[i];
               
               if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    fresh--;
                    queue.add(new Pair(nr, nc, t + 1));
               }
                
            }

        }

        if (fresh > 0) return -1;

        return time;

    }
    

    public static void main(String[] args) {
        

        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(rottenOranges(grid));
    }
    
}

package graph.GraphSeries;

import java.util.LinkedList;
import java.util.Queue;

public class KnightProblem {

    static class Cell {
        int x;
        int y ;
        int dist;

         Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    

    static int minMoves(int N , int startX , int startY ,  int destX , int destY){

        if(startX == destX && startY == destX){

            return 0;
        }

         int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
         int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

         boolean[][] visited = new boolean[N][N];

         Queue<Cell> q = new LinkedList<>();
         q.add(new Cell(startX,startY,0));
         visited[startX][startY] = true;
            while(!q.isEmpty()){
                Cell curr = q.poll();

                for(int i = 0 ; i < dx.length ; i++){
                    int newX = startX + dx[i];
                    int newY = startY + dy[i];

                    if(isValid(N ,newX , newY) && !visited[newX][newY]){
                        if(newX == destX && newY == destY){
                            return curr.dist+1;
                        }

                        q.add(new Cell(newX, newY, curr.dist+1));
                        visited[newX][newY] = true;
                    }
                }
            }

            return -1;
    }


    static boolean isValid(int N , int x , int y){
        return x>=0 && y>=0 && x<N && y<N;
    }

    public static void main(String[] args) {
         int N = 8;
        int result = minMoves(N, 0, 0, 7, 7);

        System.out.println("Minimum moves: " + result);
    }
}

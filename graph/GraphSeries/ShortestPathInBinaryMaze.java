package graph.GraphSeries;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMaze {

    static int BFS(int[][] mat , Point src , Point dest){

        if (mat[src.x][src.y] == 0 || mat[dest.x][dest.y] == 0) {
            return -1;
        }

        if (src.x == dest.x && src.y == dest.y) {
            return 0;
        }

        int row = mat.length;
        int col = mat[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Dist> q = new LinkedList<>();

        q.add(new Dist(src, 0));
        visited[src.x][src.y] = true;

        while (!q.isEmpty()) {
            Dist node = q.poll();
            Point p = node.point;
            int d = node.d;

            if (p.x == dest.x && p.y == dest.y) {
                return d;
            }

            // Direction vectors: Up, Down, Left, Right
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                // Check boundary, if it's a path (1), and not visited
                if (isValid(nx, ny, row, col) && mat[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Dist(new Point(nx, ny), d + 1));
                }
            }
        }
        return -1; // Destination unreachable
    }
    

     static boolean isValid(int x, int y, int r, int c) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };

        System.out.println(BFS(mat, new Point(0, 0), new Point(3, 4)));
        
    }
}


class Point {
    int x;
    int y;
    int d;

    Point(int x , int y){
        this.x = x;
        this.y = y;
    }
}

class Dist{
    Point point;
    int d;

    Dist(Point point , int d){
        this.point = point;
        this.d = d;
    }
}
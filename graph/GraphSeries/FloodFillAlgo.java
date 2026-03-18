package graph.GraphSeries;

public class FloodFillAlgo {
    

    static void dfs(int[][] image , int i , int j, int oldColor , int newColor){

        int m = image.length;
        int n = image[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || image[i][j] != oldColor){
            return;
        }

        image[i][j] = newColor;

        dfs(image, i+1, j, oldColor, newColor);
        dfs(image, i-1, j, oldColor, newColor);
        dfs(image, i, j+1, oldColor, newColor);
        dfs(image, i, j-1, oldColor, newColor);
    }

    static int[][] floodFill(int[][] image , int i , int j , int color){

        int oldColor = image[i][j];

        if(oldColor == color){
            return image;
        }

        dfs(image,i,j,oldColor,color);

        return image;

    }

    public static void main(String[] args) {
       
        
          int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int sr = 1, sc = 1, newColor = 2;

          int[][] result = floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }
}

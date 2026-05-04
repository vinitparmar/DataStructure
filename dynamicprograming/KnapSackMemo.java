package dynamicprograming;

import java.util.Arrays;

public class KnapSackMemo {
    
    static int[][] t ;

    static int memo(int[] wt , int[] val , int W , int n){

        if(n == 0 || W == 0){
            return 0;
        }

        if(t[n][W] != -1){
            return t[n][W];
        }


        if(wt[n-1] <= W){
            return t[n][W] = Math.max(val[n-1]+memo(wt, val, W-wt[n-1], n-1), memo(wt, val, W, n-1));
        }

        return t[n][W] = memo(wt, val, W , n-1);
    }

    public static void main(String[] args) {
      

        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;

        t = new int[n + 1][W + 1];
        for (int[] row : t) {
                Arrays.fill(row, -1);
            }
        
        System.out.println("Maximum value (Memoization): " + memo(wt, val, W, n));

    }
}

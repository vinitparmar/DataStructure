package array.java.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterevals {
    
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][];
        }
        //iterate by start
        Arrays.sort(intervals , (a,b) -> a[0] - b[0] );

        List<int[]> res = new ArrayList<>();

        int[] curr = intervals[0];

        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] <= curr[1]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }else{
                res.add(curr);
                curr = intervals[i];
            }
        }

        res.add(curr);

        return res.toArray(new int[res.size()][]);

    }
    public static void main(String[] args) {
        int[][] in = {{1,3},{2,6},{8,10},{15,18}};
        int[][] out =  merge(in);

        for(int[] a : out){
            System.out.print(Arrays.toString(a));
        }
    }
}

/*
 * Complexity: 
 * Time : O(n log n) + O(n) 
 * Space: O(n)
 */
package array.java.Intervals;

import java.util.Arrays;

public class MaxNonOverLappingInterval { 

    static int maxNonOverlapIntervals(int[][] intervals){
        
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        // sort by end time
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);

        int count  = 0;
        int lastEnd = Integer.MIN_VALUE;
        
        for(int[] in : intervals){

            if(in[0] >= lastEnd){
                count++;
                lastEnd = in[1];
            }
        }

        return count;
    }
   
    
    public static void main(String[] args) {
        int[][] input = {{1,2},{2,3},{3,4},{1,3}};

        System.out.println(maxNonOverlapIntervals(input));
    }
}

/*
 * Complexity
 * Time : O(nlogn) + O(n)
 * Space : O(1)
 */

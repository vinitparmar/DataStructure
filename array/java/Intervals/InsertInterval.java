package array.java.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
 

    public static int[][] merge(int[][] intervals , int[] newInterval){

        int i = 0;
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        
        //add iuntervals 
        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        // merge overlapping with newInterval
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        while(i < n){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);

    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        int[][] output =  merge(intervals, newInterval);

        for(int[] a : output){
            System.out.println(Arrays.toString(a));
        }
    }
}

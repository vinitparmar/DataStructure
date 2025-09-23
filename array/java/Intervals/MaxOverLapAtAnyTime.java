package array.java.Intervals;

import java.util.ArrayList;
import java.util.List;

public class MaxOverLapAtAnyTime {

    static int maxOverlap(int[][] intervals){

        List<int[]> events = new ArrayList<>();

        for(int[] input : intervals){
            events.add(new int[]{input[0] , 1});
            events.add(new int[]{input[1] , -1});
        }
        events.sort((a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]); 

        int cur = 0, best = 0;
        for (int[] e : events) {
            cur += e[1];
            best = Math.max(best, cur);
        }
        return best;
    }

    public static void main(String[] args) {
        int[][] in = {{1,4},{2,5},{7,9},{3,6}};
        System.out.println(maxOverlap(in));
    }
    
}


/*
 * Complexity
 * Time : O(nlogn) + 2n
 * Space : O(n)
 */
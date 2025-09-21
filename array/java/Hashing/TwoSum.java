package array.java.Hashing;

import java.util.*;

import org.xml.sax.HandlerBase;

public class TwoSum {

    static int[] findIndices(int[] arr , int sum){
        Map<Integer, Integer> map = new HashMap<>(); 

        for(int i = 0 ; i < arr.length ; i++){

             int rem = sum - arr[i];

             if(map.containsKey(rem)){
                return new int[] {
                    map.get(rem) , i
                };
             }

             map.put(arr[i], i);
        }

        return new int[] {-1 , -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(findIndices(arr, 9)));
    }
}

/*
 * Time : O(n)
 * Space : O(n)
 */
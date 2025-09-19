package array.java.PrefixSufixTechnique;

/*
 * solution for the maximum subarray sum
 */

public class KadanesAlgo {
    
    static int kadene(int[] arr){

        if (arr == null || arr.length == 0) {
            return 0; 
        }

        int currSum = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i < arr.length ; i++){
            currSum  = Math.max(arr[i], currSum+arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(kadene(arr));
    }
}

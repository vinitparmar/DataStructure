package array.java.FixedWindow;

public class SlidingWindowOrTwoPointer {
    /*
     * use this approach when asked for subarrays, pairs, sums, windows.
     * 
     */



     /*
      * Two-Pointer Problem
      * Sort array of 0s, 1s, and 2s (Dutch National Flag problem)
      * Input: [0, 2, 1, 2, 0, 1]
      * Output: [0, 0, 1, 1, 2, 2]
      */
    
     static void dutchNationalFlag(int[] arr){
        int startPtr = 0;
        int endPtr = arr.length-1;
        int mid = 0;

        while (mid <= endPtr) {
            if(arr[mid] == 0){
                swap(arr, mid, startPtr);
                startPtr++;
                mid++;
            } else if(arr[mid] == 1){
                mid++;
            }else { //(arr[mid] == 2)
                swap(arr, mid, endPtr);
                endPtr--;
            }
        }

        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
     }

     static void swap(int[] arr , int i , int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
     }
     

     /*
      * Sliding Window Problems
      */

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0, 1};
        dutchNationalFlag(arr);
    }
}

package recursion.java;

import java.util.Arrays;

public class SelectionSort {

    static void sort(int[] arr , int r , int c , int maxIndex){

        if(r==0){
            return;
        }

        if(c < r){
           if(arr[c] > arr[maxIndex]){
            sort(arr, r, c+1, c);
           }else{
             sort(arr, r, c+1, maxIndex);
           }
        }else{
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[r-1];
            arr[r-1] = temp;
            sort(arr, r-1, 0, 0);
        }

    }
    
    public static void main(String[] args) {
        int[] arr = {1,5,3,2};

        sort(arr, arr.length, 0, 0);

        System.out.println(Arrays.toString(arr));
    }
}

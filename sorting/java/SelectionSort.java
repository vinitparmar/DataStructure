package sorting.java;

public class SelectionSort {

    static int[] sort(int[] arr){

        int startIndex = 0;

        while(startIndex < arr.length){

            for(int end = startIndex+1 ; end < arr.length ; end++ ){
                if(arr[startIndex] > arr[end]){
                    swap(arr, startIndex, end);
                }
            }
        startIndex++;
        }

        return arr;
    }

    static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
         int[] arr = {5, 3, 1, 2, 4};
        arr = sort(arr);
        System.out.print("Sorted: ");
        for (int v : arr) {
            System.out.print(v + " ");
        }
    }
    
}


/**
 * SelectionSort Algorithm
 *
 * Time Complexity:
 *  - Best: O(n^2)
 *  - Average: O(n^2)
 *  - Worst: O(n^2)
 *
 * Space Complexity: O(1) (in-place)
 */
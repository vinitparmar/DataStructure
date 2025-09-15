package sorting.java;

public class BubbleSort {

    static int[] sort(int[] arr){

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length-1 ; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
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


// Time Complexity

// Best Case: O(n) → when the array is already sorted (only 1 pass, no swaps).

// Average Case: O(n²) → nested loops with random order.

// Worst Case: O(n²) → when the array is in reverse order.

// Space Complexity

// Auxiliary Space: O(1) → sorting is done in-place, no extra array.
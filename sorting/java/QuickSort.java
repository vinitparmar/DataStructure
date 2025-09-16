package sorting.java;

public class QuickSort {

    static void sort(int[] arr , int start , int end){
        if(start < end){
            int pivot = partition(arr , start , end);

            sort(arr, start, pivot-1);
            sort(arr, pivot+1, end);
        }
    }


    static int partition(int[] arr , int start, int end){

        int pivot = arr[end];
        int index = start - 1;

        for(int j = start ; j < end ; j++){
            if(arr[j] <= pivot){
                index++;
                int temp = arr[index];
                arr[index] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[index+1];
        arr[index+1] = arr[end];
        arr[end] = temp;

        return index+1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        sort(arr, 0, arr.length-1);
        System.out.print("Sorted: ");
        for (int v : arr) {
            System.out.print(v + " ");
        }
    }
    
}


/**
 * QuickSort Algorithm (Divide & Conquer)
 *
 * Time Complexity:
 *  - Best: O(n log n)
 *  - Average: O(n log n)
 *  - Worst: O(n^2) (when pivot is always smallest/largest)
 *
 * Space Complexity:
 *  - O(log n) for recursion stack (best/average)
 *  - O(n) in worst case (unbalanced partitions)
 */
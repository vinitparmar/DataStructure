package sorting.java;

public class InsertionSort {
    
    static int[] sort(int[] arr){

        for(int i = 1 ; i < arr.length ; i++){
            int value  = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > value){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = value;
        }

        return arr;
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
 * InsertionSort Algorithm
 *
 * Time Complexity:
 *  - Best: O(n)      
 *  - Average: O(n^2)
 *  - Worst: O(n^2)    
 *
 * Space Complexity: O(1) 
 */
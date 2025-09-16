package sorting.java;

public class InsertionSort {
    
    static int[] sort(int[] arr){

        for(int currentIndex  = 1 ; currentIndex  < arr.length ; currentIndex ++){
            int currentValue   = arr[currentIndex];
            int previousIndex  = currentIndex -1;
            while(previousIndex  >= 0 && arr[previousIndex ] > currentValue ){
                arr[previousIndex+1] = arr[previousIndex];
                previousIndex = previousIndex-1;
            }
            arr[previousIndex+1] = currentValue ;
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
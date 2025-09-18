package sorting.java;

public class MergeSort {

    static void sort(int start , int end , int[] arr){

        if(start >= end){
            return;
        }

        int mid = start + (end - start)/2;
        //divide
        sort(start, mid, arr);
        sort(mid+1, end, arr);

        //merge
        merge(start, end, mid, arr);

    }


    static void merge(int start , int end , int mid , int[] arr){

        int n1 = mid-start+1;
        int n2 = end - mid;

        int[] leftArr =  new int[n1];
        int[] rightArr = new int[n2];

        for(int i = 0 ; i < n1 ; i++){
            leftArr[i] = arr[start + i];
        }

        for(int i = 0 ; i < n2 ; i++){
            rightArr[i] = arr[mid+1+i];
        }

        int i = 0; 
        int j = 0;  
        int k = start;

        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            }else{
                arr[k++] = rightArr[j++];
            }
        }

        while(i < n1){
            arr[k++] = leftArr[i++]; 
        }

        while(j < n2){
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        sort(0 , arr.length-1 ,arr);
        System.out.print("Sorted: ");
        for (int v : arr) {
            System.out.print(v + " ");
        }
    }
    
}


/**
 * MergeSort Algorithm (Divide & Conquer)
 *
 * Time Complexity:
 *  - Best: O(n log n)
 *  - Average: O(n log n)
 *  - Worst: O(n log n)
 *
 * Space Complexity: O(n) 
 */
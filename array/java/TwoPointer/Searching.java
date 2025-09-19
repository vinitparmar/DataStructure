package array.java.TwoPointer;

public class Searching {

    //linear search unsorted array
    static void search(int[] arr , int n){
        /*
         * time : O(n)
         * space : O(1)
         */
        for(int i : arr){
            if(i == n){
                System.out.println("Linear Search");
                System.out.println("found");
            }
        }
        System.out.println();
    }

    //Binary search for sorted array
    static void binarySearch(int[] arr , int n){
         /*
         * time : O(logn)
         * space : O(1)
         */
        int start = 0;
        int end = arr.length-1;
        boolean found = false;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == n){
                System.out.println("Binary Search");
                System.out.println("found");
                found = true;
                break;
            }else if(n < arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }
    } 
    
    public static void main(String[] args) {
        int[] arr1 = {1,4,3,2};
        search(arr1, 2);
        int[] arr2 = {1,2,3,4};
        binarySearch(arr2, 3);
    }
}

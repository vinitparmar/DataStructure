package recursion.java;

public class LinearSearch {

    static boolean search(int[] arr , int target , int index){
        if(index == arr.length){
            return false;
        }

        return arr[index] == target || search(arr, target, index+1);

    }
    
    public static void main(String[] args) {
         int[] arr = {1,2,3,5,4,7};
         int target = 7;
        System.out.println(search(arr, target, 0));
    }
}

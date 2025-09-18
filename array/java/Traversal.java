package sorting;

public class Traversal {

   static void traverse(int[] arr){
     /**
     * time : O(n)
     * Space : O(1)
     */
        for(int n : arr){
            System.out.print(n+" ");
        }
        System.out.println();
    }

    static void min( int[] arr){
    /**
     * time : O(n)
     * Space : O(1)
     */
        int minNum = 9999;
        for(int n : arr){
            minNum =  Math.min(minNum , n);
        }
        System.out.println(minNum);
    }

    static void max( int[] arr){
    /**
     * time : O(n)
     * Space : O(1)
     */
        int maxNum = -9999;
        for(int n : arr){
            maxNum = Math.max(maxNum , n);
        }
        System.out.println(maxNum);
    }

    public static void main(String[] args) {
        int[] arr = {1 , 5 ,3 ,7};
        traverse(arr);
        min(arr);
        max(arr);
    }
    
}

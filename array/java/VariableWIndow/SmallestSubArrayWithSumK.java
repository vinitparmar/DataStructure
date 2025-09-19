package array.java.VariableWIndow;

public class SmallestSubArrayWithSumK {

    static int findLength(int[] arr , int k){
        int start = 0;
        int end = 0;
        int sum = 0;

        int len = Integer.MAX_VALUE;

        while(end < arr.length){
            sum += arr[end];
            end++;

            while (sum >= k && start < end) {
                len = Math.min(len, end - start);
                sum -= arr[start];
                start++;
            }
        }

        return len;
    }
    

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 2, 3, 2};
        int k = 7;

        System.out.println(findLength(arr, k));
    }
}


/*
 * Space O(1)
 * Time O(n)
 */
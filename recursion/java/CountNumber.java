package recursion.java;

public class CountNumber {

    static int countOccurenceOfVal(int num, int val){
        return helper(num, val, 0);
    }

    static int helper(int num, int val, int count){
        if(num == 0){
            return count;
        }

        int rem = num%10;

        if(rem == val){
            count++;
        }

        return helper(num/10, val, count);
    }

    public static void main(String[] args) {
        System.out.println(countOccurenceOfVal(12333, 2));
    }
    
}

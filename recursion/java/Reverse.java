package recursion.java;

public class Reverse {

    static int rev2(int num , int rev){

        if(num == 0){
            return rev;
        }

        rev = rev * 10 + (num % 10);

        return rev2(num/10, rev);
    }

    public static void main(String[] args) {
        int number = 12345;
        int reversed = rev2(number, 0);
        System.out.println("Reversed Number: " + reversed);
    }
}

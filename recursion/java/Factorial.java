package recursion.java;

public class Factorial {

    static int fact(int n){

        if(n==1){
             return 1;
        }

        return n*fact(n-1);
    }

    static int sumOfDigits(int num){

        if(num == 0){
            return 0;
        }

        return num%10 + sumOfDigits(num/10);
    }

    static int productOfDigits(int num){

        if(num == 0){
            return 1;
        }

        return num%10 * productOfDigits(num/10);
    }


    public static void main(String[] args) {
        System.out.println("fact value "+fact(5));

        System.out.println("sum is "+ sumOfDigits(123));

        System.out.println("product is "+ productOfDigits(523));
    }
}

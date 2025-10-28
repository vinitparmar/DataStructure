package recursion.java;

public class PrintNumber {

    static void printDec(int n){

        if(n==0){
            return;
        }

        System.out.println(n);
        printDec(n-1);
    }

    static void printAsc(int n){

        if(n==0){
            return;
        }

        printAsc(n-1);
        System.out.println(n);
        
    }

    static void printFwdAndBack(int n){
        
        if(n==0){
            return;
        }

        System.out.println(n);
        printFwdAndBack(n-1);
        System.out.println(n);
    }
    
    public static void main(String[] args) {
        System.out.println("Decending Order");
        printDec(5);
        System.out.println();
        System.out.println("Ascending Order");
        printAsc(5);
        System.out.println();
        System.out.println("Both Order");
        printFwdAndBack(5);
    }
}

package string.java.PatternMatching;

public class Naive {
 
    static void search(String text, String pattern){

        int n = text.length();
        int m = pattern.length();

        int i = 0;

        while (i <= n-m) {
            if(text.substring(i, i+m).equals(pattern)){
                System.out.println("patern found at index "+i);
            }
            i++;
        }

}

public static void main(String[] args) {
    String text = "ABABABCABABABCABAB";
    String pattern = "ABAB";
    search(text, pattern);
}

}

/*
* Complexity
* Time : O(n)
* Space : O(n)
*/
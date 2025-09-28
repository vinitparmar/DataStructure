package string.java.PatternMatching;

import java.util.ArrayList;

public class KMP {
    static void lps(String pattern , int[] lps){

        int slowPtr = 0;

        lps[0] = 0;

        int fastPtr = 1;

        while(fastPtr < pattern.length()){

            //char matches
            if(pattern.charAt(fastPtr) == pattern.charAt(slowPtr)){
                slowPtr++;
                lps[fastPtr] = slowPtr;
                fastPtr++;
            }
            // if mismatches
            else    {
                if(slowPtr!=0){
                    slowPtr = lps[slowPtr-1];
                } else{
                    lps[fastPtr] = 0;
                    fastPtr++;
                }
            }
        }
    }

    static ArrayList<Integer> search(String pat, String txt) {

        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];

        ArrayList<Integer> res =  new ArrayList<>();

        lps(pat, lps);

        int i = 0;
        int j = 0;

        while(i < n){

            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    res.add(i - j);        // match starting index (0-based)
                    j = lps[j - 1];        // fallback using lps of previous char
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba"; 
        String pat = "aaba"; 

        ArrayList<Integer> res = search(pat, txt);
        for (int i = 0; i < res.size(); i++) 
            System.out.print(res.get(i) + " ");
    }

}

/*
 * Complexity
 * Time : O(n+m)
 * Space : O(m)
 */
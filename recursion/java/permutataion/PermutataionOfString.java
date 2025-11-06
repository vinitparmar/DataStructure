package recursion.java.permutataion;

public class PermutataionOfString {

    static void permute(String str , String ans){

        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);

        for(int i = 0 ; i <= ans.length() ; i++){
            String l = ans.substring(0, i);
            String r = ans.substring(i); 
            permute(str.substring(1), l+ch+r);
        }

    }  

    public static void main(String[] args) {
        String  s = "abc";
        permute(s, "");
    }
    
}

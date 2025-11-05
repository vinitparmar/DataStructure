package recursion.java.subsets;

public class Subseq {
    
     static void subSeq(String str , String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        //select char
        subSeq(str.substring(1), ans+ch);
        //reject char
        subSeq(str.substring(1), ans);

     }

    public static void main(String[] args) {

        String str = "abc";
        subSeq(str, "");
        
    }
}

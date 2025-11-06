package recursion.java.subsets;

public class SubSeqAscii {
    
    static void subSeqAscii(String str, String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        subSeqAscii(str.substring(1), ans);
        subSeqAscii(str.substring(1), ans+ch);
        subSeqAscii(str.substring(1), ans+(ch+0));
    }

    public static void main(String[] args) {
        subSeqAscii("abc", "");
    }
}

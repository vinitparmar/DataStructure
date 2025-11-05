package recursion.java.string;

public class SkipCharInString {
   

    static String getResString(String str , String res ) {

        if(str.isEmpty()){
            return res;
        }

        char ch = str.charAt(0);

        if(ch == 'a'){
            //skip
            return getResString(str.substring(1), res);
        }else{
            //dont skip
            return getResString(str.substring(1), res+ch);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(getResString("baccad", ""));
    }
}

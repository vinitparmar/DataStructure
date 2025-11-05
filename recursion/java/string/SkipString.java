package recursion.java.string;

public class SkipString {

    static String skipApple(String str){

        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("apple")){
            return skipApple(str.substring(5));
        }else{
             return str.charAt(0) + skipApple(str.substring(1));
        }
    }
    

    public static void main(String[] args) {
        String str = "bgapplewe";
        System.out.println(skipApple(str));
        
    }
}

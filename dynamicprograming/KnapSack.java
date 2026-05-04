package dynamicprograming;


public class KnapSack {

    static int kanpsack(int[] wt , int[] val , int W , int n){

        if(W == 0 || n == 0){
            return 0;
        }

        if(wt[n-1] <= W ){

            return Math.max(val[n-1]+kanpsack(wt, val, W-wt[n-1],n-1), kanpsack(wt, val, W ,n-1));

        } 

        return kanpsack(wt, val, W ,n-1);

    }
    

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;
        
        System.out.println("Maximum value: " + kanpsack(wt, val, W, n));
    }
}

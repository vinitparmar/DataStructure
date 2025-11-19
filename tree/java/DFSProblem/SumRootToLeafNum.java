package tree.java.DFSProblem;

import java.util.ArrayList;

import tree.java.Node;

public class SumRootToLeafNum {
    
    static Node root;

    static  ArrayList<String>  sumHelper(Node root , ArrayList<String> list,String currString){

        if(root == null){
            return list;
        }

        currString += root.data;

        if(root.left == null && root.right == null){
            list.add(currString);
        }

        sumHelper(root.left , list, currString);
        sumHelper(root.right, list, currString);

        return list;
    }

    static int sum(Node root){
        ArrayList<String> list  = sumHelper(root, new ArrayList<>(), "");

        int res = 0;
        for(String s : list){
            res += Integer.parseInt(s);
        }

        return res;
    }

    public static void main(String[] args) {
        
         root = new Node(5);

        root.left = new Node(4);
        root.right = new Node(8);

        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);

        System.out.println(sum(root));
    }
}

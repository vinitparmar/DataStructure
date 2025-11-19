package tree.java.DFSProblem;

import tree.java.Node;

public class PathSum {

    static Node root;

    static boolean targetSumHelper(Node root , int target, int currSum){

        if(root == null){
            return false;
        }

         currSum = currSum + root.data; 

        if(currSum == target && root.left == null && root.right == null){
            return true;
        }

        return targetSumHelper(root.left, target, currSum)  ||
               targetSumHelper(root.right, target, currSum);

    }

    static boolean target(Node root,int traget){
        return targetSumHelper(root, traget, 0);
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

        System.out.println(target(root, 18)); // true  
        System.out.println(target(root, 29)); // false
    }
}

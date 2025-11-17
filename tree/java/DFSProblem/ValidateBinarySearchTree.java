package tree.java.DFSProblem;

import tree.java.Node;

public class ValidateBinarySearchTree {
    
    static Node root;

    static boolean isValidBst(Node root){
        
        return isValidBstHelper(root, null, null);
    }


    static boolean isValidBstHelper(Node root , Integer min , Integer max){

        if(root ==  null){
            return true;
        }

        if(min != null && root.data <= min){
            return false;
        }
         if(max != null && root.data >= max){
            return false;
        }

        return isValidBstHelper(root.left, min, root.data) && 
                isValidBstHelper(root.right, root.data, max);

    }

    public static void main(String[] args) {
        root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7); 

        System.out.println(isValidBst(root));
    }
}

package tree.java.DFSProblem;

import tree.java.Node;

public class InvertBinaryTree {

    static Node root;
    
    static Node invert(Node root){
        
        if(root == null){
            return null;
        }

        Node left = invert(root.left);
        Node right = invert(root.right);

        //swap
        root.right =  left;
        root.left = right;

        return root;
    }


    static void print(Node root){
        if(root == null){
            return;
        }

        print(root.left);
        System.out.print(root.data+" ");
        print(root.right);
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        print(root);
        System.out.println();
        invert(root);
        print(root);
    }
}

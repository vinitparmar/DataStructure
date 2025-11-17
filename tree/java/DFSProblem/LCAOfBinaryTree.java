package tree.java.DFSProblem;

import tree.java.Node;

public class LCAOfBinaryTree {
    
    static Node root;

    static Node lowestCommonAncestor(Node root, Node p , Node q){

        if(root ==  null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right =  lowestCommonAncestor(root.right, p, q);


        if(left != null && right !=  null){
            return root;
        }

        return left ==  null ? right : left;

    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7); 

        System.out.println(lowestCommonAncestor(root,  root.right.left,  root.right.right).data);

    }
}

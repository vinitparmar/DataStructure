package tree.java.DFSProblem;

import tree.java.Node;

public class DiameterOfBinaryTree {

    static Node root;
    static int diameter = 0;

    static int getDiameter(Node root){

        height(root);
        //gives diameter in number of edges
        return diameter-1;
        //gives diameter in number of nodes
        //return diameter;

    }
    

    static int height(Node root){

        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        int d = lh+rh+1;

        diameter = Math.max(diameter, d);

        return Math.max(lh, rh)+1;
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(getDiameter(root));
    }
}

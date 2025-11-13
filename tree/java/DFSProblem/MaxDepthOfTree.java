package tree.java.DFSProblem;

import tree.java.Node;

public class MaxDepthOfTree {
    
    static Node root;

    static int maxDepth(Node root){
        if(root == null){
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh =  maxDepth(root.right);

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

        System.out.println(maxDepth(root));
    }
}

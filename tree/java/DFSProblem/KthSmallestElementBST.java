package tree.java.DFSProblem;

import tree.java.Node;

public class KthSmallestElementBST {

    static Node root;

    static int count = 0;

    //use inorder
    static Node kthSmallestHelper(Node root , int k){
        //recuursion till we reach leaf node
        if(root == null){
            return null;
        }
        //finding left node
        Node left = kthSmallestHelper(root.left, k);
        //found the node in tree on left side
        if(left != null){
            return left;
        }

        count++;

        if(count == k){
            return root;
        }

        //if not find on right side
        return  kthSmallestHelper(root.right, k);
    }
    

    static int kthSmallest(Node root , int k){
        return kthSmallestHelper(root, k).data;
    }


    public static void main(String[] args) {
        root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);

        System.out.println(kthSmallest(root, 3));
        
    }
    
}

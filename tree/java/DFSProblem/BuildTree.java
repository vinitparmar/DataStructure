package tree.java.DFSProblem;

import tree.java.Node;

public class BuildTree {

    static int preIndex;
    static Node root;

    static Node buildTree(int[] preOrder , int[] inOrder){
        
        return build(preOrder, inOrder, 0,preOrder.length-1);
    }

    static Node build(int[] preOrder , int[] inOrder , int inStart , int inEnd){


        if(inStart > inEnd){
            return null;
        }

         // selct current root from preorder array
        int rootVal =  preOrder[preIndex++];
        Node root = new Node(rootVal);

        //only one value
        if(inStart == inEnd){
            return root;
        }

        //Find the root in inorder
        int idx = search(inOrder, inStart, inEnd, rootVal);

        //build left tree
        root.left = build(preOrder, inOrder, inStart, idx-1);

        //build left tree
        root.right = build(preOrder, inOrder, idx+1, inEnd);

        return root;
    }


    static int search(int[] arr , int start , int end , int target){

        for (int i = start; i <= end; i++) {
            if (arr[i] == target) return i;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in  = {9, 3, 15, 20, 7};

         root = buildTree(pre, in);

        System.out.println("Tree built successfully");
    }
    
}

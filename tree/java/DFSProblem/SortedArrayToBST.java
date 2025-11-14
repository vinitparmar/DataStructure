package tree.java.DFSProblem;

import java.util.LinkedList;
import java.util.Queue;

import tree.java.Node;

public class SortedArrayToBST {

    static Node root ;

    static Node arrToTree(int[] arr){
        return toBst(arr, 0, arr.length-1);
    } 

    static Node toBst(int[] arr , int left , int right){

        if(left > right){
            return null;
        }

        int mid = left + (right-left)/2;

        Node root = new Node(arr[mid]);

        root.left = toBst(arr, left, mid-1);
        root.right = toBst(arr, mid+1, right);

        return root;

    }

  static void levelOrderPrint(Node root){
        if(root == null){
            System.out.println("(empty)");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node n = q.poll();
                System.out.print(n.data + " ");
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // root = new Node(4);
        // root.left = new Node(3);
        // root.right = new Node(5);
        // root.left.left = new Node(1);
        // root.left.right = new Node(2);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7); 

        int[] arr = new int[]{ 1,2,3,4,5,6,7};

        levelOrderPrint(arrToTree(arr));
        
        
    }
    
}

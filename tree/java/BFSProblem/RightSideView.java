package tree.java.BFSProblem;

import java.util.LinkedList;
import java.util.Queue;

public class RightSideView {
    
    static Node root;

    public RightSideView(){
        root = null;
    }

    static void traverse(Node root){

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            
            int size = q.size();

            for(int i = 0 ; i < size ; i++){

                Node curr = q.poll();

                if(i == size-1){
                    System.err.print(curr.data+" ");
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                 if(curr.right != null){
                    q.add(curr.right);
                }
            } 
        }
        
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        traverse(root);
    }
}

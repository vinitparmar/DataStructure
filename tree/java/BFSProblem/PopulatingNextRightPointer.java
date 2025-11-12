package tree.java.BFSProblem;

import java.util.LinkedList;

import java.util.Queue;

// important ---- revise

public class PopulatingNextRightPointer {

    static Node1 root ;

    static void traverse(Node1 root){
        
        Queue<Node1> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size  = q.size();
            Node1 prev = null;

            for(int i = 0; i < size ; i++){
                Node1 curr = q.poll();

                if(prev != null){
                    prev.next = curr;
                }
                prev = curr;

                if (curr.left != null){ 
                    q.add(curr.left);
                }
                if (curr.right != null){
                     q.add(curr.right);
                }
            }

            if(prev != null){
                prev.next = null;
            }
        }
      
    }
    

      static void printLevelsUsingNext(Node1 root) {
        Node1 levelStart = root;
        while (levelStart != null) {
            Node1 curr = levelStart;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println(); 
            levelStart = levelStart.left; 
        }
    }
    public static void main(String[] args) {
         root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);
        traverse(root);
        printLevelsUsingNext(root);

    }
}


 class Node1 {
    int data;
    Node1 left;
    Node1 right;
    Node1 next;

    Node1 (int data){
        this.data =  data;
        this.left = null;
        this.right =  null;
        this.next =  null;
    }
}
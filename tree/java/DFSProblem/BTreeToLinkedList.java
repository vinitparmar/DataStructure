package tree.java.DFSProblem;

import tree.java.Node;

public class BTreeToLinkedList {
    

    static Node root;
    static Node head;
    static Node ptr ; 

    static void toLL(Node root){
        if(root == null){
            return;
        }

        toLL(root.left);
         
        if(head == null){
            head =  new Node(root.data);
            ptr =  head;
        }else{
            ptr.right = new Node(root.data);
            ptr = ptr.right;
        }
        toLL(root.right);

    }


    static void print(Node root){
        Node temp = root;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7); 

        toLL(root);
        print(head);

    }
}

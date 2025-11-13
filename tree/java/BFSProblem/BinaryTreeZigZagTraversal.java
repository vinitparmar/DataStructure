package tree.java.BFSProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.java.Node;


public class BinaryTreeZigZagTraversal {

    static Node root;

    static List<Integer> traverse(Node root){
        List<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean isFwd = true;

        while(!q.isEmpty()){
            int size = q.size();
            
                LinkedList<Integer> tempList =  new LinkedList<>();

                for(int i = 0 ; i < size ; i++){
                    Node curr = q.poll();

                    if(isFwd){
                        tempList.addLast(curr.data);
                    }else{
                      tempList.addFirst(curr.data);  
                    }
                   
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                   
                }
             isFwd = !isFwd;
             result.addAll(tempList);
        }
        return result;
    }
    

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        System.out.println(traverse(root));
    }
}

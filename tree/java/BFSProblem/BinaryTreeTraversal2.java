package tree.java.BFSProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.java.Node;



public class BinaryTreeTraversal2 {
    
    static Node root;
    
    static List<List<Integer>> traverse(Node root){
        
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<Node> q =  new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Node curr = q.poll();
                tempList.add(curr.data);
                if(curr.left != null){
                    q.add(curr.left);
                }
                 if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.addFirst(tempList);
        }

        return result;

    }

    public static void main(String[] args) {
        root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(traverse(root));
    }
}

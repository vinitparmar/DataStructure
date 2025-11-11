package tree.java.BFSProblem;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrederSuccessor {

    static Node root; 

    static int findSuccesor(Node root,int key){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if(curr.left != null){
                q.add(curr.left);
            }

             if(curr.right != null){
                q.add(curr.right);
            }

             if(curr.data == key && !q.isEmpty()){
                return q.peek().data;
            }
        }

        return -1;
    }
    

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println(findSuccesor(root, 70));
    }
}

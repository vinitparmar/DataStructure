package tree.java.BFSProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.java.Node;


public class AvgOfLevelInBinaryTree {

    static Node root;

    static List<Double> avgOfLevels(Node root){
        List<Double> result =  new ArrayList<>();
        Queue<Node> queue =  new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for(int i = 0 ; i < size ; i++){
                Node temp = queue.poll();
                sum+=temp.data;
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }

            result.add((sum/size));
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
        System.out.println(avgOfLevels(root));
    }
}

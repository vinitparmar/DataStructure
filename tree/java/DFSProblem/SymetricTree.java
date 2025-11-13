package tree.java.DFSProblem;

import tree.java.Node;

public class SymetricTree {

    static Node root;


    //DFS Start
    static boolean isSymetric(Node root){
        return isMirror(root.left, root.right);
    }

    static boolean isMirror(Node l , Node r){
        if (l == null && r == null){
            return true;
        }

        
        if (l == null || r == null) {
            return false;
        }

        
        if (l.data != r.data) {
            return false;
        }

        return isMirror(l.left, r.right) || isMirror(l.right, r.left);

    }
    // DFS ends  

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        System.out.println(isSymetric(root));

    }
    
}

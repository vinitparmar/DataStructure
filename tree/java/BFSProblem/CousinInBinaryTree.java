package tree.java.BFSProblem;

import tree.java.Node;

public class CousinInBinaryTree {
    
    static Node root;

    public CousinInBinaryTree(){
        root = null;
    }

    static boolean isCousin(Node root , int x , int y){

        Node nodeX = findNode(root,x);
        Node nodeY = findNode(root,y);

        return (level(root,nodeX,0) == level(root,nodeY,0)) && !isSibling(root,nodeX,nodeY);

    }


    static Node findNode(Node root ,  int x){
        if(root == null){
            return null;
        }

        if(root.data == x){
            return root;
        }

        Node n = findNode(root.left, x);

        if(n != null){
            return n;
        }

        return findNode(root.right, x);
    }

    static boolean isSibling(Node root , Node x , Node y){

        if(root ==  null){
            return false;
        }

        return ((root.left == x  && root.right == y) || (root.left == y && root.right == x))
                                                    || 
                        (isSibling(root.left, x, y) || isSibling(root.right, x, y));
    }


    static int level(Node root , Node n , int lev){
        if(root == null){
            return 0;
        }

        if(root == n){
            return lev;
        }

        int left = level(root.left, n, lev+1);

        if(left != 0){
            return left;
        }

        return level(root.right, n, lev+1);
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println(isCousin(root, 40, 70));
    }
}

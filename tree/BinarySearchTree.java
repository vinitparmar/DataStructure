package tree;

import tree.java.Node;

public class BinarySearchTree {

    static Node root;
    
    public BinarySearchTree(){
        root = null;
    }

    static void insert(int key){
        root = insertRec(root, key);
    }

    static Node insertRec(Node root , int key){

        if(root  ==  null){
            root = new Node(key);
            return root;
        }

        if(key < root.data){
            root.left = insertRec(root.left, key);
        }else if(key > root.data){
            root.right = insertRec(root.right, key);
        }

        return root;
    }


    static void delete(int key){

    }

    static Node deleteRec(Node root , int key){
        if(root == null){
            return root;
        }
        if(key < root.data){
            root.left = deleteRec(root.left, key);
        }else if(key > root.data){
            root.right = deleteRec(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            root.data = minVal(root.right);

            root.right = deleteRec(root.right, key);
        }
        return root;
    }

    static int minVal(Node root){
        int min = root.data;
        while( root.left == null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    static boolean search(int key){
        return searchRec(root, key);
    }

    static boolean searchRec(Node root , int key){

        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(key < root.data){
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }
}

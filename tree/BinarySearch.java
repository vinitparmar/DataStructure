package tree;

public class BinarySearch {

   static Node root;

    public BinarySearch(){
        root = null;
    }

    public static void insert(int key){

        root = insertRec(null, key);
    }
   

    public static Node insertRec(Node root , int key){

        if(root ==  null){
            root =  new Node(key);
            return root;
        }

        if(key < root.data){
            root.left = insertRec(root.left, key);
        }else if(key > root.data){
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    static void inOrder(Node root){
        inOrder(root);
    }

    static void inorderRec(Node root){
        if(root == null){
            return;
        }

        inorderRec(root.left);
        System.out.println(root.data);
        inorderRec(root.right);
    }
    
    static boolean search(int key){
        return searchRec(root , key);
    }

    static boolean searchRec(Node root , int key){
        if(root == null){
            return false;
        }

        if(key == root.data){
            return true;
        }

        if(key < root.data){
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);

    }

    static int findMin(Node root){
        return findMinRec(root);
    }

    static int findMinRec(Node root){

        if(root == null){
            System.out.println("root is null");
            return -1;
        }

        if(root.left == null){
            return root.data;
        }

        return findMinRec(root.left);
    }

     static int findMax(Node root){
        return findMinRec(root);
    }

    static int findMaxRec(Node root){

        if(root == null){
            System.out.println("root is null");
            return -1;
        }

        if(root.right == null){
            return root.data;
        }

        return findMinRec(root.right);
    }

    public static void main(String[] args) {
        

    }
    
}


 class Node {
        
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left =  null;
            this.right =  null;
        }
        
    }

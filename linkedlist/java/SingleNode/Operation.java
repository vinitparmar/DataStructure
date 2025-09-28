package linkedlist.java.SingleNode;

public class Operation {

    static SingleNode head = null;
    static SingleNode tail = null;
    
    static void create(int num){

        SingleNode temp = new SingleNode(num);

        if(head == null){
            head =  temp;
            tail = head;
        }else{
            tail.next = temp;
            tail = tail.next;
        }

        System.out.println("Created");
    }

    static void insert(SingleNode node){

        SingleNode temp = node;

        if(head != null){
            tail.next = temp;
            tail = tail.next;
        }else{
            head = temp;
            tail = head;
        }

        System.out.println("Inserted");  
    }

    static void delete(SingleNode node){
        
        if (head == null) {
            System.out.println("List empty!");
            return;
        }

       
        if (head == node) {
            head = head.next;
            if (head == null){
                 tail = null;
            }
            System.out.println("Deleted: " + node.data);
            return;
        }

        SingleNode ptr =  head;

        if(head != null){
            while(ptr != null){
                if(ptr.next == node){
                    ptr.next = ptr.next.next;
                    System.out.println("Deleted");
                    break;
                }
                ptr = ptr.next;
            }
        }
    }
    
    static void traverse(){

        if(head != null){
            SingleNode temp = head;

            while (temp !=  null) {
                System.out.print(temp.data +" ");
                temp = temp.next;
            }
        }
    }
}

/*
 create → O(1)
 insert → O(1) 
 delete → O(n) 
 traverse → O(n)
 */
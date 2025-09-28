package linkedlist.java.SingleNode;

import org.w3c.dom.Node;

public class ReverseLinkedList {

    static SingleNode reverse(SingleNode head){
        
        SingleNode curr = head;
        SingleNode prev = null;
        SingleNode next = null;

        while (curr != null) {
            
            next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;

    }


    static void print(SingleNode head){

        SingleNode temp = head;

        while(temp != null){

            System.out.print(temp.data+" ");

            temp = temp.next;

        }
    }

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        head.next.next.next.next = new SingleNode(5);

        print(head);

        System.out.println();

        head = reverse(head);

        print(head);
    }
    
}

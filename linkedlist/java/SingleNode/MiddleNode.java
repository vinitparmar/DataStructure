package linkedlist.java.SingleNode;

public class MiddleNode {

    static int returnMiddle(SingleNode head){

        if(head == null){
            System.out.println("return middle element");
            return -1;
        }
        
        SingleNode slow = head;
         SingleNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    
    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        head.next.next.next.next = new SingleNode(5);

        System.out.println(returnMiddle(head));
    }
}


/*
 * Complexity
 * Time : O(n)
 * Space : O(1)
 * 
 */
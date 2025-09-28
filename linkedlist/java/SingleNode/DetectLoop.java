package linkedlist.java.SingleNode;



public class DetectLoop {

    static boolean isLoopPresent(SingleNode head){

        SingleNode slow = head;
        SingleNode fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(3);
        head.next.next = new SingleNode(4);
        head.next.next.next = head.next;

        if (isLoopPresent(head)) {
            System.out.println("loop present");
        }else{
            System.out.println("loop not present");
        }
    }
}


/*
 * Complexity
 * Time : O(n)
 * Space : O(1)
 * 
 */
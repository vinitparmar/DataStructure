package linkedlist.java.SingleNode;

import java.util.HashSet;

public class RemoveDuplicates {

    static SingleNode removeDuplicates(SingleNode head){
        HashSet<Integer> hashSet =  new HashSet<>();
        SingleNode curr =  head;
        SingleNode prev = null;

        while(curr !=  null){
            if(hashSet.contains(curr.data)){
                prev.next = curr.next;
            }else{
                hashSet.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

     static void printList(SingleNode head) {
        SingleNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleNode head = new SingleNode(12);
        head.next = new SingleNode(11);
        head.next.next = new SingleNode(12);
        head.next.next.next = new SingleNode(21);
        head.next.next.next.next = new SingleNode(41);
        head.next.next.next.next.next = new SingleNode(43);
        head.next.next.next.next.next.next = new SingleNode(21);
    
        head = removeDuplicates(head);
        printList(head);
    }
    
}

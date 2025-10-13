package stack.java;


public class LinkedListStack {

    private static class Node {

        int data;
        Node next;

         Node(int data){
            this.data =  data;
            this.next = null;
         }
    }

    Node top;

    public LinkedListStack(){
        this.top =  null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(int value){
        Node newNode =  new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println(newNode.data+" node pushed to stack");
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("cannot pop");
            return -1;
        }
        int poppedValue = top.data;
        top = top.next;
        System.out.println("popped from stack "+poppedValue);
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        stack.pop();

    }
}

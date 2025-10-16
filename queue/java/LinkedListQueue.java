package queue.java;

public class LinkedListQueue {

    class Node {
    int data;
    Node next;
        Node(int newData) {
            data = newData;
            next = null;
        }
    }

    private Node front;
    private Node rear;

    public LinkedListQueue() {
        front = rear = null;
    }
    
    public boolean isEmpty() {
        return front == null;
    }

    public int getfront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public void enqueue(int newData) {
        Node newNode = new Node(newData);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
}

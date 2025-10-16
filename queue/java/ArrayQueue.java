package queue.java;


class ArrayQueue{

    private int[] arr;
    private int capacity;
    private int size;

    ArrayQueue(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        this.size = 0;
    }

    void enQueue(int num){
        if(size == capacity){
            System.out.println("Queue OverFlow");
            return;
        }
        arr[size++] = num;
    }

    void deQueue(){
        if(size == 0){
            System.out.println("Queue underflow");
            return;
        }

        for(int i = 1 ; i < size ; i++){
            arr[i-1] = arr[i];
        }
        size--;
    }

    int getFront() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        
        return arr[0];
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
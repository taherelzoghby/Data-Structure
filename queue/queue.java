package queue;

import stack.stackArrayDynamic;

public class queue<T> {
    //circular queue

    private int front = 0;
    private int rear = 0;
    final private int size;
    private int add_elements=0;
    Object[] arr;

    public queue(int size) {//o(1)
        this.size = size;
        arr = new Object[this.size];
    }
    public int count(){//o(1)
        return this.add_elements;
    }

    public boolean isEmpty() {//o(1)
        return add_elements == 0;
    }

    public boolean isFull() {//o(1)
        return add_elements == size;
    }

    //add element
    public void enqueue(Object element) {//o(1)
        if (isFull()) {
            System.out.println("Queue is full,Can't add number in queue!");
            return;
        }
        arr[rear] = element;
        rear = next(rear);
        add_elements++;
    }

    //remove element
    public Object dequeue() {//o(1)
        if (isEmpty()) {
            System.out.println("Queue is empty,Can't remove number from queue!");
        }
        Object value = arr[front];
        front = next(front);
        --add_elements;
        return value;
    }

    public Object frontQueue() {//o(1)
        return arr[front];
    }

    public Object rearQueue() {//o(1)
        return arr[rear];
    }

    //to move an index step forward
    public int next(int pos) {//o(1)
        ++pos;
        if (pos == size) {
            pos = 0;
        }
        return pos;
    }

    //display queue
    public void display() {//o(n)
        if (isFull()) {
            System.out.println("Queue is Full");
        } else if (isEmpty()) {
            System.out.println("Queue is empty!");
        }
        System.out.println("Front : " + front + " Rear : " + rear);
        for (int curr = front, i = 0; i < add_elements; curr = next(curr), i++) {
            System.out.print(arr[curr] + "\t");
        }
        System.out.println("");
    }

    //clear queue
    public void clear() {//o(n)
        while(!isEmpty()){
            dequeue();
        }
    }
}

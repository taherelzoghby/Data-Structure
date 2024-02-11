package queue;

public class doubleEndedQueue<T> {

    private int front = 0;
    private int rear = 0;
    private int size;
    private int add_elements;
    Object[] arr;

    public doubleEndedQueue(int size) {//o(1)
        this.size = size;
        arr = new Object[this.size];
    }

    public boolean isEmpty() {//o(1)
        return add_elements == 0;
    }

    public boolean isFull() {//o(1)
        return add_elements == size;
    }

    public void enqueue_rear(Object value) {//o(1)
        if (isFull()) {
            System.out.println("Deque is full!");
            return;
        }
        arr[rear] = value;
        rear = next(rear);
        ++add_elements;
    }

    public void enqueue_front(Object value) {//o(1)
        if (isFull()) {
            System.out.println("Deque is full!");
            return;
        }
        front=prev(front);
        rear=next(rear);
        arr[front]=value;
        ++add_elements;
    }

    public Object dequeue_front() {//o(1)
        if (isEmpty()) {
            System.out.println("Queue is empty,Can't remove value from queue!");
        }
        Object value = arr[front];
        front = next(front);
        --add_elements;
        return value;
    }

    public Object dequeue_rear() {//o(1)
        if (isEmpty()) {
            System.out.println("Queue is empty,Can't remove value from queue!");
        }
        Object value = arr[rear];
        rear = prev(rear);
        --add_elements;
        return value;
    }

    public int next(int pos) {//o(1)
        ++pos;
        if (pos == size) {
            pos = 0;
        }
        return pos;
    }

    public int prev(int pos) {//o(1)
        if (pos == 0) {
            pos = size;
        }
        --pos;
        return pos;
    }

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

}

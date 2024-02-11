package queue;

public class stackQueue {

    queue q;
    int add_elements;

    public stackQueue(int size) {//o(1)
        q = new queue(size);
    }

    public boolean isEmpty() {//o(1)
        return q.isEmpty();
    }

    public Object peek() {//o(1)
        return q.frontQueue();
    }

    public void pushAtFront(Object element) {//o(n)
        int siz = add_elements;
        q.enqueue(element);
        while (siz != 0) {
            q.enqueue(q.dequeue());
            siz--;
        }
        add_elements++;
        System.out.println("");
    }

    public Object pop() {//o(1)
        return q.dequeue();
    }
}

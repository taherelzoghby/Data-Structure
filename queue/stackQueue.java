package queue;

public class stackQueue {

    queue q;
    int add_elements;

    public stackQueue(int size) {
        q = new queue(size);
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
    public Object peek(){
        return q.frontQueue();
    }

    public void pushAtFront(Object element) {
        int siz=add_elements;
        q.enqueue(element);
        while(siz!=0){
            q.enqueue(q.dequeue());
            siz--;
        }
        add_elements++;
        System.out.println("");
    }


    public Object pop() {
        return q.dequeue();
    }
}

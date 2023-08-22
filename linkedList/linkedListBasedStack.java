package linkedList;

public class linkedListBasedStack<T> {

    private node head;
    private int size = 0;

    public linkedListBasedStack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int sizeLinkedListStack() {
        return size;
    }

    public void addElement(T value) {
        node item = new node(value);
        item.next = head;
        head = item;
        size++;
    }

    public T pop() {
        T item = null;
        if (isEmpty()) {
            return null;
        }
        item = (T) head.value;
        head = head.next;
        size--;
        return (T) item;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) head.value;
    }

    public void clear() {
        for (node current = head; current != null; current = current.next,size--) {
          head = head.next;
        }
    }

    public void display() {
        System.out.println("\tValue\tNext");
        for (node current = head; current != null; current = current.next) {
            System.out.println("\t" + current.value + "\t" + current.next);
        }
        System.out.println("Size of element in LinkedlistStack : " + sizeLinkedListStack());
    }
}

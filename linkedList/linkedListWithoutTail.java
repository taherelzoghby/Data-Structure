package linkedList;

public class linkedListWithoutTail<T> {

    node head;

    public linkedListWithoutTail() {
        head = null;
    }

    public void addElement(T value) {
        node n_node = new node(value);
        n_node.next = head;
        head = n_node;
    }

    public node getTail() {
        if (head == null) {
            return null;
        }
        node curr = head;
        for (; curr.next != null; curr = curr.next) {
        }
        return curr;
    }

    public void print() {

        for (node curr = head; curr != null; curr = curr.next) {
            System.out.print(curr.value + " ");
        }
        System.out.println("");
    }
}

package linkedList;

public class linkedListWithoutTail<T> {

    NodeLinked head;

    public linkedListWithoutTail() {
        head = null;
    }

    public void addElement(T value) {
        NodeLinked n_node = new NodeLinked(value);
        n_node.next = head;
        head = n_node;
    }

    public NodeLinked getTail() {
        if (head == null) {
            return null;
        }
        NodeLinked curr = head;
        for (; curr.next != null; curr = curr.next) {
        }
        return curr;
    }

    public void print() {

        for (NodeLinked curr = head; curr != null; curr = curr.next) {
            System.out.print(curr.value + " ");
        }
        System.out.println("");
    }
}

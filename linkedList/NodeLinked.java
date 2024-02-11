package linkedList;

public class NodeLinked<T> {

    public T value;
    public NodeLinked next;

    public NodeLinked(T value) {
        this.value = value;
    }

    public static void print(NodeLinked head) {
        NodeLinked curr=head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public static void printReverse(NodeLinked head) {
        NodeLinked curr=head;
        if (curr == null) {
            return;
        }
        printReverse(curr.next);
        System.out.print(curr.value + " ");
    }

    public NodeLinked search(T value, NodeLinked head) {
        NodeLinked curr = head;
        while (curr != null) {
            if (curr.value == value) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

}

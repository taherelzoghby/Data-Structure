package linkedList;

public class Node_DLL<T> {

    public T value;
    public Node_DLL prev;
    public Node_DLL next;

    public Node_DLL(T value) {
        this.value = value;
        this.prev = this.next = null;
    }

}

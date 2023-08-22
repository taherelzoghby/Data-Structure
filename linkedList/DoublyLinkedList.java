package linkedList;

public class DoublyLinkedList {

    private Node_DLL head;
    private Node_DLL tail;
    private int length;

    public DoublyLinkedList() {
        this.head = this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public int size() {
        return this.length;
    }

    public Node_DLL headNode() {
        return this.head;
    }

    public Node_DLL tailNode() {
        return this.tail;
    }

    public void addFirst(Object value) {
        Node_DLL newNode = new Node_DLL(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            link(newNode, head);
            head = newNode;
        }
        ++length;
    }

    public void addLast(Object value) {
        Node_DLL newNode = new Node_DLL(value);
        if (isEmpty()) {
            tail = head = newNode;
        } else {
            link(tail, newNode);
            tail = newNode;
        }
        ++length;
    }

    public void insertedSorted(int val) {
        Node_DLL newNode = new Node_DLL(val);
        if ((int) head.value >= val) {
            addFirst(val);
        } else if ((int) tail.value <= val) {
            addLast(val);
        } else {
            for (Node_DLL curr = head.next; curr != null; curr = curr.next) {
                if ((int) curr.value >= val) {
                    before_middle_after(curr.prev, newNode);
                    break;
                }
            }
        }
        ++length;
    }

    public void deleteFront() {
        if (head == null) {
            return;
        }
        Node_DLL curr = head.next;
        deleteNode(head);
        head = curr;
        if (head != null) {
            head.prev = null;
        }
        if (length == 0) {
            tail = null;
        }
        --length;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }
        Node_DLL curr = tail.prev;
        deleteNode(tail);
        tail = curr;
        if (tail != null) {
            tail.next = null;
        }
        if (length == 0) {
            head = null;
        }
        --length;
    }

    public Node_DLL delete_and_link(Node_DLL item) {
        Node_DLL it = item.prev;
        link(item.prev, item.next);//link previous item with next of item
        deleteNode(item);
        --length;
        return it;
    }

    public void deleteAllNodesWithKey(int val) {
        if (length == 0) {
            System.out.println("list is Empty!");
            return;
        }
        addFirst(-val);//insert fake data to avoid null
        for (Node_DLL curr = head; curr != null;) {
            if ((int) curr.value == val) {
                curr = delete_and_link(curr);//curr equal prev current
                if (curr.next == null) {
                    tail = curr;
                }
            } else {
                curr = curr.next;
            }
        }
        deleteFront();
    }

    public void delete_even_positions() {
        if (length == 0) {
            System.out.println("list is Empty!");
            return;
        } else {
            for (Node_DLL curr = head; curr != null && curr.next != null; curr = curr.next) {
                curr = delete_and_link(curr.next);
                if (curr.next == null) {
                    tail = curr;
                }
            }
        }
    }

    public void delete_odd_positions() {
        addFirst(-1);
        delete_even_positions();
        deleteFront();
    }

    //return element of position
    public Node_DLL nth(int pos) {
        int index = 0;
        for (Node_DLL curr = head; curr != null; curr = curr.next, ++index) {
            if (index == pos) {
                return curr;
            }
        }
        return null;
    }

    //  12321 is palindrome  , 1231 is not palindrome
    public boolean is_palindrome() {
        if (length <= 1) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (nth(i).value != nth(length - i - 1).value) {
                return false;
            }
        }
        return true;
    }

    public boolean is_palindrome2() {
        if (length <= 1) {
            return true;
        }
        int len = length / 2;
        Node_DLL start = head;
        Node_DLL end = tail;
        while ((len--) != 0) {
            if (start.value != end.value) {
                return false;
            }
            start = start.next;
            end = end.prev;
        }
        return true;
    }

    public void deleteNode(Node_DLL nodeToDelete) {
        //if list is empty or nodeToDelete is null
        if (head == null || nodeToDelete == null) {
            return;
        }
        //delete head
        if (head == nodeToDelete) {
            head = nodeToDelete.next;
        }
        //delete tail
        if (tail == nodeToDelete) {
            tail = nodeToDelete.prev;
        }
        //link next of prev node with next node
        if (nodeToDelete.prev != null) {
            nodeToDelete.prev.next = nodeToDelete.next;
        }
        //link prev of next node with prev node
        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = nodeToDelete.prev;
        }
        //delete prev and next 
        nodeToDelete.prev = null;
        nodeToDelete.next = null;
    }

    public void before_middle_after(Node_DLL before, Node_DLL middle) {
        Node_DLL after = before.next;
        link(before, middle);
        link(middle, after);
    }

    public void link(Node_DLL first, Node_DLL second) {
        if (first != null) {
            first.next = second;
        }
        if (second != null) {
            second.prev = first;
        }
    }

    //print linkedlist elements 
    public void display() {
        System.out.print("Elements :");
        for (Node_DLL curr = head; curr != null; curr = curr.next) {
            System.out.print(curr.value + " ");
        }
        System.out.println("");
    }

    //print reverse of linkedlist
    public void displayReverse() {
        System.out.print("Reversed Elements :");
        for (Node_DLL curr = tail; curr != null; curr = curr.prev) {
            System.out.print(curr.value + " ");
        }
        System.out.println("");
    }
}

package linkedList;

public class Linkedlist<T> {

    NodeLinked head;
    NodeLinked tail;
    int length;

    public Linkedlist() {//o(1)
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {//o(1)
        return head == null;
    }

    public void addFirst(T value) {//o(1)
        NodeLinked newNode = new NodeLinked(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void addLast(T value) {//o(1)
        NodeLinked newNode = new NodeLinked(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void insert_bet_twoNode(NodeLinked nod, int value) {//o(1)
        NodeLinked item = new NodeLinked(value);
        item.next = nod.next;
        nod.next = item;
        length++;
    }

    public void insert_sorted(T value) {//o(n)
        if (isEmpty() || (int) value <= (int) head.value) {
            addFirst(value);
        } else if ((int) value >= (int) tail.value) {
            addLast(value);
        } else {
            for (NodeLinked curr = head, prev = null; curr != null; prev = curr, curr = curr.next) {
                if ((int) value <= (int) curr.value) {
                    insert_bet_twoNode(prev, (int) value);
                    break;
                }
            }
        }
    }

    public void removeFirst() {//o(1)
        if (isEmpty()) {
            System.out.println("linkedlist is empty!");
        } else {

            head = head.next;
            if (length == 1) {
                tail = head;
            }
            length--;
        }
    }

    public void removeLast() {//o(1)
        if (isEmpty()) {
            System.out.println("linkedlist is empty!");
        } else {
            if (length == 1) {
                removeFirst();
            } else {
                NodeLinked prev = get_nth(length - 1);
                tail = prev;
                tail.next = null;
            }
            length--;
        }
    }

    //delete by position
    public void remove_nth(int pos) {//o(n)
        if (isEmpty()) {
            System.out.println("linked list is empty");
        } else {
            if (pos == 1) {
                removeFirst();
            } else {
                NodeLinked before_nth = get_nth(pos - 1);
                NodeLinked nth = before_nth.next;
                boolean isTail = (nth == tail);
                before_nth.next = nth.next;
                if (isTail) {
                    tail = before_nth;
                }
            }
            length--;
        }
    }

    //delete by value
    public void delete_node_with_key(T value) {//o(n)
        if (isEmpty()) {
            System.out.println("linkedlist is empty!");
        } else {
            if (value == head.value) {
                removeFirst();
            } else if (value == tail.value) {
                removeLast();
            } else {
                NodeLinked prev = head;
                NodeLinked curr = head.next;
                for (; curr.next != null; curr = curr.next) {
                    if (value == curr.value) {
                        break;
                    }
                    prev = curr;
                }
                prev.next = curr.next;
            }
            length--;
        }
    }

    public void reverse() {//o(n)
        if (size() <= 1) {
            return;
        }
        NodeLinked prev = null;
        NodeLinked curr = head;
        NodeLinked nextt = curr.next;
        while (nextt != null) {
            nextt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextt;
        }
        head = prev;
    }

    public void delete_even_positions() {        //o(n)
        NodeLinked prev = null;
        NodeLinked curr = head;
        int index = 1;
        while (curr != null) {
            if (index % 2 == 0) {
                prev.next = curr.next;
                length--;
            }
            prev = curr;
            curr = curr.next;
            ++index;
        }
    }

    //1 2 3 4  -  1 2 3 4 5
    //2 1 4 3  -  2 1 4 3 5
    public void swap_pairs() {//o(n)
        for (NodeLinked curr = head; curr != null; curr = curr.next) {
            if (curr.next != null) {
                Object v3 = curr.value;
                curr.value = curr.next.value;
                curr.next.value = v3;
                curr = curr.next;
            }
        }
    }

    public int size() {//o(1)
        return this.length;
    }

    public NodeLinked get_nth(int n) {//o(n)
        int indx = 1;
        for (NodeLinked curr = head; curr != null; curr = curr.next, indx++) {
            if (indx == n) {
                return curr;
            }
        }
        return null;
    }

    public NodeLinked get_nth_back(int n) {//o(n)
        // 1 2 3 4 5 6
        if (size() < n) {
            return null;
        }
        return get_nth(size() - n + 1);
    }

    public int search(T value) {//o(n)
        int indx = 0;
        for (NodeLinked curr = head; curr != null; curr = curr.next, indx++) {
            if (curr.value == value) {
                return indx;
            }
        }
        return -1;
    }

    public int search_improve(T value) {//o(n)
        int indx = 0;
        NodeLinked prev = null;
        for (NodeLinked curr = head; curr != null; curr = curr.next, indx++) {
            if (curr.value == value) {
                if (prev == null) {
                    return indx;
                }
                swap(prev.value, curr.value);
                return indx - 1;
            }
            prev = curr;
        }
        return -1;
    }

    public void swap(Object v1, Object v2) {//o(1)
        Object v3 = v1;
        v1 = v2;
        v2 = v3;
    }

    public void print() {//o(n)
        System.out.print("linkedlist : ");
        NodeLinked curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public void print_1() {//o(n)
        for (NodeLinked curr = head; curr != null; curr = curr.next) {
            System.out.print(curr.value + " ");
        }
        System.out.println("");
    }

    public void print_2() {//o(n)
        System.out.println("linkedlist : ");
        for (NodeLinked curr = head; curr != null; curr = curr.next) {
            if (curr == null) {
                System.out.println("null");
                return;
            }
            System.out.print(curr.value + " ");
            if (curr.next == null) {
                System.out.print("x ");
            } else {
                System.out.print(curr.next.value + " ");
            }
            if (curr == head) {
                System.out.print("head ");
            }
            if (curr == tail) {
                System.out.print("tail");
            } else {
                System.out.println("");
            }
        }
        System.out.println("");
    }

    public void printRecursive(NodeLinked node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printRecursive(node.next);

    }

    public void printRecursiveReverse(NodeLinked node) {
        if (node == null) {
            return;
        }
        printRecursiveReverse(node.next);
        System.out.print(node.value + " ");
    }

    public void deleteNode(NodeLinked node) {
        length--;
        node = null;
    }

    public void deleteNextNode(NodeLinked node) {
        assert node != null;

        NodeLinked toDelete = node.next;
        boolean isTail = toDelete == tail;

        node.next = node.next.next;

        deleteNode(toDelete);
        if (isTail) {
            tail = node;
        }
    }

    public void removeAllDublicate() {
        if (length <= 1) {
            return;
        }
        for (NodeLinked curr = head; curr != null; curr = curr.next) {
            for (NodeLinked cur = curr.next, prev = curr; cur != null;) {
                if (curr.value == cur.value) {
                    deleteNextNode(prev);
                    cur = prev.next;
                } else {
                    prev = cur;
                    cur = cur.next;
                }
            }
        }
    }

    public void removeLastOccurance(Object key) {//o(n) time ,o(1) space
        if (length <= 1) {
            return;
        }
        NodeLinked last = null;
        NodeLinked prevC = null;
        for (NodeLinked curr = head, prev = null; curr != null; prev = curr, curr = curr.next) {
            if (curr.value == key) {
                last = curr;
                prevC = prev;
            }
        }
        if (last != null) {
            if (prevC == null) {
                head = last.next;
            } else {
                deleteNextNode(prevC);
            }
            last.next = null;
        }
    }

    public String debug_toString() {//o(n)
        StringBuilder str = new StringBuilder();
        str.append("linkedlist : ");
        for (NodeLinked curr = head; curr != null; curr = curr.next) {
            str.append(curr.value).append(" ");
        }
        return str.toString();
    }

    public void debug_verify_data_integrity() {//o(n)
        if (length == 0) {
            assert (head == null);
            assert (tail == null);
        } else {
            assert (head != null);
            assert (tail != null);
            if (length == 1) {
                assert (head == tail);
            } else {
                assert (head != tail);
            }
            assert (tail.next != null);
        }
        int len = 0;
        for (NodeLinked curr = head; curr != null; curr = curr.next, len++) {
            assert (len < 10000);
        }
        assert (len == length);
        assert (len == size());

    }

    public boolean isSame(Linkedlist list1) {//o(n)
        if (size() == list1.size()) {
            NodeLinked curr1 = list1.head;
            for (NodeLinked curr = head; curr != null; curr = curr.next) {
                if (curr.value != curr1.value) {
                    return false;
                }
                curr1 = curr1.next;
            }
            return true;
        }
        return false;
    }

    public NodeLinked getPrevious(NodeLinked cur) {//o(n)
        NodeLinked prev = null;
        for (NodeLinked curr = head; curr != null; curr = curr.next) {
            if (curr.next.value == cur.value || curr.next == null) {
                prev = curr;
                break;
            }
        }
        return prev;
    }

    public void Swap_head_and_tail() {//o(n)
        if (isEmpty() || head.next == null) {
            return;
        }
        NodeLinked pTail = getPrevious(tail);
        tail.next = head.next;
        pTail.next = head;
        head.next = null;
        //swap between tail and head
        NodeLinked temp = tail;
        tail = head;
        head = temp;

    }

    public void destructorLinked() {//o(n)

        while (head != null) {
            NodeLinked curr = head.next;
            head = null;
            head = curr;
        }
    }

    public void leftRotate(int k) {//o(n)
        if (size() <= 1 || k == size()) {
            return;
        }
        NodeLinked nth = get_nth(k);
        //create cycle
        tail.next = head;
        //reset tail
        tail = nth;
        //reset head;
        head = nth.next;
        //disconnect cycle
        tail.next = null;
    }
}

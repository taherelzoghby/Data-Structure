package linkedList;

public class test {

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.addFirst(6);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(4);
        ll.addFirst(2);
        ll.addFirst(6);
        ll.printRecursive(ll.head);
        System.out.println("");
        ll.moveAllOccurance(6);
        ll.printRecursive(ll.head);
        System.out.println("");

    }
}

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
        //ll.printRecursive(ll.head);
        //System.out.println("");
        //ll.printRecursiveReverse(ll.head);
        //ll.debug_verify_data_integrity();
        //System.out.println("");
        //System.out.println(ll.debug_toString());
        ll.printRecursive(ll.head);
        System.out.println("");
        //ll.removeAllDublicate();
        System.out.println("");
        ll.printRecursive(ll.head);
        System.out.println("");
        ll.removeLastOccurance(6);
        ll.printRecursive(ll.head);
        System.out.println("");

    }
}

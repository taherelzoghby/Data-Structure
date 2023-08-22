package linkedList;

public class node<T> {

    public T value;
    public node next;

    public node(T value) {
        this.value = value;
    }

    public void print(node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public void printReverse(node head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.value + " ");
    }
    public node search(T value,node head){
        node curr=head;
        while(curr!=null){
            if(curr.value==value){
                return curr;
            }
            curr=curr.next;
        }
        return null;
    }
    
}

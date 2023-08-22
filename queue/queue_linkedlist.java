package queue;

import linkedList.Linkedlist;

public class queue_linkedlist<T> {
    Linkedlist<T> list;
    public queue_linkedlist(){
        list=new Linkedlist();
    }
    boolean is_empty(){
       return list.isEmpty();
    }
    public int siz(){
        return list.size();
    }
    public void enqueue(Object value){
        list.addLast((T) value);
    }
    public void dequeue(){
        list.removeFirst();
    }
    public void display(){
        list.print();
    }
}

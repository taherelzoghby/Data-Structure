package queue;

import linkedList.Linkedlist;

public class queue_linkedlist<T> {
    Linkedlist<T> list;
    public queue_linkedlist(){//o(1)
        list=new Linkedlist();
    }
    boolean is_empty(){//o(1)
       return list.isEmpty();
    }
    public int siz(){//o(1)
        return list.size();
    }
    public void enqueue(Object value){//o(1)
        list.addLast((T) value);
    }
    public void dequeue(){//o(1)
        list.removeFirst();
    }
    public void display(){//o(1)
        list.print();
    }
}

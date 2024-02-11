package queue;

import Exception.emptyStack;
import Exception.invalidValue;
import Exception.stackFull;
import stack.stackArr;

public class queue_2_stack<T> {

    int size;
    int add_elements;
    stackArr s1;
    stackArr s2;

    public queue_2_stack(int size) {//o(1)
        this.size = size;
        s1 = new stackArr(size);
        s2 = new stackArr(size);
    }

    public boolean isEmpty() {//o(1)
        return add_elements == 0;
    }

    public boolean isFull() {//o(1)
        return add_elements == this.size;
    }

    //move elements from stack1 to stack2
    private void move(stackArr from, stackArr to) throws emptyStack, invalidValue, stackFull {//o(n)
        while (!from.isEmpty()) {
            to.Push(from.pop());
        }
    }

    public void enqueue(Object value) throws emptyStack, invalidValue, stackFull {//o(n)
        try {
            move(s1, s2);
            s1.Push(value);
            move(s2, s1);
            add_elements++;
        } catch (emptyStack | invalidValue | stackFull e) {
            System.out.println(e);
        }
    }

    public Object dequeue() { //o(1)
        T val = null;
        try {
            val = (T) s1.pop();
            add_elements--;
        } catch (emptyStack e) {
            System.out.println(e);
        }
        return (T) val;
    }

    public void enqueue1(Object value) {//o(1)
        try {
            s1.Push(value);
            add_elements++;
        } catch (invalidValue | stackFull e) {
            System.out.println(e);
        }
    }

    public Object dequeue1() throws invalidValue, stackFull { //o(n)
        T val = null;
        try {
            if (s2.isEmpty()) {// If s2 is done, move again from s1
                move(s1, s2);
            }
            val = (T) s2.pop();
            add_elements--;
        } catch (emptyStack e) {
            System.out.println(e);
        }
        return (T) val;
    }

    public String display() {
        return s1.toString();
    }

}

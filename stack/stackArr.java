package stack;

import Exception.emptyStack;
import Exception.invalidValue;
import Exception.stackFull;

public class stackArr<T> {
//stack 1 add element from first ,stack2 add from back

    private final Object[] stacArray;
    private int size;
    private int top;
    private int nElement;

    public stackArr(int size) {
        this.size = size;
        this.stacArray = new Object[this.size];
        this.top = -1;
    }

    public int numberOfElements() {
        return this.nElement;
    }

    public int Size() {
        return this.size;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public T peek() {
        return (T) stacArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void Push(Object value) throws invalidValue, stackFull {
        if (value == null) {
            throw new invalidValue("invalid value..!");
        } else if (isFull() == true) {
            throw new stackFull("stack is full..!");
        } else {
            stacArray[++top] = value;
            this.nElement++;
        }

    }

    public void push_bottom(Object value) throws emptyStack, invalidValue, stackFull{
        if(isEmpty()){
            Push(value);
        }else{
            Object cur= pop();
            push_bottom(value);
            Push(cur);
        }
    }
    public void reverse() throws emptyStack, invalidValue, stackFull{
        if(isEmpty())
            return;
        Object cur= pop();
        reverse();
        push_bottom(cur);
    }
    public T pop() throws emptyStack {
        if (isEmpty()) {
            throw new emptyStack("stack is empty..!");
        } else {
            this.nElement--;
            return (T) stacArray[top--];
        }
    }
    public void clear(){
        top=-1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("stack ").append(" elements  : ").append("\n");
        for (int i = 0; i <= top; i++) {
            str.append(stacArray[i]).append(" ");
        }

        return str.toString();
    }

}

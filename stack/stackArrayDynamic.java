package stack;

import Exception.emptyStack;
import Exception.invalidValue;
import Exception.stackFull;
import java.util.Arrays;

public class stackArrayDynamic<T> {

    private Object[] stacArray;
    private int top;

    public stackArrayDynamic() {
        this.stacArray = new Object[2];
        this.top = -1;
    }

    public int Size() {
        return this.stacArray.length;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        return (T) stacArray[top];
    }

    public void Push(Object value) throws invalidValue, stackFull {
        ensureCapacity(top + 2);
        if (value == null) {
            throw new invalidValue("invalid value..!");
        } else {
            stacArray[++top] = value;
        }

    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = stacArray.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            stacArray = Arrays.copyOf(stacArray, newCapacity);
        } else if (minCapacity < oldCapacity) {
            int newCap = oldCapacity - (oldCapacity - minCapacity);
            if (newCap > minCapacity) {
                newCap = minCapacity;
            }
            stacArray = Arrays.copyOf(stacArray, newCap);
        }
    }

    public T pop() throws emptyStack {
        ensureCapacity(top + 1);
        if (isEmpty()) {
            throw new emptyStack("stack is empty..!");
        } else {
            return (T) stacArray[top--];
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("stack elements : ").append("\n");
        for (int i = 0; i <= top; i++) {
            if (stacArray[i] != null) {
                str.append(stacArray[i]).append("\t");
            }
        }
        return str.toString();
    }

    public Object[] arr() {
        Object[] array = new Object[this.top + 1];
        for (int i = this.top; i >= 0; i--) {
            if (stacArray[i] != null) {
                array[this.top - i] = stacArray[i];
            }
        }
        return array;
    }

    public void reverse(String s) throws invalidValue, stackFull {
        for (int i = 0; i < s.length(); i++) {
            Push(s.charAt(i));
        }
    }

    public void stackDeleteMiddle() {//delete middle in the stack
        int mid = top / 2;
        stacArray[mid] = null;
    }
}

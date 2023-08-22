/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

public class task1<T> {

    private Object[] stacArray;
    private int size;
    private int addElements;

    public task1(int size) {
        this.size = size;
        this.stacArray = new Object[this.size];
        this.addElements = -1;
    }

    public int Size() {
        return this.size;
    }

    public boolean isFull() {
        return size - 1 == this.addElements;
    }

    public boolean isEmpty() {
        return this.addElements == -1;
    }

    public boolean Push(Object value) {
        if (value != null) {
            stacArray[++this.addElements] = value;
            return true;
        }
        return false;
    }

    public boolean pop() {
        if (!isEmpty()) {
            Object deleted = stacArray[this.addElements--];
            return true;
        }
        return false;
    }

    public T popp() {
        if (!isEmpty()) {
            return (T) stacArray[this.addElements--];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("stack elements : ").append("\n");
        for (int i = 0; i <= this.addElements; i++) {
            str.append(stacArray[i]).append("\n");
        }
        return str.toString();
    }

    public Object[] rev_arr() {
        Object[] array = new Object[this.addElements + 1];
        for (int i = this.addElements; i >= 0; i--) {
            array[this.addElements - i] = stacArray[i];
        }
        return array;
    }

    

   

}

package Vector;

public class Vector<T> implements VectorInterface<T> {

    private Object[] array;
    private int size;
    private int capacity;

    public Vector(int size) {//o(1)
        if (size < 0) {
            size = 1;
        }
        capacity = size;
        array = new Object[this.capacity];
    }

    @Override
    public void insert(int value, int index) {//o(n)
        if (size == capacity) {
            expand_capacity();
        }
        for (int j = size - 1; j >= index; j--) {
            array[j + 1] = array[j];
        }
        array[index] = value;
        ++size;
    }

    @Override
    public int lengthOfNums() {//o(1)
        return this.size;
    }

    @Override
    public Object get(int index) {//o(1)
        return this.array[index];
    }

    @Override
    public void set(int index, Object value) {//o(1)
        this.array[index] = value;
    }

    @Override
    public int find(Object value) {//o(n)
        for (int index = 0; index < this.size; index++) {
            if (value == this.array[index]) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void pushBack(Object value) {//o(1)
        if (size == capacity) {
            expand_capacity();
        }
        array[this.size++] = value;
    }

    @Override
    public void expand_capacity() {//o(n)
        capacity *= 2;
        System.out.println("Expanded capacity to : " + this.capacity);
        Object[] arr2 = new Object[this.capacity];
        System.arraycopy(array, 0, arr2, 0, array.length);
        array = swap(array, arr2);
        arr2 = null;
    }

    @Override
    public Object[] swap(Object[] arr1, Object[] arr2) {//o(1)
        Object[] temp = arr1;
        arr1 = arr2;
        arr2 = temp;
        return arr1;
    }

    @Override
    public void pushFront(Object value) {

    }

    @Override
    public Object getFront() {//o(1)
        return this.array[0];

    }

    @Override
    public Object getBack() {//o(1)
        return this.array[this.size - 1];
    }

    @Override
    public void print() {//o(n)
        System.out.println("");
        for (Object item : this.array) {
            if (item != null) {
                System.out.print(item + " ");
            }
        }
    }

    @Override
    public void right_rotate() {//o(n)
        for (int i = this.array.length - 1; i > 0; i--) {
            Object temp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = temp;
        }
    }

    @Override
    public void left_rotate() {//o(n)
        for (int i = 0; i < this.array.length - 1; i++) {
            Object temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }

    @Override
    public void right_rotate(int times) {//o(n)
        while (times != 0) {
            right_rotate();
            --times;
        }
    }

    @Override
    public void left_rotate(int times) {

    }

    @Override
    public Object pop(Object idx) {//o(n)
        int i = find(idx);
        for (int j = i + 1; j < size; ++j) {
            array[j - 1] = array[j];
            array[j] = null;
        }
        --size;
        return i;
    }

    @Override
    public void right_rotate1() {//o(n)
        Object lastElement = array[array.length - 1];
        for (int p = array.length - 2; p >= 0; --p) {
            array[p + 1] = array[p];
        }
        array[0] = lastElement;
    }

    @Override
    public void left_rotate1() {//o(n)
        Object firstElement = array[0];
        for (int p = 1; p < array.length; ++p) {
            array[p - 1] = array[p];
        }
        array[array.length - 1] = firstElement;
    }

    @Override
    public int find_transposition(Object value) {//o(n)
        if (value == array[0]) {
            return 0;
        } else {
            for (int i = 0; i < size; i++) {
                if (value == array[i]) {
                    Object temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    return i - 1;
                }
            }
        }
        return -1;
    }
}

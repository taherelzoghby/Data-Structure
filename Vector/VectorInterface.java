package Vector;

public interface VectorInterface<T> {

    public void insert(int value, int index);

    public void right_rotate();

    public void right_rotate1();

    public void right_rotate(int times);

    public void left_rotate();

    public void left_rotate1();

    public void left_rotate(int times);

    public int lengthOfNums();

    public Object get(int index);

    public void set(int index, Object value);

    public int find(Object value);

    public void pushBack(Object value);

    public void expand_capacity();

    public Object[] swap(Object[] arr1, Object[] arr2);

    public void pushFront(Object value);

    public Object getFront();

    public Object getBack();

    public Object pop(Object idx);

    public int find_transposition(Object value);

    public void print();
}

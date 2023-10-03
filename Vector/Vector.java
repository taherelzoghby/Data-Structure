package Vector;

public class Vector {

    private final int[] array;
    private int size;

    public Vector(int size) {
        if (size < 0) {
            size = 1;
        }
        this.size=size;
        array = new int[this.size];
    }
    public int length(){
        return this.size;
    }

    public int get(int index) {
        return this.array[index];
    }

    public void set(int index, int value) {
        this.array[index] = value;
    }

    public int find(int value) {
        for (int index = 0; index < this.size; index++) {
            if (value == this.array[index]) {
                return index;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println("");
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
    }
}

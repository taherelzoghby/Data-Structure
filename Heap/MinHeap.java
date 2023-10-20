package Heap;

import tree.Node;

public class MinHeap {

    int[] array;
    int size;
    int capacity = 1000;

    public MinHeap() {
        this.size = 0;
        array = new int[this.capacity];
    }

    public void push(int value) {
        this.array[size++] = value;
        heap_up(size - 1);
    }

    public void heap_up(int chldPos) {
        int indexP = parent(chldPos);
        if (indexP != -1) {
            if (array[indexP] > array[chldPos]) {
                ///shift
                int temp = array[indexP];
                array[indexP] = array[chldPos];
                array[chldPos] = temp;
                ///recur
                heap_up(indexP);
            }
        }
    }

    public void pop() {

    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    public int top() {
        return array[0];
    }

    public int left(int node) {
        int ch1 = 2 * node + 1;
        return ch1 >= size ? -1 : ch1;
    }

    public int right(int node) {
        int ch2 = 2 * node + 2;
        return ch2 >= size ? -1 : ch2;
    }

    public int parent(int node) {
        int p = (node - 1) / 2;
        return node == 0 ? -1 : p;
    }

    public void print() {
        System.out.print("Heap elements : ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}

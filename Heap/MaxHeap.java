package Heap;

import java.util.Vector;

public class MaxHeap {

    int[] array;
    int size;
    int capacity = 1000;

    public MaxHeap(Vector<Integer> v) {//o(n)

        array = new int[this.capacity];
        this.size = v.size();
        for (int i = 0; i < v.size(); i++) {
            this.array[i] = v.get(i);
        }
        heapify();
    }
///get data from last to first to make heap

    public final void heapify() {//o(n)
        for (int i = size / 2 - 1; i >= 0; --i) {
            heap_down(i);
        }
    }

    public int length() {//o(1)
        return size;

    }

    public void push(int value) {//o(logn)
        ///insert value
        this.array[size++] = value;
        ///fix heap tree
        heap_up(size - 1);
    }

    public void heap_up(int chldPos) {//o(logn)
        int indexP = parent(chldPos);
        if (indexP != -1) {
            if (array[indexP] < array[chldPos]) {
                ///swap
                int temp = array[indexP];
                array[indexP] = array[chldPos];
                array[chldPos] = temp;
                ///recur
                heap_up(indexP);
            }
        }
    }

    public void popTop() {//o(logn)
        array[0] = array[size - 1];
        size--;
        heap_down(0);
    }

    public void heap_down(int indexP) {//o(logn)
        int indexC1 = left(indexP);//5->2
        int indexC2 = right(indexP);//6->4
        if (indexC1 == -1) {
            return;
        }
        if (indexC2 != -1 && array[indexC2] > array[indexC1]) {
            indexC1 = indexC2;
        }
        if (array[indexP] < array[indexC1]) {
            ///swap
            int temp = array[indexC1];
            array[indexC1] = array[indexP];
            array[indexP] = temp;
            heap_down(indexC1);
        }
    }

    public boolean isEmpty() {//o(1)
        return array.length == 0;
    }

    public int top() {//o(1)
        return array[0];
    }

    public int left(int node) {//o(1)
        int ch1 = 2 * node + 1;
        return ch1 >= size ? -1 : ch1;
    }

    public int right(int node) {//o(1)
        int ch2 = 2 * node + 2;
        return ch2 >= size ? -1 : ch2;
    }

    public int parent(int node) {//o(1)
        int p = (node - 1) / 2;
        return node == 0 ? -1 : p;
    }

    public void print() {//o(n)
        System.out.print("Max Heap elements : ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}

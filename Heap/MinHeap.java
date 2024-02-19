package Heap;

import java.util.PriorityQueue;
import java.util.Vector;

public class MinHeap {

    int[] array;
    int size;
    int capacity = 1000;

    public MinHeap(Vector<Integer> v) {//o(n)

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
            if (array[indexP] > array[chldPos]) {
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
        int indexC1 = left(indexP);
        int indexC2 = right(indexP);
        if (indexC1 == -1) {
            return;
        }
        if (indexC2 != -1 && array[indexC2] < array[indexC1]) {
            indexC1 = indexC2;
        }
        if (array[indexP] > array[indexC1]) {
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

    public int left(int nodeIndex) {//o(1)
        int ch1 = 2 * nodeIndex + 1;
        return ch1 >= size ? -1 : ch1;
    }

    public int right(int nodeIndex) {//o(1)
        int ch2 = 2 * nodeIndex + 2;
        return ch2 >= size ? -1 : ch2;
    }

    public int parent(int nodeIndex) {//o(1)
        int p = (nodeIndex - 1) / 2;
        return nodeIndex == 0 ? -1 : p;
    }

    public void print_less_than(int val, int parentPos) {
        if (parentPos == -1 || array[parentPos] >= val) {
            return;
        }
        System.out.print(array[parentPos] + " ");
        print_less_than(val, left(parentPos));
        print_less_than(val, right(parentPos));
    }

    public boolean is_heap_array(int indP) {
        int indLeft = left(indP);
        int indRight = right(indP);
        if (indLeft == -1 || indRight == -1) {
            return true;
        }

        if (array[indP] > array[indLeft] || array[indP] > array[indRight]) {
            return false;
        }
        boolean leftHeap = is_heap_array(indLeft);
        boolean rightHeap = is_heap_array(indRight);

        return leftHeap && rightHeap;
    }

    public void heap_sort(int[] arr, int length) {
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("");
    }

    public int search(int value) {//o(log(n))
        return recursiveSearch(value, 0);
    }

    public int recursiveSearch(int value, int index) {
        if (index >= size) {
            return -1;
        }
        if (value == array[index]) {
            return index;
        }
        int indLeft = left(index);
        int indRight = right(index);
        if (indLeft != -1 && indLeft < size && array[indLeft] <= value) {
            int result = recursiveSearch(value, indLeft);
            if (result != -1) {
                return result;
            }
        }
        if (indRight != -1 && indRight < size && array[indRight] <= value) {
            int result = recursiveSearch(value, indRight);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }

    public void test_priority_queue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(3);
        pq.add(7);
        pq.add(5);
        pq.add(9);
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.poll();
        }
        System.out.println("");
    }

    public void print() {//o(n)
        System.out.print("Min Heap elements : ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}

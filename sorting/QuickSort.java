package sorting;

//quick sort
public class QuickSort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int p, int q) {
        int pivot = arr[p];
        int i = p;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] <= pivot) {
                ++i;
                swap(arr, j, i);
            }
        }
        swap(arr, p, i);
        return i;
    }

    public static void quickSort(int[] arr, int p, int r) {
        int q = 0;
        if (p < r) {
            q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40};
        quickSort(arr, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}

package sorting;

public class bitonic {

    static void compAndSwap(int a[], int i, int j, int dir) {
        if ((a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    static void bitonicMerge(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                compAndSwap(a, i, i + k, dir);
            }
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    public static void bitonicSort(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            bitonicSort(a, low, k, 1);
            bitonicSort(a, low + k, k, 0);
            bitonicMerge(a, low, cnt, dir);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Initialize an array for testing
        int arr[] = {3, 7, 4, 8, 6, 2, 1, 5};
        int up = 1; // 1 for ascending order, 0 for descending order
        bitonicSort(arr, 0, arr.length, up);

        // Print the sorted array
        System.out.print("Sorted array:");
        printArray(arr);
    }
}


import java.util.Vector;
import tree.BinaryTree;
import tree.Node;

public class DataStructure {

    static void insertion(int[] arr) {//take 0.91 time
        int size = arr.length, temp = 0;
        for (int i = 1; i < size; i++) {
            temp = i;
            for (int j = 0; j < i; j++) {
                if (arr[temp] < arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[temp];
                    arr[temp] = t;
                }
            }
        }
    }

    static void insertion2(int[] arr) {//take 0.57 time
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void bubbleSort(int[] arr) {
        int size = arr.length;
        boolean flag = true;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag == true) {
                break;
            }
        }
    }

    static void selectionSort(int[] arr) {
        int size = arr.length, minInd = 0;
        for (int i = 0; i < size - 1; i++) {
            minInd = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            int temp = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = temp;
        }
    }

    static void selectionSort2(int[] arr) {
        int size = arr.length, maxInd = size;
        for (int i = 0; i < size - 1; i++) {
            maxInd = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[maxInd]) {
                    maxInd = j;
                }
            }
            int temp = arr[maxInd];
            arr[maxInd] = arr[i];
            arr[i] = temp;
        }
    }

    static void print(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    static int count = 0;
//fib

    static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib2(n - 1) + fib2(n - 2);
        }
    }
    static int n1 = 0, n2 = 1, sum = 0;

    static void fib(int n) {
        if (n > 0) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            System.out.print(" " + sum);
            fib(n - 1);
        }

    }

    static int linearSum(int[] data, int n) {
        if (n < 0) {
            return 0;
        } else {
            return linearSum(data, n - 1) + data[n];
        }
    }

    static public boolean isPowerOfTwo(int n) {
        if ((n % 2 != 0 && n != 1) || n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return (n == 0 || n == 1);
    }

    static void funSpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    static void funStar(int n) {
        for (int i = n; i >= 1; i--) {
            System.out.print("* ");
        }
    }

    static void star(int n) {
        for (int i = n; i >= 1; i--) {
            funSpace(n - i);
            funStar(i);
            System.out.println("");
        }
        for (int i = n - 1; i >= 1; i--) {
            funSpace(i - 1);
            funStar(n - i + 1);
            System.out.println("");
        }
    }

    static void draw(int n) {
        if (n < 0) {
            return;
        }
        draw(n - 1);
        System.out.println("---- " + n);
        if (n < 2) {
            System.out.println("-\n--\n-\n---\n-\n--\n-");
        }
    }

    public static void drawRular(int inches, int majorLength) {
        drawLine(majorLength, 0);
        for (int j = 1; j <= inches; j++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, j);
        }
    }

    public static void drawInterval(int centeralLength) {
        if (centeralLength >= 1) {
            drawInterval(centeralLength - 1);
            drawLine(centeralLength);
            drawInterval(centeralLength - 1);
        }
    }

    public static void drawLine(int tickLength, int tickLabel) {
        for (int j = 0; j < tickLength; j++) {
            System.out.println("-");
        }
        if (tickLabel >= 0) {
            System.out.println(" " + tickLabel);
        }
        System.out.println("\n");

    }

    public static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }

    //loop
    public static boolean binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    //recursion
    public static boolean binarySearch(int[] array, int target, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target < array[mid]) {
                return binarySearch(array, target, low, mid - 1);
            } else if (target > array[mid]) {
                return binarySearch(array, target, mid + 1, high);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void reverseArr(int[] array, int low, int high) {
        if (low < high) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            reverseArr(array, low + 1, high - 1);
        }
    }

    public static double power(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }

    public static int sumSubArray(int[] array, int low, int high) {
        if (low > high) {//no elements
            return 0;
        } else if (low == high) {//one element
            return array[low];
        } else {
            int mid = (low + high) / 2;
            return sumSubArray(array, low, mid) + sumSubArray(array, mid + 1, high);
        }
    }

    static void towerOfHanoi(int n, char from_rod, char to_rod, char helper_rod) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, helper_rod, to_rod);
        System.out.println("Take disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(n - 1, helper_rod, to_rod, from_rod);
    }

    public static void print_inOrder(Node node) {
        if (node == null) {
            return;
        }
        print_inOrder(node.left);
        System.out.print(node.data + " ");
        print_inOrder(node.right);
    }

    public static void print_postOrder(Node node) {
        if (node == null) {
            return;
        }
        print_postOrder(node.left);
        print_postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void print_preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        print_preOrder(node.left);
        print_preOrder(node.right);
    }

    public static void clear(Node node) {

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(2);
        Vector<Integer> values1 = new Vector<Integer>();
        values1.add(3);
        values1.add(5);
        Vector<Character> directions1 = new Vector<>();
        directions1.add('L');
        directions1.add('L');
        tree.add(values1, directions1);
        Vector<Integer> values11 = new Vector<>();
        values11.add(3);
         values11.add(16);
        Vector<Character> directions11 = new Vector<>();
        directions11.add('L');
        directions11.add('R');
        tree.add(values11, directions11);
        Vector<Integer> values2 = new Vector<>();
        values2.add(13);
        values2.add(7);
        Vector<Character> directions2 = new Vector<>();
        directions2.add('R');
        directions2.add('L');
        tree.add(values2, directions2);
        Vector<Integer> values3 = new Vector<>();
        values3.add(13);
        values3.add(8);
        Vector<Character> directions3 = new Vector<>();
        directions3.add('R');
        directions3.add('R');
        tree.add(values3, directions3);
        System.out.println();
        tree.in_order();
        System.out.println();
        tree.pre_order();
        System.out.println();
        tree.post_order();
        System.out.println();
        System.out.println("max : " + tree.tree_max());
        System.out.println("min : " + tree.tree_min());
        System.out.println("Height : " + (tree.tree_height(tree)-1));
        System.out.println("Height : " + tree.tree_height1());
        System.out.println("total nodes : "+tree.total_nodes());
        System.out.println("total leaf nodes : "+tree.total_leaf_nodes());
        System.out.println("Value is exist : "+tree.is_exists(8));
        System.out.println("Tree is perfect : "+tree.is_perfect());
        System.out.println(tree.checkTree(tree));

//        Node plus = new Node('+');
//        plus.left = new Node('2');
//        plus.right = new Node('3');
//
//        Node div = new Node('/');
//        div.left = new Node('8');
//        div.right = new Node('4');
//
//        Node minus = new Node('-');
//        minus.left = new Node('9');
//        minus.right = div;
//
//        Node multiply = new Node('*');
//        multiply.left = plus;
//        multiply.right = minus;
//
//        print_inOrder(multiply);
//        clear(multiply);
//        System.out.println();
//        print_inOrder(multiply);
//        Node n1 = new Node(1);
//        Node n2 = new Node(2);
//        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);
//        Node n7 = new Node(7);
//        Node n9 = new Node(9);
//        n1.right = n3;
//        n1.left = n2;
//        n2.left = n4;
//        n2.right = n7;
//        n3.left = n5;
//        n3.right = n9;
//        n4.left = n2;
//        print_inOrder(n1);
    }

}

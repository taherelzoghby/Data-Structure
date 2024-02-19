
import Heap.MaxHeap;
import Heap.MinHeap;
import java.util.Vector;

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

    static int first = 0, second = 1;

    static void fibon(int n) {
        if (n == 2) {
            return;
        }
        int sum = first + second;//1 2 3 5 8 13
        first = second;//1 1 2 3 5 8
        second = sum;//1 2 3 5 8 13
        System.out.print(sum + " ");
        fibon(n - 1);
    }

    static int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);//0 1 1 2 3 5 8 13 21 34
        }
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

    static void bubbleSort(int[] arr) {//o(n2)
        int size = arr.length;
        boolean flag = true;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap 
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

    //selection sort
    static void selectionSort(int[] arr) {//o(n2)
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

    public static void main(String[] args) throws InterruptedException {
//        int[] arr = {20, 10, 4, 5, 3};
//        selectionSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(" " + arr[i]);
//        }
//        System.out.println("");
        //        NodeLinked node1 = new NodeLinked(10);
        //        NodeLinked node2 = new NodeLinked(20);
        //        NodeLinked node3 = new NodeLinked(30);
        //        NodeLinked node4 = new NodeLinked(40);
        //        NodeLinked node5 = new NodeLinked(50);
        //        node1.next = node2;
        //        node2.next = node3;
        //        node3.next = node4;
        //        node4.next = node5;
        //        node5.next=null;
        //        NodeLinked.print(node1);
        //        System.out.println("node4 : "+node1.next.next.next.next.value);
        //        System.out.println("node4 : "+node2.next.next.next.value);
        //        System.out.println("node4 : "+node3.next.next.value);
        //        System.out.println("node4 : "+node4.next.value);
        //        NodeLinked.printReverse(node1);
        //        System.out.println("");

        //
        //        System.out.println("");
        //        // Execute methods sequentially
        //        System.out.println(sum(num1, num2));
        //        System.out.println(subtract(num1, num2));
        //        System.out.println(multiple(num1, num2));
        // heap
        /////vector
        Vector<Integer> vector = new Vector(5);
        vector.add(50);
        vector.add(17);
        vector.add(4);
        vector.add(10);
        vector.add(8);
        vector.add(9);
        vector.add(15);
        vector.add(19);
        vector.add(7);
        vector.add(6);
        vector.add(5);
        System.out.println(vector);
        MinHeap heap = new MinHeap(vector);
//        heap.push(2);
//        heap.push(6);
//        heap.push(8);
        heap.push(14);
//        heap.push(7);
//        heap.push(10);
//        heap.push(19);
//        heap.push(37);
//        heap.push(25);
//        heap.push(30);
//        heap.push(12);
//        heap.push(22);
//        heap.push(17);
//        heap.print();
//        System.out.println(heap.length());
//        heap.popTop();
//        heap.popTop();
//        heap.popTop();
//        heap.popTop();
//        heap.popTop();
//        heap.popTop();
//        heap.popTop();
//        heap.popTop();
        //heap.popTop();
        heap.print();
        System.out.println(heap.search(50));
        heap.test_priority_queue();
        //System.out.println(heap.length());
        //heap.print_less_than(10, 0);
        //System.out.println("");
        //System.out.println("is heap : " + heap.is_heap_array(0));
        //int sz = 14;
        //int[] arr1 = {2, 17, 22, 10, 8, 37, 14, 19, 7, 6, 5, 12, 25, 30};
        //heap.heap_sort(arr1, sz);
//        for(int i=0;i<arr1.length;i++){
//            System.out.print(arr1[i]+" ");
//        }

//        //////////////////////////////////////////////////////////////////////
//        vector.insert(20, 1);
//        vector.print();
//        System.out.println("");
//        System.out.println(vector.lengthOfNums());
//        System.out.println(vector.find_transposition(41));
//        vector.print();
//        System.out.println("");
//        BinarySearchTree tree = new BinarySearchTree(60);
//        tree.insert(25);
//        tree.insert(75);
//        tree.insert(5);
//        tree.insert(15);
//        tree.insert(65);
//        tree.insert(70);
//        tree.insert(85);
//        tree.insert(95);
//        tree.insert(80);
//        System.out.println("min tree : " + tree.minTree(tree.root));
//        tree.printInOrder();
//        System.out.println(tree.search(5));
//        Vector<Node> path = new Vector<>();
//        tree.find_path(70, path);
//        Node node=tree.get_next(path);
//        for (int i = 0; i < path.size(); i++) {
//            System.out.print(path.get(i).data + " ");
//        }
//        System.out.println("\n"+node.data);
//        tree.emptyLine();
//        System.out.println(tree.isBinarySearchTreeIterative());
//        System.out.println("successor : "+tree.successor(25));
//        tree.printInOrder();
//        tree.deleteNode(75,tree.root);
//        tree.printInOrder();
//        items.add(10);
//        items.add(20);
//        items.add(30);
//        items.add(40);
//        items.add(50);
//        items.add(60);
//        items.add(70);
//        BST newTree = test.buid_Balanced_Binary_search_tree(items, 0, -10);
//        items.clear();
//        newTree.get_inorder(items);
//        System.out.println(items);
        //BinaryTree tree = new BinaryTree(1);
//        Vector<Integer> values1 = new Vector<Integer>();
//        values1.add(2);
//        values1.add(4);
//        Vector<Character> directions1 = new Vector<>();
//        directions1.add('L');
//        directions1.add('L');
//        tree.add(values1, directions1);
//        Vector<Integer> values11 = new Vector<>();
//        values11.add(2);
//        values11.add(5);
//        Vector<Character> directions11 = new Vector<>();
//        directions11.add('L');
//        directions11.add('R');
//        tree.add(values11, directions11);
//        Vector<Integer> values2 = new Vector<>();
//        values2.add(3);
//        values2.add(6);
//        Vector<Character> directions2 = new Vector<>();
//        directions2.add('R');
//        directions2.add('R');
//        tree.add(values2, directions2);
//        System.out.println();
//        tree.in_order();
//        System.out.println();
//        tree.pre_order();
//        System.out.println();
//        tree.post_order();
//        System.out.println();
//        System.out.println("max : " + tree.tree_max());
//        System.out.println("minTree : " + tree.tree_min());
//        System.out.println("Height : " + (tree.tree_height(tree) - 1));
//        System.out.println("Height : " + tree.tree_height1());
//        System.out.println("total nodes : " + tree.total_nodes());
//        System.out.println("total leaf nodes : " + tree.total_leaf_nodes());
//        System.out.println("Value is exist : " + tree.is_exists(8));
//        System.out.println("Tree is perfect : " + tree.is_perfect());
//        System.out.println(tree.checkTree(tree));
//        tree.levelOrderTraversal();
//        tree.level_order_traversal_recursive();
//        tree.level_order_traversal_spiral();
//        System.out.println("nonleafs : " + tree.total_nonLeaf_nodes());
//        System.out.println("serilaization : " + tree.print_parenthsizing());
//        System.out.println("parenthsizing Canonicalizing : " + tree.parenthsizing_Canonicalizing());
//        //tree2
//        BinaryTree tree1 = new BinaryTree(1);
//        Vector<Integer> valuest1 = new Vector<Integer>();
//        valuest1.add(3);
//        valuest1.add(6);
//        Vector<Character> directionst1 = new Vector<>();
//        directionst1.add('L');
//        directionst1.add('L');
//        tree1.add(valuest1, directionst1);
//        Vector<Integer> valuest11 = new Vector<>();
//        valuest11.add(2);
//        valuest11.add(5);
//        Vector<Character> directionst11 = new Vector<>();
//        directionst11.add('R');
//        directionst11.add('L');
//        tree1.add(valuest11, directionst11);
//        Vector<Integer> valuest2 = new Vector<>();
//        valuest2.add(2);
//        valuest2.add(4);
//        Vector<Character> directionst2 = new Vector<>();
//        directionst2.add('R');
//        directionst2.add('R');
//        tree1.add(valuest2, directionst2);
//
//        System.out.println("parenthsizing Canonicalizing2 : " + tree1.parenthsizing_Canonicalizing());
//        //tree3
//        BinaryTree tree2 = new BinaryTree(1);
//        Vector<Integer> valuestt1 = new Vector<Integer>();
//        valuestt1.add(3);
//        valuestt1.add(6);
//        Vector<Character> directionstt1 = new Vector<>();
//        directionstt1.add('L');
//        directionstt1.add('R');
//        tree2.add(valuestt1, directionstt1);
//        Vector<Integer> valuestt11 = new Vector<>();
//        valuestt11.add(2);
//        valuestt11.add(5);
//        Vector<Character> directionstt11 = new Vector<>();
//        directionstt11.add('R');
//        directionstt11.add('L');
//        tree2.add(valuestt11, directionstt11);
//        Vector<Integer> valuestt2 = new Vector<>();
//        valuestt2.add(2);
//        valuestt2.add(4);
//        Vector<Character> directionstt2 = new Vector<>();
//        directionstt2.add('R');
//        directionstt2.add('R');
//        tree2.add(valuestt2, directionstt2);
//
//        System.out.println("parenthsizing Canonicalizing3 : " + tree2.parenthsizing_Canonicalizing());
//        // System.out.println(tree.isIdentical(tree.parenthsizing_Canonicalizing(), tree.parenthsizing_Canonicalizing()));
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

package AvlTree;

public class test {

    public static void main(String[] args) {
        AvlTree tree = new AvlTree(3);
        tree.insert(5);
        tree.insert(9);
        tree.insert(1);
        tree.insert(0);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(7);
        tree.insert(4);
        tree.insert(8);
        System.out.println(tree.root.left.right.data);
    }

}

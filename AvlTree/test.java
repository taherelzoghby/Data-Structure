package AvlTree;

public class test {

    public static void main(String[] args) {
        AvlTree tree = new AvlTree(20);
        tree.right = new AvlTree(22);
        tree.right.right = new AvlTree(24);
        System.out.println(tree.data);
        System.out.println(tree.right.data);
        System.out.println(tree.right.right.data);
        tree = tree.balance(tree);
        System.out.println("after balance");
        System.out.println(tree.data);
        System.out.println(tree.left.data + " " + tree.right.data);
        //System.out.println(tree.right.right.data);
    }

}

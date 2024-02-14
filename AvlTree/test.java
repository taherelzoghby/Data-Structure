package AvlTree;

public class test {

    public static void main(String[] args) {
        AvlTree tree = new AvlTree(20);
        tree.left = new AvlTree(9);
        tree.right = new AvlTree(12);
        tree.right.right = new AvlTree(24);
        tree.right.left = new AvlTree(11);
        System.out.println("before rotate : "+tree.balanceFactor());
       tree= tree.leftRotate(tree);
        System.out.println(tree.right.data);
        System.out.println("after left rotate : "+tree.balanceFactor());
        System.out.println(tree.height);
    }

}

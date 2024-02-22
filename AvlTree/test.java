package AvlTree;

public class test {

    public static void main(String[] args) {
        AvlTree tree = new AvlTree(5);
        tree.insert(9);
        tree.insert(1);
        tree.insert(0);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(7);
        tree.insert(4);
        //System.out.println(tree.root.data);
        //tree.delete(5);
        //System.out.println(tree.root.right.left.data);
        System.out.println("successor for 5 : "+tree.successor(5));
        tree.inOrder();
        tree.preOrder();
        tree.postOrder();
    }

}

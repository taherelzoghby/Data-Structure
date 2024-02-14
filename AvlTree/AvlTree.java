package AvlTree;

public class AvlTree {

    public int data;
    public int height;
    public AvlTree left;
    public AvlTree right;

    public AvlTree(int data) {
        this.data = data;
    }

    public int childHeight(AvlTree node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void updateHeight() {
        height = 1 + Math.max(childHeight(left), childHeight(right));
    }

    public int balanceFactor() {
        return childHeight(left) - childHeight(right);
    }

    public AvlTree leftRotate(AvlTree p) {
        AvlTree q = p.right;
        p.right = q.left;
        q.left = p;
        p.updateHeight();
        q.updateHeight();
        return q;
    }

    public AvlTree rightRotate(AvlTree q) {
        AvlTree p = q.left;
        q.left = p.right;
        p.right = q;
        p.updateHeight();
        q.updateHeight();
        return p;
    }

}

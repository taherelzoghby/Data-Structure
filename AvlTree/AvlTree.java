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

    public AvlTree balance(AvlTree node) {
        if (node.balanceFactor() == -2) {//Right Right
            if (node.right.balanceFactor() == 1) {//Right Left
                node.right = rightRotate(node.right);
            }
            node = leftRotate(node);
        } else if (node.balanceFactor() == 2) {//Left Left
            if (node.left.balanceFactor() == -1) {//Left Right
                node.left = leftRotate(node.left);
            }
            node = rightRotate(node);
        }
        return node;
    }

}

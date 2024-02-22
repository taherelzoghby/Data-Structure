package AvlTree;

public class AvlTree {

    public NodeTree root;

    public AvlTree(int data) {
        this.root = new NodeTree(data);
    }

    public NodeTree leftRotate(NodeTree p) {
        NodeTree q = p.right;
        p.right = q.left;
        q.left = p;
        p.updateHeight();
        q.updateHeight();
        return q;
    }

    public NodeTree rightRotate(NodeTree q) {
        NodeTree p = q.left;
        q.left = p.right;
        p.right = q;
        p.updateHeight();
        q.updateHeight();
        return p;
    }

    public NodeTree balance(NodeTree node) {
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

    public void insert(int target) {
        if (root == null) {
            root = new NodeTree(target);
        } else {
            root = insertNode(target, root);
        }
    }

    public NodeTree insertNode(int target, NodeTree node) {
        if (target < node.data) {
            if (node.left == null) {
                node.left = new NodeTree(target);
            } else {
                node.left = insertNode(target, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new NodeTree(target);
            } else {
                node.right = insertNode(target, node.right);
            }
        }
        node.updateHeight();
        return balance(node);
    }

    public void delete(int target) {
        if (root != null) {
            root = deleteNode(target, root);
        }
    }

    public NodeTree deleteNode(int target, NodeTree node) {
        if (node == null) {
            return null;
        }
        //prev=5
        if (target > node.data) {//right
            node.right = deleteNode(target, node.right);
        } else if (target < node.data) {//left
            node.left = deleteNode(target, node.left);
        } else {//found
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left != null && node.right != null) {
                NodeTree successor = minSubTree(node.right);
                node.data = successor.data;
                node.right = deleteNode(successor.data, node.right);
            } else if (node.left == null) {
                node = node.right;
            } else {
                node = node.left;
            }

        }
        if (node != null) {
            node.updateHeight();
            node = balance(node);
        }

        return node;
    }

    public NodeTree minSubTree(NodeTree node) {
        if (node.left == null) {
            return node;
        }
        return minSubTree(node.left);
    }
}

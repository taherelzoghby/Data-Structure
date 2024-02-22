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
                NodeTree successor = min(node.right);
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

    public NodeTree min(NodeTree node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public NodeTree max(NodeTree node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public int successor(int target) {
        NodeTree node = search(target);//node(target)
        NodeTree successor = min(node.right);
        return successor.data;
    }

    public NodeTree search(int target) {
        return searchRecur(target, root);
    }

    public NodeTree searchRecur(int target, NodeTree node) {
        if (node == null || node.data == target) {
            return node;
        }
        if (target < node.data) {
            return searchRecur(target, node.left);
        } else {
            return searchRecur(target, node.right);
        }
    }

    public void inOrder() {
        System.out.print("in order traversal : ");
        inOrderRecur(root);
        System.out.println();
    }

    public void inOrderRecur(NodeTree node) {
        if (node == null) {
            return;
        }
        inOrderRecur(node.left);// go to left
        System.out.print(node.data + " ");
        inOrderRecur(node.right);// go to right
    }

    public void preOrder() {
        System.out.print("pre order traversal : ");
        preOrderRecur(root);
        System.out.println();
    }

    public void preOrderRecur(NodeTree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderRecur(node.left);// go to left
        preOrderRecur(node.right);// go to right
    }

    public void postOrder() {
        System.out.print("pre order traversal : ");
        postOrderRecur(root);
        System.out.println();
    }

    public void postOrderRecur(NodeTree node) {
        if (node == null) {
            return;
        }
        postOrderRecur(node.left);// go to left
        postOrderRecur(node.right);// go to right
        System.out.print(node.data + " ");
    }

}

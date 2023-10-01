package tree;

import java.util.Vector;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(int root) {
        this.root = new Node(root);
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = insertNode(root.left, value);
        } else if (value > root.data) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    public Node minTree(Node node) {
        Node current = node;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void printInOrder() {
        get_inorder(root);
        emptyLine();
    }

    private void get_inorder(Node node) {
        if (node.left != null) {
            get_inorder(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null) {
            get_inorder(node.right);
        }
    }

    public boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node node, int value) {
        if (node == null) {
            return false;
        }
        boolean result = value == node.data;

        if (value > node.data && !result && node.right != null) {
            result = searchNode(node.right, value);
        }
        if (value < node.data && !result && node.left != null) {
            result = searchNode(node.left, value);
        }
        return result;
    }

    public boolean search_and_getPath(Node node, int value, Vector<Integer> path) {
        if (node == null) {
            return false;
        }
        path.add(node.data);
        if (value == node.data) {
            return true;
        }

        if (value > node.data && node.right != null) {
            return search_and_getPath(node.right, value, path);
        }
        if (value < node.data && node.left != null) {
            return search_and_getPath(node.left, value, path);
        }
        return false;
    }

    public int lowestCommonAncestor(int x, int y) {
        return LCAImpl(root, x, y);
    }

    private int LCAImpl(Node node, int x, int y) {
        if (x < node.data && y < node.data) {
            return LCAImpl(node.left, x, y);
        }

        if (x > node.data && y > node.data) {
            return LCAImpl(node.right, x, y);
        }

        return node.data;
    }

    public boolean isBinarySearchTree() {
        return isBST(root);
    }

    private boolean isBST(Node node) {
        boolean result = true;
        if (node.left != null && result) {
            if (node.data <= node.left.data) {
                result = false;
            }
            result = isBST(node.right);
        }
        if (node.right != null && result) {
            if (node.data >= node.right.data) {
                result = false;
            }
            result = isBST(node.right);
        }
        return result;
    }

    public void get_inorder(Vector values) {
        inorder(root, values);
    }

    private void inorder(Node node, Vector values) {
        if (node.left != null) {
            inorder(node.left, values);
        }
        values.add(node.data);
        if (node.right != null) {
            inorder(node.right, values);
        }
    }

    public boolean isBinarySearchTreeIterative() {
        Vector<Integer> values = new Vector();
        get_inorder(values);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i - 1) > values.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean find_path(int target, Vector<Node> path) {
        return findPath(root, target, path);
    }

    private boolean findPath(Node node, int target, Vector<Node> path) {
        path.add(node);
        if (node.data == target) {
            return true;
        }
        if (target > node.data) {
            return node.right != null && findPath(node.right, target, path);
        }
        return node.left != null && findPath(node.left, target, path);
    }

    public Node get_next(Vector<Node> ancestors) {
        if (ancestors.isEmpty()) {
            return null;
        }
        Node node = ancestors.lastElement();
        ancestors.remove(node);
        return node;
    }

    public int successor(int target) {
        Vector<Node> path = new Vector<>();
        find_path(target, path);
        Node node = get_next(path);
        if (node.right != null) {
            return minTree(node.right).data;
        }
        Node parent = get_next(path);
        while (parent != null && parent.right == node) {
            node = parent;
            parent = get_next(path);
        }
        if (parent != null) {
            return parent.data;
        }
        return -1;
    }

    public int predecessor(int target) {
        Vector<Node> path = new Vector<>();
        find_path(target, path);
        Node node = get_next(path);
        if (node.left != null) {
            return minTree(node.left).data;
        }
        Node parent = get_next(path);
        while (parent != null && parent.left == node) {
            node = parent;
            parent = get_next(path);
        }
        if (parent != null) {
            return parent.data;
        }
        return -1;
    }

    public int maxTree(Node node) {
        Node current = node;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public Node deleteNode(int target, Node node) {
        if (target == node.data && node.left == null && node.right == null) {
            return null;
        }
        return delete(target, node);
    }

    private Node delete(int target, Node node) {
        if (node == null) {
            return null;
        }
        if (target > node.data) {//go left
            node.right = delete(target, node.right);
        } else if (target < node.data) {//go right
            node.left = delete(target, node.left);
        } else {//found it
            Node temp = node;
            if (node.right == null && node.left == null) {//no child 
                node = null;
            } else if (node.right == null) {//have a left child
                node = node.left;
            } else if (node.left == null) {//have a right child
                node = node.right;
            } else {//have  2 children,get successor and delete node
                Node min = minTree(node.right);
                node.data = min.data;
                node.right = delete(node.data, node.right);
                temp = null;
            }
            if (temp != null) {
                temp = null;
            }
        }
        return node;
    }

    public void emptyLine() {
        System.out.println("");
    }
}

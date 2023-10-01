package tree;

import java.util.Vector;

public class BST {

    public BST left;
    public BST right;
    public int data;

    public BST(int data, BST left, BST right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BST(int data) {
        this(data, null, null);
    }

    public void insert(int value) {

        if (value > data) {
            if (right == null) {
                right = new BST(value);
            } else {
                right.insert(value);
            }
        }
        if (value < data) {
            if (left == null) {
                left = new BST(value);
            } else {
                left.insert(value);
            }
        }
    }

    public int min() {
        if (left != null) {
            left.min();
        } else {
            return data;
        }
        return left.min();
    }

    public int kth_smallest(int k) {

        return 0;

    }

    public boolean search(int value) {
        boolean result = value == data;
        if (value > data && !result && right != null) {
            result = right.search(value);
        }
        if (value < data && !result && left != null) {
            result = left.search(value);
        }
        return result;
    }

    public boolean search1(int value) {
        if (value == data) {
            return true;
        }
        if (value < data) {
            return left != null && left.search(value);
        }
        return right != null && right.search(value);
    }

    public boolean search2(int value) {
        BST node = this;
        while (node != null) {
            if (node.data == value) {
                return true;
            }
            if (value > node.data) {
                node = node.right;
            }
            if (value < node.data) {
                node = node.left;
            }
        }
        return false;
    }

    public void search_and_getPath(int value, Vector<Integer> path) {
        BST node = this;
        while (node != null) {
            path.add(node.data);
            if (node.data == value) {
                return;
            }
            if (value > node.data) {
                node = node.right;
            }
            if (value < node.data) {
                node = node.left;
            }

        }
    }

    public int lowestCommonAncestor(int x, int y) {
        if (x < data && y < data) {
            return left.lowestCommonAncestor(x, y);
        }

        if (x > data && y > data) {
            return right.lowestCommonAncestor(x, y);
        }

        return data;
    }

    public boolean isBinarySearchTree() {
        boolean result = true;
        if (left != null && result) {
            if (data <= left.data) {
                result = false;
            }
            result = left.isBinarySearchTree();
        }
        if (right != null && result) {
            if (data >= right.data) {
                result = false;
            }
            result = right.isBinarySearchTree();
        }
        return result;
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

    public boolean isBinarySearchTree2(int minValue, int maxValue) {
        if (data < minValue || data > maxValue) {
            return false;
        }

        if (left != null && !left.isBinarySearchTree2(minValue, data - 1)) {
            return false;
        }

        if (right != null && !right.isBinarySearchTree2(data + 1, maxValue)) {
            return false;
        }
        return true;
    }

    public void get_inorder(Vector values) {
        if (left != null) {
            left.get_inorder(values);
        }
        values.add(data);
        if (right != null) {
            right.get_inorder(values);
        }
    }

    public void get_inorder() {
        if (left != null) {
            left.get_inorder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.get_inorder();
        }
    }

    public BST get_min() {
        BST current = this;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    public boolean find_path(int target, Vector<BST> path) {
        path.add(this);
        if (data == target) {
            return true;
        }
        if (target > data) {
            return right != null && right.find_path(target, path);
        }
        return left != null && left.find_path(target, path);
    }

    public BST get_next(Vector<BST> ancestors) {
        if (ancestors.isEmpty()) {
            return null;
        }
        BST node = ancestors.lastElement();
        ancestors.remove(node);
        return node;
    }

    public int successor(int target) {
        Vector<BST> path = new Vector<>();
        find_path(target, path);
        BST node = get_next(path);
        if (node.right != null) {
            return get_min(node.right);
        }
        BST parent = get_next(path);
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
        Vector<BST> path = new Vector<>();
        find_path(target, path);
        BST node = get_next(path);
        if (node.left != null) {
            return get_max(node.left);
        }
        BST parent = get_next(path);
        while (parent != null && parent.left == node) {
            node = parent;
            parent = get_next(path);
        }
        if (parent != null) {
            return parent.data;
        }
        return -1;
    }

    public int get_min(BST node) {
        BST current = node;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public int get_max(BST node) {
        BST current = node;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public void emptyLine() {
        System.out.println("\n----------------------------");
    }

    public BST delete(int target, BST node) {
        if (node == null) {
            return null;
        }
        if (target > node.data) {//go left
            node.right = delete(target, node.right);
        } else if (target < node.data) {//go right
            node.left = delete(target, node.left);
        } else {//found it
            BST temp = node;
            if (node.right == null && node.left == null) {//no child 
                node = null;
            } else if (node.right == null) {//have a left child
                node.specialDelete(node.left);
            } else if (node.left == null) {//have a right child
                node.specialDelete(node.right);
            } else {//have  2 children,get successor and delete node
                BST min = node.right.get_min();
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

    public BST deleteNode(int target) {
        if (target == data && left == null && right == null) {
            return null;
        }
        return delete(target, this);
    }
    private void specialDelete(BST node){
        data=node.data;
        left=node.left;
        right=node.right;
        node=null;
    }

}

package tree;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;
import queue.queue;

public class BinaryTree {

    private int data;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
    }

    public void levelOrderTraversal() {
        int level = 0;
        queue<BinaryTree> que=new queue<>(4);
        que.enqueue(this);
        while (!que.isEmpty()) {
            int size = que.count();
            System.out.print("Level " + level+" : ");
            while (size > 0) {
                BinaryTree curr = (BinaryTree) que.frontQueue();
                que.dequeue();
                System.out.print(" " + curr.data);
                if (curr.left != null) {
                    que.enqueue(curr.left);
                }
                if (curr.right != null) {
                    que.enqueue(curr.right);
                }
                size--;
            }
            level++;
            System.out.println();
        }
    }

    public boolean is_exists(int value) {
        boolean result = data == value;//false, 
        if (!result && left != null) {
            result = left.is_exists(value);
        }
        if (!result && right != null) {
            result = right.is_exists(value);
        }
        return result;
    }

    public void add(Vector<Integer> values, Vector<Character> direction) {
        assert values.size() == direction.size();
        BinaryTree current = this;
        for (int i = 0; i < values.size(); i++) {
            if (direction.get(i) == 'L') {
                if (current.left == null) {
                    current.left = new BinaryTree(values.get(i));
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new BinaryTree(values.get(i));
                }
                current = current.right;
            }
        }
    }

    public int tree_max() {
        int res = data;//2
        if (left != null) {
            res = Math.max(res, left.tree_max());//2,3=3   -13,7=13
        }
        if (right != null) {
            res = Math.max(res, right.tree_max());//2,13=13  -13,8=13
        }
        return res;
    }

    public int tree_height(BinaryTree curr) {
        if (curr == null) {
            return 0;
        }
        int LH = tree_height(curr.left);
        int RH = tree_height(curr.right);
        return Math.max(LH, RH) + 1;
    }

    public int tree_height1() {
        int height = 0;
        if (left != null) {
            height = 1 + left.tree_height1();//or height =Math.max(height, 1 + left.tree_height1())
        }
        if (right != null) {
            height = Math.max(height, 1 + right.tree_height1());
        }
        return height;
    }

    public int tree_min() {
        int res = data;//2
        if (left != null) {
            res = Math.min(res, left.tree_max());//2,3=2   -2,7=2
        }
        if (right != null) {
            res = Math.min(res, right.tree_max());//2,13=2  -2,8=2
        }
        return res;
    }

    public int total_nodes() {
        int count = 1;

        if (left != null) {
            count += left.total_nodes();
        }
        if (right != null) {
            count += right.total_nodes();
        }
        return count;
    }

    public int total_leaf_nodes() {
        int count = (right == null && left == null) ? 1 : 0;
        if (left != null) {
            count += left.total_leaf_nodes();
        }
        if (right != null) {
            count += right.total_leaf_nodes();
        }
        return count;
    }

    public boolean is_perfect() {
        int nodeNumbers = (int) (Math.pow(2, tree_height1() + 1) - 1);
        return nodeNumbers == total_nodes();
    }

    //left value right
    public void in_order() {
        if (left != null) {
            left.in_order();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.in_order();
        }
    }

    //left right value
    public void post_order() {
        if (left != null) {
            left.post_order();
        }
        if (right != null) {
            right.post_order();
        }
        System.out.print(data + " ");
    }

    //value left right
    public void pre_order() {
        System.out.print(data + " ");
        if (left != null) {
            left.pre_order();
        }
        if (right != null) {
            right.pre_order();
        }
    }

    public boolean checkTree(BinaryTree root) {
        return (root.left != null && root.right != null) && (root.left.data + root.right.data == root.data);
    }
}

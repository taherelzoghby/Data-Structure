package tree;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
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
//get tree from inOrder and preOrder

    public BinaryTree(Deque<Integer> inOrder, Deque<Integer> preOrder, int startInorder, int endInorder) {
        if (endInorder == -1) {
            endInorder = inOrder.size() - 1;
        }
        data = preOrder.getFirst();
        preOrder.pollFirst();
        for (int i = startInorder; i <= endInorder; i++) {
            if (data == (int) getElementDeque(inOrder, i)) {
                if (startInorder < i) {
                    left = new BinaryTree(inOrder, preOrder, startInorder, i - 1);
                }
                if (endInorder > i) {
                    right = new BinaryTree(inOrder, preOrder, i + 1, endInorder);
                }
                break;
            }
        }

    }

    public int getElementDeque(Deque q, int index) {
        Iterator it = q.iterator();
        int count = 0;
        while (it.hasNext()) {
            int object = (int) it.next();
            if (count == index) {
                return object;
            }
        }
        return 0;
    }

    public void levelOrderTraversal() {
        int level = 0;
        Queue<BinaryTree> que = new LinkedList<>();
        que.add(this);
        while (!que.isEmpty()) {
            int size = que.size();
            System.out.print("Level " + level + " : ");
            while (size > 0) {
                BinaryTree curr = (BinaryTree) que.peek();
                que.remove();
                System.out.print(" " + curr.data);
                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }
                size--;
            }
            level++;
            System.out.println();
        }
    }

    public void level_order_traversal_recursive() {
        int h = tree_height1();
        for (int i = 0; i <= h; i++) {
            System.out.print("level " + i + " : ");
            print_level_order(i);
            System.out.println();
        }

    }

    public void print_level_order(int level) {
        if (level == 0) {
            System.out.print(data + " ");
        } else {
            if (left != null) {
                left.print_level_order(level - 1);
            }
            if (right != null) {
                right.print_level_order(level - 1);
            }
        }
    }

    public void level_order_traversal_spiral() {
        int level = 0;
        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.add(this);//2
        while (!queue.isEmpty()) {
            int size = queue.size();//1->2
            System.out.print("level " + level + " : ");
            while (size > 0) {
                BinaryTree current;
                if (level % 2 == 0) {
                    current = (BinaryTree) queue.getFirst();
                    queue.removeFirst();
                    if (current.left != null) {
                        queue.addLast(current.left);
                    }
                    if (current.right != null) {
                        queue.addLast(current.right);
                    }
                } else {
                    current = (BinaryTree) queue.getLast();
                    queue.removeLast();
                    if (current.right != null) {
                        queue.addFirst(current.right);
                    }
                    if (current.left != null) {
                        queue.addFirst(current.left);
                    }
                }
                System.out.print(current.data + " ");
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

    public int tree_max() {//o(n) ,worst if tree unBalanced :o(n^2) 
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

    public int total_nonLeaf_nodes() {
        int count = (right == null && left == null) ? 0 : 1;
        if (left != null) {
            count += left.total_nonLeaf_nodes();
        }
        if (right != null) {
            count += right.total_nonLeaf_nodes();
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

    ////////////////////////////////////////////
    public void print_preorder_complete() {
        System.out.print(data + " ");
        if (left != null) {
            left.print_preorder_complete();
        } else {
            System.out.print(" () ");
        }
        if (right != null) {
            right.print_preorder_complete();
        } else {
            System.out.print(" () ");
        }
    }

    public String print_parenthsizing() {
        String result = "(" + data;
        if (left != null) {
            result += left.print_parenthsizing();
        } else {
            result += "()";
        }

        if (right != null) {
            result += right.print_parenthsizing();

        } else {
            result += "()";
        }
        result += ")";
        return result;
    }

    public String parenthsizing_Canonicalizing() {
        String result = "(" + data;
        Vector<String> q = new Vector<>();
        if (left != null) {
            q.add(left.print_parenthsizing());
        } else {
            result += "()";
        }

        if (right != null) {
            q.add(right.print_parenthsizing());
        } else {
            result += "()";
        }
        Collections.sort(q);
        result = result.concat(merge(q));
        result += ")";
        return result;
    }

    public String merge(Vector<String> vector) {
        String result = "";
        for (int i = 0; i < vector.size(); i++) {
            result += vector.get(i);
        }
        return result;
    }

    public boolean isIdentical1(String tree1, String tree2) {
        return tree1.equals(tree2);
    }

    public boolean isIdentical2() {

        return false;
    }
}

package AvlTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        //System.out.println(tree.predecessor(1));
        tree.inOrder();
        tree.preOrder();
        tree.postOrder();
//        Map<Integer, String> nums = new HashMap<>();
//        nums.put(0, "Taher");
//        nums.put(1, "Ahmed");
//        nums.put(2, "Mohamed");
//        nums.put(3, "Ebrahim");
//        nums.put(4, "abbas");
//        for (Map.Entry<Integer, String> i : nums.entrySet()) {
//            int key = i.getKey();
//            String value = i.getValue();
//            System.out.println(key + " " + value);
//        }
//        System.out.println("");

    }

}

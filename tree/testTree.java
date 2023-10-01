
package tree;
import java.util.Vector;
public class testTree {

    public testTree() {
    }

    public BST buid_Balanced_Binary_search_tree(Vector<Integer> values, int startInorder, int endInorder) {
        if (endInorder == -10) {
            endInorder = values.size() - 1;
        }
        if (startInorder > endInorder) {
            return null;
        }
        int midIndex = (startInorder + endInorder) / 2;
        BST left = buid_Balanced_Binary_search_tree(values, startInorder, midIndex - 1);
        BST right = buid_Balanced_Binary_search_tree(values, midIndex + 1, endInorder);
        BST root = new BST(values.get(midIndex), left, right);
        return root;
    }
}

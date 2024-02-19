/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AvlTree;
public class NodeTree {

    public int data;
    public int height;
    public NodeTree left;
    public NodeTree right;

    public NodeTree(int data) {
        this.data = data;
    }

    public int childHeight(NodeTree node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public int updateHeight() {
        return height = 1 + Math.max(childHeight(left), childHeight(right));
    }

    public int balanceFactor() {
        return childHeight(left) - childHeight(right);
    }
}

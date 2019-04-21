/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like;

import basic.TreeTest;
import basic.TreeTest.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author HieuDucNguyen
 */
public class InvertBinTree {

    public static Queue<TreeNode> queue = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(2);
        TreeNode node31 = new TreeNode(5);
        node0.left = node11;
        node0.right = node12;
        node11.left = node31;
        TreeNode node = process(node0);
        TreeTest.printTree(node);
    }

    private static TreeNode process(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode node = new TreeNode(root.val);
        queue.add(node);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node2.left != null) {
                TreeNode nodeL = node2.left;
                TreeNode nodeL2 = new TreeNode(nodeL.val);
                node1.right = nodeL2;
                queue.add(nodeL2);
                queue.add(nodeL);
            }
            if (node2.right != null) {
                TreeNode nodeR = node2.right;
                TreeNode nodeR2 = new TreeNode(nodeR.val);
                node1.left = nodeR2;
                queue.add(nodeR2);
                queue.add(nodeR);
            }
        }
        return node;
    }
}

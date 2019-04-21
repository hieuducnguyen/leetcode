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
public class MergeTwoBinTree {

    static Queue<TreeNode> queue = new LinkedList<>();
    static TreeNode nodeNull = new TreeNode(0);

    private static TreeNode process(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val1 = t1 != null ? t1.val : 0;
        int val2 = t2 != null ? t2.val : 0;
        TreeNode node = new TreeNode(val1 + val2);
        queue.add(node);
        queue.add(t1 != null ? t1 : nodeNull);
        queue.add(t2 != null ? t2 : nodeNull);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            TreeNode node3 = queue.poll();
            if (node2.left != null || node3.left != null) {
                TreeNode nodeLeft1 = node2.left;
                TreeNode nodeLeft2 = node3.left;
                int left1 = nodeLeft1 != null ? nodeLeft1.val : 0;
                int left2 = nodeLeft2 != null ? nodeLeft2.val : 0;
                TreeNode subNodeLeft = new TreeNode(left1 + left2);
                node1.left = subNodeLeft;
                queue.add(subNodeLeft);
                queue.add(nodeLeft1 != null ? nodeLeft1 : nodeNull);
                queue.add(nodeLeft2 != null ? nodeLeft2 : nodeNull);
            }
            if (node2.right != null || node3.right != null) {
                TreeNode nodeRight1 = node2.right;
                TreeNode nodeRight2 = node3.right;
                int right1 = nodeRight1 != null ? nodeRight1.val : 0;
                int right2 = nodeRight2 != null ? nodeRight2.val : 0;
                TreeNode subNodeRight = new TreeNode(right1 + right2);
                node1.right = subNodeRight;
                queue.add(subNodeRight);
                queue.add(nodeRight1 != null ? nodeRight1 : nodeNull);
                queue.add(nodeRight2 != null ? nodeRight2 : nodeNull);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(1);
        TreeNode t21 = new TreeNode(3);
        TreeNode t31 = new TreeNode(2);
        TreeNode t41 = new TreeNode(5);
        t11.left = t21;
        t11.right = t31;
        t21.left = t41;

        TreeNode t12 = new TreeNode(2);
        TreeNode t22 = new TreeNode(1);
        TreeNode t32 = new TreeNode(3);
        TreeNode t52 = new TreeNode(4);
        TreeNode t72 = new TreeNode(7);
        t12.left = t22;
        t12.right = t32;
        t22.right = t52;
        t32.right = t72;
        TreeNode node = process(t11, t12);
        String tree = TreeTest.printTree(node);
        System.out.println("tree: " + tree);
    }
}

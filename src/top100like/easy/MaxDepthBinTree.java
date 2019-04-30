/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

/**
 *
 * @author HieuDucNguyen
 */
public class MaxDepthBinTree {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return (Math.max(process(node.left), process(node.right)) + 1);

    }

    public static void main(String[] args) {

    }
}

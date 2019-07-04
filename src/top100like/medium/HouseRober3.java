/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import basic.TreeTest.TreeNode;

/**
 *
 * @author hieund3
 */
public class HouseRober3 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node4.right = node7;
		node5.left = node8;

		int money = process(node1);
		System.out.println("money: " + money);
	}

	private static int process(TreeNode node) {
		return rob(node);
	}

	private static int rob(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.val;
		}
		int max1 = rob(node.left) + rob(node.right);
		int left = 0;
		if (node.left != null) {
			left = rob(node.left.left) + rob(node.left.right);
		}
		int right = 0;
		if (node.right != null) {
			right = rob(node.right.left) + rob(node.right.right);
		}
		int max2 = node.val + left + right;
		return Math.max(max1, max2);
	}
}

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
public class FlattenBTreeToList {

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
//		node3.right = node6;
//		node4.right = node7;
//		node5.left = node8;

		flatten(node1);
		String printTree = basic.TreeTest.printTree(node1);
		System.out.println(printTree);
	}

	private static void process(TreeNode node) {
		if (node == null || node.left == null && node.right == null) {
			return;
		}
		getLastRightNode(node);
	}

	private static TreeNode getLastRightNode(TreeNode node) {
		if (node.left == null && node.right == null) {
			return node;
		}
		TreeNode right = node.right;
		TreeNode lastRight = null;
		if (node.left != null) {
			node.right = node.left;
			node.left = null;
			lastRight = getLastRightNode(node.right);
			lastRight.right = right;
		}
		if (right != null) {
			return getLastRightNode(right);
		} else {
			return lastRight;
		}
	}

	public static void flatten(TreeNode root) {
		if (root != null) {
			flatten(root.left);
			flatten(root.right);
			if (root.left != null) {
				TreeNode tmpRight = root.right;
				root.right = root.left;
				root.left = null;
				TreeNode node = root.right;
				while (node.right != null) {
					node = node.right;
				}
				node.right = tmpRight;
			}
		}
	}
}

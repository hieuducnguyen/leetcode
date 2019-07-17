/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import basic.TreeTest.TreeNode;
import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class BST2GreaterTree {

	static int sum = 0;

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(-2);
		TreeNode node5 = new TreeNode(3);
//		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(3);
		TreeNode node8 = new TreeNode(5);

		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node3.left = node5;
//		node3.right = node6;
//		node4.right = node7;
//		node5.left = node8;
		TreeNode node = convertBST3(node1);
		String printTree = basic.TreeTest.printTree(node);
		System.out.println(printTree);
	}

	private static TreeNode convertBST(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode newNode = new TreeNode(0);
		int value = convertToGreaterTree(node, 0, newNode);
		return newNode;
	}

	private static int convertToGreaterTree(TreeNode node, int greater, TreeNode newNode) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			newNode.val = (node.val + greater);
			return newNode.val;
		}
		int value = 0;
		if (node.right != null) {
			TreeNode rightNewNode = new TreeNode(0);
			newNode.right = rightNewNode;
			value += convertToGreaterTree(node.right, greater, rightNewNode);
		}
		value += node.right != null ? node.val : node.val + greater;
		newNode.val = value;
		if (node.left != null) {
			TreeNode leftNewNode = new TreeNode(0);
			newNode.left = leftNewNode;
			value = convertToGreaterTree(node.left, value, leftNewNode);
		}
		return value;
	}

	public static TreeNode convertBST1(TreeNode root) {
		if (root == null || root.left == null || root.right == null) {
			return root;
		}
		TreeNode newRoot = new TreeNode(0);
		convertBST(root, newRoot, 0);
		return newRoot;
	}

	static int convertBST(TreeNode node, TreeNode newNode, int greater) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			newNode.val = node.val + greater;
			return newNode.val;
		}
		int value = 0;
		if (node.right != null) {
			TreeNode newRightNode = new TreeNode(0);
			newNode.right = newRightNode;
			value = convertBST(node.right, newRightNode, greater);
		}
		value = node.right != null ? node.val + value
			: node.val + greater;
		newNode.val = value;
		if (node.left != null) {
			TreeNode newLeftNode = new TreeNode(0);
			newNode.left = newLeftNode;
			value = convertBST(node.left, newLeftNode, value);
		}
		return value;
	}

	static TreeNode convertBST2(TreeNode node) {
		if (node != null) {
			convertBST2(node.right);
			sum += node.val;
			node.val = sum;
			convertBST2(node.left);
		}
		return node;
	}

	static TreeNode convertBST3(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		stack.add(node);
		while (!stack.isEmpty()) {
			TreeNode tmpNode = stack.pop();
			if (tmpNode != null) {
				stack.add(tmpNode.left);
				stack.add(tmpNode);
				stack.add(tmpNode.right);
			} else if (tmpNode == null && !stack.isEmpty()) {
				TreeNode travelNode = stack.pop();
				sum += travelNode.val;
				travelNode.val = sum;
			}
		}
		return node;
	}

	static TreeNode convertBST4(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tmpNode = node;
		while (tmpNode != null || !stack.isEmpty()) {
			while (tmpNode != null) {
				stack.add(tmpNode);
				tmpNode = tmpNode.right;
			}
			TreeNode travelNode = stack.pop();
			sum += travelNode.val;
			travelNode.val = sum;
			tmpNode = travelNode.left;
		}
		return node;
	}
}

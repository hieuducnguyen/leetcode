/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import basic.TreeTest;
import basic.TreeTest.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author HieuDucNguyen
 */
public class InvertBinTree {

	public static Queue<TreeNode> queue = new LinkedList<>();

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		TreeNode node = process(node1);
		String printTree = TreeTest.printTree(node);
		System.out.println(printTree);
	}

	private static TreeNode process(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode tmpNode = stack.pop();
			if (tmpNode != null) {
				TreeNode left = tmpNode.left;
				tmpNode.left = tmpNode.right;
				tmpNode.right = left;
				stack.add(tmpNode.left);
				stack.add(tmpNode.right);
			}
		}
		return root;
	}
}

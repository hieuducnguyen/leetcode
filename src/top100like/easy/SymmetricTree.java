/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import basic.TreeTest.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author hieund3
 */
public class SymmetricTree {

	static Queue<TreeNode> queue = new LinkedList<>();

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode node11 = new TreeNode(2);
		TreeNode node12 = new TreeNode(2);
		TreeNode node22 = new TreeNode(3);
		TreeNode node24 = new TreeNode(3);
		node.left = node11;
		node.right = node12;
		node11.right = node22;
		node11.left = null;
		node12.right = node24;
		node12.left = null;
		boolean isSymmetric = process1(node);
		System.out.println("isSymmetric: " + isSymmetric);
	}

	private static boolean process(TreeNode node) {
		if (node == null || (node.left == null && node.right == null)) {
			return true;
		}
		queue.add(node.left);
		queue.add(node.right);
		while (!queue.isEmpty()) {
			TreeNode firstNode = queue.poll();
			TreeNode secondNode = queue.poll();
			if (firstNode == null && secondNode == null) {
				continue;
			}
			if (firstNode == null || secondNode == null) {
				return false;
			}
			if (firstNode.val != secondNode.val) {
				return false;
			}
			queue.add(firstNode.left);
			queue.add(secondNode.right);

			queue.add(firstNode.right);
			queue.add(secondNode.left);
		}
		return true;
	}

	private static boolean process1(TreeNode node) {
		if (node == null || (node.left == null && node.right == null)) {
			return true;
		}
		return isSymmetric(node.left, node.right);
	}

	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}

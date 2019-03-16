/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package heap;

import java.util.LinkedList;

/**
 *
 * @author hieund3
 */
public class SymmetricTree {

	private static boolean process(TreeNode r0) {
		if (r0 == null || (r0.left == null && r0.right == null)) {
			return true;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(r0);
		while (!queue.isEmpty()) {
			LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>(queue);
			queue = new LinkedList<TreeNode>();
			while (!queue2.isEmpty()) {
				TreeNode node = queue2.poll();

			}
		}
		return false;
	}

	private static boolean process2(TreeNode r0) {
		if (r0 == null || r0.left == null && r0.right == null) {
			return true;
		}
		return recurSymmetric(r0.left, r0.right);
	}

	private static boolean recurSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return (left.val == right.val) && recurSymmetric(left.left, right.right) && recurSymmetric(left.right, right.left);
	}

	public static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode r0 = new TreeNode(1);
		TreeNode r11 = new TreeNode(2);
		TreeNode r12 = new TreeNode(2);
		TreeNode r21 = new TreeNode(3);
		TreeNode r22 = new TreeNode(4);
		TreeNode r23 = new TreeNode(4);
		TreeNode r24 = new TreeNode(3);

		r0.left = r11;
		r0.right = r12;
		r11.left = r21;
		r11.right = r22;
		r12.left = r23;
		r12.right = r24;

		boolean ret = process2(r0);
		System.out.println("ret: " + ret);
	}
}

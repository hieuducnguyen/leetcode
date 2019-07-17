/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class PathSumIII {

	private static int process(TreeNode a, int i) {
		if (a == null) {
			return 0;
		}
		if (a.val == i) {
			int left = process(a.left, 0);
			int right = process(a.right, 0);
			return 1 + left + right;
		} else {
			int left = process(a.left, i - a.val);
			int right = process(a.right, i - a.val);
			return left + right;
		}
	}

	private static int pathSum(TreeNode root, int sum, int sum0) {
		if (root == null) {
			return 0;
		}
		if (root.val == sum) {
			System.out.println(root);
			return 1 + pathSum(root.left, sum0, sum0)
				+ pathSum(root.right, sum0, sum0)
				+ pathSum(root.left, 0, sum0)
				+ pathSum(root.right, 0, sum0);
		} else {
			return pathSum(root.right, sum - root.val, sum0)
				+ pathSum(root.left, sum - root.val, sum0)
				+ pathSum(root.right, sum0, sum0)
				+ pathSum(root.left, sum0, sum0);
		}
	}

	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			String leftValue = left != null ? String.valueOf(left.val) : "null";
			String rightValue = right != null ? String.valueOf(right.val) : "null";
			return String.format("val: %s right: %s left %s", val, rightValue, leftValue);
		}

	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(11);
		TreeNode g = new TreeNode(3);
		TreeNode h = new TreeNode(-2);
		TreeNode k = new TreeNode(1);
		TreeNode l = new TreeNode(11);
//		a.left = b;
		a.right = b;
//		b.left = d;
		b.right = c;
//		d.left = g;
		c.right = d;
		d.right = e;
//		c.right = f;
//		f.right = l;
		int numPath = pathSum(a, 3);
		System.out.println("numPath: " + numPath);
	}

	private static int preProcess(TreeNode a, int sum) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(a);
		int numPath = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				queue.add(node.left);
				queue.add(node.right);
			}
			numPath += process(node, sum);
		}
		return numPath;
	}

	private static int countPath(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}
		if (node.val == sum) {
			return 1 + countPath(node.left, 0)
				+ countPath(node.right, 0);
		} else {
			return countPath(node.left, sum - node.val)
				+ countPath(node.right, sum - node.val);
		}
	}

	private static int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		int numPath = 0;
		while (!stack.isEmpty()) {
			TreeNode tmpNode = stack.pop();
			if (tmpNode != null) {
				numPath += countPath(tmpNode, sum);
				stack.add(tmpNode.left);
				stack.add(tmpNode.right);
			}
		}
		return numPath;
	}
}

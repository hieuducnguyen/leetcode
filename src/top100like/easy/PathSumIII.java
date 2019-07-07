/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.easy;

import java.util.LinkedList;
import java.util.Queue;

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

	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(-3);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(11);
		TreeNode g = new TreeNode(3);
		TreeNode h = new TreeNode(-2);
		TreeNode k = new TreeNode(1);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		d.left = g;
		d.right = h;
		e.right = k;
		c.right = f;
		int numPath = preProcess(a, 8);
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
}

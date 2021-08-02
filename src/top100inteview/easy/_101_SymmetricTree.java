package top100inteview.easy;

import basic.TreeTest.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Created by hieund3 on 04/07/2021
 */
public class _101_SymmetricTree {
	public static final _101_SymmetricTree INSTANCE = new _101_SymmetricTree();

	public boolean isSymmetric(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		if (root == null || root.left == null && root.right == null) {
			return true;
		}
		if (root.left == null || root.right == null) {
			return false;
		}
		stack.push(root.left);
		stack.push(root.right);
		while (!stack.isEmpty()) {
			TreeNode left = stack.pop();
			TreeNode right = stack.pop();
			if (left.val != right.val) {
				return false;
			}
			if (left.left != null && right.right != null) {
				stack.push(left.left);
				stack.push(right.right);
			} else if (left.left != null || right.right != null) {
				return false;
			}
			if (left.right != null && right.left != null) {
				stack.push(left.right);
				stack.push(right.left);
			} else if (left.right != null || right.left != null) {
				return false;
			}
		}
		return true;
	}
}

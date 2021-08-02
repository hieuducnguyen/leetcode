package top100inteview.easy;

import basic.TreeTest.TreeNode;

import java.util.*;

/*
 * Created by hieund3 on 04/07/2021
 */
public class _144_BinaryTreePreorderTraversal {
	public static final _144_BinaryTreePreorderTraversal INSTANCE = new _144_BinaryTreePreorderTraversal();

	public List<Integer> preorderTraversal(TreeNode root) {
		final List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				result.add(p.val);
				p = p.left;
			} else {
				final TreeNode pop = stack.pop();
				p = pop.right;
			}
		}
		return result;
	}

	public List<Integer> preorderTraversalIteratively1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			final TreeNode pop = stack.pop();
			if (pop != null) {
				result.add(pop.val);
				stack.push(pop.right);
				stack.push(pop.left);
			}
		}
		return result;
	}

	public List<Integer> preorderTraversalRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root != null) {
			result.add(root.val);
			final List<Integer> leftList = preorderTraversalRecursive(root.left);
			result.addAll(leftList);
			final List<Integer> rightList = preorderTraversalRecursive(root.right);
			result.addAll(rightList);
		}
		return result;
	}
}

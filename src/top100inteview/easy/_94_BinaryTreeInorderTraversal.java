package top100inteview.easy;

import basic.TreeTest.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Created by hieund3 on 03/07/2021
 */
public class _94_BinaryTreeInorderTraversal {
	public static final _94_BinaryTreeInorderTraversal INSTANCE = new _94_BinaryTreeInorderTraversal();

	class NodeStruct {
		TreeNode node;
		boolean travel;

		public NodeStruct(TreeNode node, boolean travel) {
			this.node = node;
			this.travel = travel;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			final TreeNode node = stack.pop();
			if (node != null) {
				stack.push(node.right);
				stack.push(node);
				stack.push(node.left);
			} else if (!stack.isEmpty()) {
				final TreeNode innerNode = stack.pop();
				result.add(innerNode.val);
			}
		}
		return result;
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<NodeStruct> stack = new Stack<>();
		stack.push(new NodeStruct(root, false));
		while (!stack.isEmpty()) {
			final NodeStruct pop = stack.pop();
			if (pop.node != null) {
				if (pop.travel || pop.node.left == null && pop.node.right == null) {
					result.add(pop.node.val);
				} else {
					stack.push(new NodeStruct(pop.node.right, false));
					stack.push(new NodeStruct(pop.node, true));
					stack.push(new NodeStruct(pop.node.left, false));
				}

			}
		}
		return result;
	}

	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inorderTraversal(root, result);
		return result;
	}

	private void inorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, result);
		result.add(root.val);
		inorderTraversal(root.right, result);
	}
}

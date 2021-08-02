package tree;

import basic.TreeTest.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Created by hieund3 on 30/07/2021
 */
public class _144_BinaryTreePreorderTraversal {
	public static final _144_BinaryTreePreorderTraversal INSTANCE = new _144_BinaryTreePreorderTraversal();

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		TreeNode tmpNode = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (tmpNode != null || !stack.isEmpty()) {
			if (tmpNode != null) {
				result.add(tmpNode.val);
				stack.addLast(tmpNode);
				tmpNode = tmpNode.left;
			} else {
				final TreeNode treeNode = stack.removeLast();
				tmpNode = treeNode.right;
			}
		}
		return result;
	}
}

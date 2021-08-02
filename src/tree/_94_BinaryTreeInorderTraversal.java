package tree;

import basic.TreeTest.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Created by hieund3 on 30/07/2021
 */
public class _94_BinaryTreeInorderTraversal {
	public static final _94_BinaryTreeInorderTraversal INSTANCE = new _94_BinaryTreeInorderTraversal();

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		TreeNode tmpNode = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (tmpNode != null || !stack.isEmpty()) {
			if (tmpNode != null) {
				stack.addLast(tmpNode);
				tmpNode = tmpNode.left;
			} else {
				final TreeNode last = stack.pollLast();
				result.add(last.val);
				tmpNode = last.right;
			}
		}
		return result;
	}
}

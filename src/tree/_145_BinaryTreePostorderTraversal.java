package tree;

import basic.TreeTest.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Created by hieund3 on 30/07/2021
 */
public class _145_BinaryTreePostorderTraversal {
	public static final _145_BinaryTreePostorderTraversal INSTANCE = new _145_BinaryTreePostorderTraversal();

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		TreeNode tmpNode = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (tmpNode != null || !stack.isEmpty()) {
			if (tmpNode != null) {
				result.add(0, tmpNode.val);
				stack.addLast(tmpNode);
				tmpNode = tmpNode.right;
			} else {
				final TreeNode treeNode = stack.removeLast();
				tmpNode = treeNode.left;
			}
		}
		return result;
	}
}

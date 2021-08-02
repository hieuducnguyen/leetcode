package top100inteview.easy;

import basic.TreeTest.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Created by hieund3 on 04/07/2021
 */
public class _145_BinaryTreePostorderTraversal {
	public static final _145_BinaryTreePostorderTraversal INSTANCE = new _145_BinaryTreePostorderTraversal();

	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				result.addFirst(p.val);
				p = p.right;
			} else {
				final TreeNode pop = stack.pop();
				p = pop.left;
			}
		}
		return result;
	}
}

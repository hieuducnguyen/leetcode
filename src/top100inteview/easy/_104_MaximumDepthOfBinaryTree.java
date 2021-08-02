package top100inteview.easy;

import basic.TreeTest.TreeNode;

/*
 * Created by hieund3 on 05/07/2021
 */
public class _104_MaximumDepthOfBinaryTree {
	public static final _104_MaximumDepthOfBinaryTree INSTANCE = new _104_MaximumDepthOfBinaryTree();

	public int maxDepth(TreeNode root) {
		if (root != null) {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		} else {
			return 0;
		}
	}
}

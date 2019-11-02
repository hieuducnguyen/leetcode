/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.hard;

import basic.TreeTest.TreeNode;

/**
 *
 * @author hieund3
 */
public class BinaryTreeMaxPathSum {

	public static final BinaryTreeMaxPathSum INSTANCE = new BinaryTreeMaxPathSum();

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(-2);
		TreeNode node3 = new TreeNode(-3);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(-2);
		TreeNode node7 = new TreeNode(-1);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		int maxPathSum = INSTANCE.maxPathSum(node1);
		System.out.println(maxPathSum);
	}

	public int maxPathSumEachNode(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		int maxPathLeft = maxPathSumEachNode(root.left);
		int maxPathRight = maxPathSumEachNode(root.right);

		return root.val + (maxPathLeft >= 0 ? maxPathLeft : 0) + (maxPathRight >= 0 ? maxPathRight : 0);
	}

	private int maxPathSum(TreeNode node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(maxPathSumEachNode(node), Math.max(maxPathSumEachNode(node.left),
			maxPathSumEachNode(node.right)));
	}
	/*
	Input
[5,4,8,11,null,13,4,7,2,null,null,null,1]
Output
55
Expected
48
	 */
}

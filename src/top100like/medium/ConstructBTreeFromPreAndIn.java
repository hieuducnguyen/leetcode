/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import basic.TreeTest.TreeNode;

/**
 *
 * @author hieund3
 */
public class ConstructBTreeFromPreAndIn {

	public static void main(String[] args) {
		int[] preorder = new int[]{3, 2, 1, 4};
		int[] inorder = new int[]{1, 2, 3, 4};
		TreeNode node = process(preorder, inorder);
		String printTree = basic.TreeTest.printTree(node);
		System.out.println(printTree);
	}

	private static TreeNode process(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		TreeNode node = buildTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
		return node;
	}

	private static TreeNode buildTree(int startPre, int endPre, int[] preorder, int startIn, int endIn, int[] inorder) {
		if (startIn > endIn
			|| startPre > endPre
			|| Math.max(startPre, endPre) >= preorder.length
			|| Math.max(startIn, endIn) >= inorder.length) {
			return null;
		}
		if (endPre == startPre) {
			return new TreeNode(preorder[endPre]);
		}
		TreeNode node = new TreeNode(preorder[startPre]);
		for (int i = startIn; i <= endIn; i++) {
			if (inorder[i] == preorder[startPre]) {
				if (i > startIn) {
					node.left = buildTree(startPre + 1, startPre + i - startIn, preorder,
						startIn, i - 1, inorder);
				}
				node.right = buildTree(startPre + i - startIn + 1, endPre, preorder,
					i + 1, endIn, inorder);
				break;
			}
		}
		return node;
	}
}

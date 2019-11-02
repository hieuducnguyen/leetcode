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
		int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
		int[] preorder = {1, 2, 4, 3, 5, 7, 8, 6};

		TreeNode root = process1(inorder, preorder);
		String printTree = basic.TreeTest.toString(root);
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

	private static TreeNode process1(int[] inorder, int[] preorder) {
		if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0) {
			return null;
		}
		TreeNode node = construct(preorder, 0, preorder.length, inorder, 0, inorder.length);
		return node;
	}

	private static TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart >= preEnd || inStart >= inEnd) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[preStart]);
		int k = 0;
		for (int i = inStart; i < inEnd; i++) {
			if (inorder[i] == node.val) {
				k = i;
				break;
			}
		}
		node.left = construct(preorder, preStart + 1, preStart + 1 + k - inStart, inorder, inStart, k);
		node.right = construct(preorder, preStart + 1 + k - inStart, preEnd, inorder, k + 1, inEnd);
		return node;
	}
}

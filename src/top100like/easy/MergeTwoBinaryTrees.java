/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import basic.TreeTest.TreeNode;

/**
 *
 * @author HieuDucNguyen
 */
public class MergeTwoBinaryTrees {

	/**
	 * We can traverse both the given trees in a in-order fashion. At every step, we check if the current
	 * node is exist in two tree. If so the value of current node is sum of two nodes in trees, other it is the
	 * value of the node that is not null. Next, we will repeat above process with left children and right
	 * children of two trees
	 *
	 * @param t1
	 * @param t2
	 * @return merged tree
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		int valT1 = 0;
		TreeNode leftT1 = null;
		TreeNode rightT1 = null;
		if (t1 != null) {
			valT1 = t1.val;
			leftT1 = t1.left;
			rightT1 = t1.right;
		}
		int valT2 = 0;
		TreeNode leftT2 = null;
		TreeNode rightT2 = null;
		if (t2 != null) {
			valT2 = t2.val;
			leftT2 = t2.left;
			rightT2 = t2.right;
		}
		TreeNode treeNode = new TreeNode(valT1 + valT2);
		treeNode.left = mergeTrees(leftT1, leftT2);
		treeNode.right = mergeTrees(rightT1, rightT2);
		return treeNode;
	}

}

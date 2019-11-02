/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

import basic.TreeTest.TreeNode;

/**
 *
 * @author hieund3
 */
public class ConvertSortedArraytoBinarySearchTree {

	static final ConvertSortedArraytoBinarySearchTree INSTANCE = new ConvertSortedArraytoBinarySearchTree();

	public static void main(String[] args) {
		int[] nums = {4, 9, 11, 12};
		TreeNode node = INSTANCE.sortedArrayToBST(nums);
		String printTree = basic.TreeTest.toString(node);
		System.out.println("tree: " + printTree);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length);
	}

	public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
		if (left >= right) {
			return null;
		}
		int middle = (left + right) / 2;
		TreeNode middleTree = new TreeNode(nums[middle]);
		middleTree.left = sortedArrayToBST(nums, left, middle);
		middleTree.right = sortedArrayToBST(nums, middle + 1, right);
		return middleTree;
	}
}

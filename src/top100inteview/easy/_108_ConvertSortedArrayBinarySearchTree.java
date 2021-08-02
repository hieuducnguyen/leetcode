package top100inteview.easy;

import basic.TreeTest.TreeNode;

/*
 * Created by hieund3 on 06/07/2021
 */
public class _108_ConvertSortedArrayBinarySearchTree {
	public static final _108_ConvertSortedArrayBinarySearchTree INSTANCE =
		new _108_ConvertSortedArrayBinarySearchTree();

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length);
	}

	private TreeNode sortedArrayToBST(int[] nums, int start, int length) {
		if (start > length - 1) {
			return null;
		}
		if (start == length - 1) {
			return new TreeNode(nums[start]);
		}
		int mid = (start + length) / 2;
		final TreeNode treeNode = new TreeNode(nums[mid]);
		final TreeNode left = sortedArrayToBST(nums, start, mid);
		final TreeNode right = sortedArrayToBST(nums, mid + 1, length);
		treeNode.left = left;
		treeNode.right = right;
		return treeNode;
	}
}

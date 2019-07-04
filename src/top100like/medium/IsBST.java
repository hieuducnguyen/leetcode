/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import basic.TreeTest.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class IsBST {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(4);
		TreeNode node6 = new TreeNode(3);
		TreeNode node7 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
//		node2.right = node6;
//		node3.right = node7;
		boolean isBST = process2(node1);
		System.out.println("isBST: " + isBST);
	}

	private static boolean process(TreeNode node) {
		Map<TreeNode, Integer> minMap = new HashMap<>();
		Map<TreeNode, Integer> maxMap = new HashMap<>();
		buildMaxMap(maxMap, node);
		buildMinMap(minMap, node);
		return isBST(node, maxMap, minMap);
	}

	private static void buildMaxMap(Map<TreeNode, Integer> maxMap, TreeNode node) {
		if (node == null) {
			return;
		}
		maxMap.put(node, Math.max(node.val, max(node.left, node.right)));
		buildMaxMap(maxMap, node.left);
		buildMaxMap(maxMap, node.right);
	}

	private static Integer max(TreeNode left, TreeNode right) {
		int maxL = Integer.MIN_VALUE;
		if (left != null) {
			maxL = Math.max(left.val, max(left.left, left.right));
		}
		int maxR = Integer.MIN_VALUE;
		if (right != null) {
			maxR = Math.max(right.val, max(right.left, right.right));
		}
		return Math.max(maxL, maxR);
	}

	private static void buildMinMap(Map<TreeNode, Integer> minMap, TreeNode node) {
		if (node == null) {
			return;
		}
		minMap.put(node, Math.min(node.val, min(node.left, node.right)));
		buildMinMap(minMap, node.left);
		buildMinMap(minMap, node.right);
	}

	private static Integer min(TreeNode left, TreeNode right) {
		int minL = Integer.MAX_VALUE;
		if (left != null) {
			minL = Math.min(left.val, min(left.left, left.right));
		}
		int minR = Integer.MAX_VALUE;
		if (right != null) {
			minR = Math.min(right.val, min(right.left, right.right));
		}
		return Math.min(minL, minR);
	}

	private static boolean isBST(TreeNode node, Map<TreeNode, Integer> maxMap,
		Map<TreeNode, Integer> minMap) {
		if (node == null || node.right == null && node.left == null) {
			return true;
		}
		if (node.left != null && node.val <= maxMap.get(node.left)
			|| node.right != null && node.val >= minMap.get(node.right)) {
			return false;
		}
		return isBST(node.left, maxMap, minMap)
			&& isBST(node.right, maxMap, minMap);
	}

	private static boolean process2(TreeNode node) {
		return helper(node, null, null);
	}

	private static boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null) {
			return true;
		}
		int val = node.val;
		if (lower != null && lower >= val) {
			return false;
		}
		if (upper != null && upper <= val) {
			return false;
		}
		return helper(node.left, lower, val) && helper(node.right, val, upper);
	}

}

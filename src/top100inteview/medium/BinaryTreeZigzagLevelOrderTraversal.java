/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import basic.TreeTest.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author hieund3
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	static BinaryTreeZigzagLevelOrderTraversal INSTANCE = new BinaryTreeZigzagLevelOrderTraversal();

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(0);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(-2);
		TreeNode node5 = new TreeNode(3);
//		TreeNode node6 = new TreeNode(9);
//		TreeNode node7 = new TreeNode(3);
//		TreeNode node8 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
//		node3.right = node6;
//		node4.right = node7;
//		node5.left = node8;
		List<List<Integer>> zigzagLevelOrder = INSTANCE.zigzagLevelOrder(null);
		System.out.println(zigzagLevelOrder);
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (node != null) {
			queue.add(node);
		}
		boolean reverse = false;
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmpNode = queue.poll();
				if (reverse) {
					list.add(0, tmpNode.val);
				} else {
					list.add(tmpNode.val);
				}
				if (tmpNode.left != null) {
					queue.add(tmpNode.left);
				}
				if (tmpNode.right != null) {
					queue.add(tmpNode.right);
				}
			}
			reverse = !reverse;
			result.add(list);
		}
		return result;
	}
}

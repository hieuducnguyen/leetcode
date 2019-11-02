/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import basic.TreeTest.TreeNode;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;

/**
 *
 * @author hieund3
 */
public class ZIgzagLevelOrder {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node4.right = node7;
		node5.left = node8;
		List<List<Integer>> list = zigzagLevelOrder(node1);
		System.out.println(list);
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		Stack<TreeNode> stack = new Stack<>();
		while (!queue.isEmpty()) {
			List<Integer> subList = new ArrayList<>();
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					stack.add(node.left);
				}
				if (node.right != null) {
					stack.add(node.right);
				}
				size--;
			}
			while (!stack.isEmpty()) {
				subList.add(stack.pop().val);
			}
			list.add(subList);
		}
		return list;
	}
}

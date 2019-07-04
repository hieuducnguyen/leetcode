/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import basic.TreeTest.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author hieund3
 */
public class BiTreeLevelOrder {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		List<List<Integer>> result = process(node1);
		System.out.println("result: " + result);
	}

	private static List<List<Integer>> process(TreeNode node) {
		List<List<Integer>> result = new ArrayList<>();
		if (node == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> levelQueue = new LinkedList<>();
		levelQueue.add(node);
		do {
			queue.addAll(levelQueue);
			List<Integer> list = new ArrayList<>();
			for (TreeNode item : levelQueue) {
				list.add(item.val);
			}
			result.add(list);
			levelQueue = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeNode tmpNode = queue.poll();
				if (tmpNode.left != null) {
					levelQueue.add(tmpNode.left);
				}
				if (tmpNode.right != null) {
					levelQueue.add(tmpNode.right);
				}
			}
		} while (!levelQueue.isEmpty());
		return result;
	}
}

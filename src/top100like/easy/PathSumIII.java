/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.easy;

import basic.TreeTest.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class PathSumIII {

	static PathSumIII INSTANCE = new PathSumIII();

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(-2);
		TreeNode node2 = new TreeNode(0);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(3);
		TreeNode node8 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
//		node3.left = node5;
//		node3.right = node6;
//		node4.right = node7;
//		node5.left = node8;
		INSTANCE.pathSum(node1, 0);
	}

	public int pathSum(TreeNode node, int sum) {
		Map<TreeNode, List<Integer>> map = new HashMap<>();
		TreeNode parent = null;
		int pathSum = pathSum(parent, node, sum, map);
		System.out.println("pathSum: " + pathSum);
		return pathSum;
	}

	private int pathSum(TreeNode parent, TreeNode node, int sum, Map<TreeNode, List<Integer>> map) {
		if (node == null) {
			return 0;
		}
		List<Integer> parentPath = map.getOrDefault(parent, new ArrayList<>());
		int numPath = 0;
		List<Integer> nodePath = new ArrayList<>();
		for (int i = 0; i < parentPath.size(); i++) {
			int path = parentPath.get(i) + node.val;
			nodePath.add(path);
			if (path == sum) {
				numPath++;
			}
		}
		nodePath.add(node.val);
		if (node.val == sum) {
			numPath++;
		}
		map.put(node, nodePath);
		int numPathLeft = pathSum(node, node.left, sum, map);
		int numPathRight = pathSum(node, node.right, sum, map);
		map.remove(node);
		return numPath + numPathLeft + numPathRight;
	}
}

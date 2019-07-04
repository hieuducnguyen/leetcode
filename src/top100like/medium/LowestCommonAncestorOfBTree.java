/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import basic.TreeTest.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class LowestCommonAncestorOfBTree {

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
		TreeNode node = process(node1, node6, node7);
		System.out.println(node);
	}

	private static TreeNode process(TreeNode node, TreeNode p, TreeNode q) {
		Stack<TreeNode> stackP = new Stack();
		Stack<TreeNode> stackQ = new Stack();
		find(node, p, stackP);
		find(node, q, stackQ);
//		System.out.println(stackP);
		System.out.println(stackQ);
		Stack<TreeNode> maxStack = stackP.size() > stackQ.size() ? stackP : stackQ;
		Stack<TreeNode> minStack = stackP.size() <= stackQ.size() ? stackP : stackQ;
		Queue<TreeNode> tmpQueue = new LinkedList<>();
		TreeNode intersectNode = null;
		while (!minStack.isEmpty()) {
			TreeNode tmpNode = minStack.pop();
			if (intersectNode == null && maxStack.contains(tmpNode)) {
				intersectNode = tmpNode;
				break;
			}
			tmpQueue.add(tmpNode);
		}
		if (intersectNode == node) {
			return node;
		}
		TreeNode min = intersectNode;
		while (!tmpQueue.isEmpty()) {
			TreeNode tmpNode = tmpQueue.poll();
			if (maxStack.contains(tmpNode) && tmpNode.val < min.val) {
				min = tmpNode;
			}
		}
		return min;
	}

	private static boolean find(TreeNode node, TreeNode p, Stack<TreeNode> stack) {
		stack.push(node);
		if (node == p) {
			return true;
		}
		if (node.left == null && node.right == null) {
			return false;
		}
		if (node.left != null) {
			if (find(node.left, p, stack)) {
				return true;
			} else {
				stack.pop();
			}
		}
		if (node.right != null) {
			if (find(node.right, p, stack)) {
				return true;
			} else {
				stack.pop();
			}
		}
		return false;
	}
}

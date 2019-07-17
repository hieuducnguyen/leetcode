/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import basic.TreeTest.TreeNode;
import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class InoderWithOutRecurs {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(-2);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(3);
		TreeNode node8 = new TreeNode(5);

//		node1.left = node2;
		node1.right = node3;
//		node2.left = node4;
		node3.left = node5;
//		node3.right = node6;
//		node4.right = node7;
//		node5.left = node8;
		travelInoder(node1);
	}

	private static void travelInoder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tmpNode = node;
		while (tmpNode != null || !stack.isEmpty()) {
			while (tmpNode != null) {
				stack.add(tmpNode);
				tmpNode = tmpNode.right;
			}
			tmpNode = stack.pop();
			System.out.println(tmpNode.val);
			tmpNode = node.left;
		}
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import basic.TreeTest.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class KthSmallestElementinBST {

	static final KthSmallestElementinBST INSTANCE = new KthSmallestElementinBST();

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
//		TreeNode node7 = new TreeNode(3);
//		TreeNode node8 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		node3.right = node6;
		int kthSmallest = INSTANCE.kthSmallest(node1, 1);
		System.out.println("kthSmallest: " + kthSmallest);
	}

	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = convertBSTToList(root);
//		System.out.println(list);
		return list.get(k - 1);
	}

	private List<Integer> convertBSTToList(TreeNode node) {
		if (node == null) {
			return new ArrayList<>();
		}
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> left = convertBSTToList(node.left);
		arrayList.addAll(left);
		arrayList.add(node.val);
		List<Integer> right = convertBSTToList(node.right);
		arrayList.addAll(right);
		return arrayList;
	}
}

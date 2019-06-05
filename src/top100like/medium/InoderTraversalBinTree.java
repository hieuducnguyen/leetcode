/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import basic.TreeTest.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class InoderTraversalBinTree {

	public static void main(String[] args) {
		TreeNode x = new TreeNode(1);
		TreeNode y = new TreeNode(2);
		TreeNode z = new TreeNode(3);

		x.right = y;
		y.left = z;

		List<Integer> list = process(x);
		System.out.println("list: " + list);
	}

	private static List<Integer> process(TreeNode x) {
		if (x == null) {
			return new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>();
		travel(x, result);
		return result;
	}

	private static void travel(TreeNode x, List<Integer> result) {
		if (x == null) {
			return;
		}
		travel(x.left, result);
		result.add(x.val);
		travel(x.right, result);
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author HieuDucNguyen
 */
public class TreeTest {

	public static class TreeNode {

		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return val + "";
		}

	}
	public static String printTemplate = "{(%s):left(%s)right(%s)}";

	public static String toString(TreeNode node) {
		if (node != null) {
			return String.format(printTemplate, node.val, toString(node.left), toString(node.right));
		} else {
			return "null";
		}
	}

	public static void printTree(TreeNode node) {
		String tree = "null";
		if (node != null) {
			tree = String.format(printTemplate, node.val, toString(node.left), toString(node.right));
		}
		System.out.println("tree: " + tree);
	}

//	public static void main(String[] args) {
//		TreeNode t11 = new TreeNode(1);
//		TreeNode t21 = new TreeNode(3);
//		TreeNode t31 = new TreeNode(2);
//		TreeNode t41 = new TreeNode(5);
//		t11.left = t21;
//		t11.right = t31;
//		t21.left = t41;
//		String tree = printTree(t11);
//		System.out.println("tree: " + tree);
//	}
}

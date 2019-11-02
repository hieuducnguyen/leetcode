/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class SumByList {

	private static class ListNode {

		public String val;
		public ListNode next;

		public ListNode(String x) {
			val = x;
		}

		@Override
		public String toString() {
			return String.format("value=%s", val);
		}

	}

	public static void main(String[] args) {
		SumByList instance = new SumByList();
		ListNode node0 = new ListNode("-");
		ListNode node1 = new ListNode("1");
		ListNode node2 = new ListNode("-");
		ListNode node3 = new ListNode("2");
		ListNode node4 = new ListNode("+");
		ListNode node5 = new ListNode("100");
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		int result = instance.calculate(node0);
		System.out.println("result: " + result);
	}

	private int calculate(ListNode node) {
		Set<String> set = new HashSet<>();
		set.add("-");
		set.add("+");
		String tmpOperation = "+";
		int tmpResult = 0;
		ListNode tmpNode = node;
		while (tmpNode != null) {
			if (set.contains(tmpNode.val)) {
				tmpOperation = tmpNode.val;
			} else {
				if (tmpOperation.equals("-")) {
					tmpResult -= Integer.parseInt(tmpNode.val);
				} else {
					tmpResult += Integer.parseInt(tmpNode.val);
				}
			}
			tmpNode = tmpNode.next;
		}

		return tmpResult;
	}
}

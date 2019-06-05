/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import basic.BasicTest.ListNode;

/**
 *
 * @author hieund3
 */
public class LinkedListCycleII {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		ListNode node = process(node1);
		System.out.println(node);
	}

	private static ListNode process(ListNode root) {
		if (root == null || root.next == null) {
			return null;
		}
		ListNode fast = root;
		ListNode slow = root;
		do {
			fast = fast.next.next;
			slow = slow.next;
		} while (fast != slow && fast != null && fast.next != null
			&& slow != null);
		if (fast == null || slow == null || fast.next == null) {
			return null;
		}
		ListNode head = root;
		while (slow != head) {
			slow = slow.next;
			head = head.next;
		}
		return head;
	}
}

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
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l11 = new ListNode(3);
		l1.next = l11;
		ListNode l111 = new ListNode(4);
		l11.next = l111;
		ListNode l1111 = new ListNode(9);
		l111.next = l1111;

		ListNode l2 = new ListNode(2);
		ListNode l22 = new ListNode(7);
		l2.next = l22;
		ListNode node = process(l1, l2);
		basic.BasicTest.printListNode(node);
	}

	private static ListNode process(ListNode l1, ListNode l2) {
		int num = 0;
		ListNode head = null;
		ListNode preview = null;
		while (l1 != null && l2 != null) {
			num += (l1.val + l2.val);
			ListNode node = new ListNode(num % 10);
			if (preview == null) {
				preview = node;
			} else {
				preview.next = node;
				preview = node;
			}
			if (head == null) {
				head = node;
			}
			if (num > 9) {
				num = 1;
			} else {
				num = 0;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			num += l1.val;
			ListNode node = new ListNode(num % 10);
			if (preview == null) {
				preview = node;
			} else {
				preview.next = node;
				preview = node;
			}
			if (head == null) {
				head = node;
			}
			if (num > 9) {
				num = 1;
			} else {
				num = 0;
			}
			l1 = l1.next;
		}
		while (l2 != null) {
			num += l2.val;
			ListNode node = new ListNode(num % 10);
			if (preview == null) {
				preview = node;
			} else {
				preview.next = node;
				preview = node;
			}
			if (head == null) {
				head = node;
			}
			if (num > 9) {
				num = 1;
			} else {
				num = 0;
			}
			l2 = l2.next;
		}
		if (num == 1) {
			ListNode node = new ListNode(num);
			preview.next = node;
		}
		return head;
	}
}

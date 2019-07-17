/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import basic.BasicTest.ListNode;

/**
 *
 * @author hieund3
 */
public class Merge2SortedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(10);
		ListNode l2 = new ListNode(11);

		ListNode l3 = new ListNode(29);
		l2.next = l3;
		ListNode l = mergeTwoLists(l1, l2);
		basic.BasicTest.printListNode(l);
		System.exit(0);
	}

	private static ListNode process(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head;
		if (l1.val > l2.val) {
			head = new ListNode(l2.val);
			l2 = l2.next;
		} else {
			head = new ListNode(l1.val);
			l1 = l1.next;
		}
		ListNode tmp = head;
		while (l1 != null && l2 != null) {
			ListNode node;
			if (l1.val > l2.val) {
				node = new ListNode(l2.val);
				l2 = l2.next;
			} else {
				node = new ListNode(l1.val);
				l1 = l1.next;
			}
			tmp.next = node;
			tmp = node;
		}
		if (l1 != null) {
			tmp.next = l1;
		} else {
			tmp.next = l2;
		}
		return head;
	}

	private static ListNode process1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode node;
		if (l1.val > l2.val) {
			node = new ListNode(l2.val);
			l2 = l2.next;
		} else {
			node = new ListNode(l1.val);
			l1 = l1.next;
		}
		node.next = process1(l1, l2);
		return node;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode pHead = null;
		if (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				pHead = l2;
				l2 = l2.next;
			} else {
				pHead = l1;
				l1 = l1.next;
			}
		}
		ListNode tmpNode = pHead;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				tmpNode.next = l2;
				l2 = l2.next;
			} else {
				tmpNode.next = l1;
				l1 = l1.next;
			}
			tmpNode = tmpNode.next;
		}
		if (l1 != null) {
			tmpNode.next = l1;
		}
		if (l2 != null) {
			tmpNode.next = l2;
		}
		return pHead;
	}
}

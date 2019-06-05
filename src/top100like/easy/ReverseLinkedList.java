/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.easy;

/**
 *
 * @author hieund3
 */
public class ReverseLinkedList {

	private static ListNode iterative(ListNode a) {
		ListNode previousNode = null;
		ListNode node = null;
		while (a != null) {
			node = new ListNode(a.val);
			node.next = previousNode;
			previousNode = node;
			a = a.next;
		}
		return node;
	}

	private static ListNode recursive(ListNode a, ListNode prev) {
		if (a == null) {
			return null;
		}
		ListNode node;
		node = new ListNode(a.val);
		node.next = prev;
		if (a.next != null) {
			return recursive(a.next, node);
		} else {
			return node;
		}
	}

	private static class ListNode {

		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		ListNode list = recursive(a, null);
		while (list != null) {
			System.out.println("val: " + list.val);
			list = list.next;

		}
	}
}

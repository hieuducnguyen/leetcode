/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class Intersection2LinkedList {

	public static class ListNode {

		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode process(ListNode headA, ListNode headB) {
		ListNode tmpA = headA, tmpB;
		while (tmpA != null) {
			tmpB = headB;
			while (tmpB != null) {
				if (tmpA == tmpB) {
					return tmpA;
				}
				tmpB = tmpB.next;
			}
			tmpA = tmpA.next;
		}
		return null;
	}

	public static ListNode process2(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		ListNode tmpA = headA, tmpB = headB;
		while (tmpA != null || tmpB != null) {
			if (set.contains(tmpA)) {
				return tmpA;
			}
			if (tmpA != null) {
				set.add(tmpA);
				tmpA = tmpA.next;

			}
			if (set.contains(tmpB)) {
				return tmpB;
			}
			if (tmpB != null) {
				set.add(tmpB);
				tmpB = tmpB.next;
			}
		}
		return null;
	}

	public static ListNode process3(ListNode headA, ListNode headB) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode tmpA = headA;
		while (tmpA != null) {
			set.add(tmpA);
			tmpA = tmpA.next;
		}
		ListNode tmpB = headB;
		while (tmpB != null) {
			if (set.contains(tmpB)) {

			}
		}
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(10);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode g = new ListNode(6);
		ListNode h = new ListNode(7);
		ListNode k = new ListNode(8);
		a.next = b;
		b.next = c;
		g.next = h;
		h.next = k;
		k.next = c;
		c.next = d;
		d.next = e;
		ListNode ret = process2(b, g);
		System.out.println("ret: " + ret.val);
	}

}

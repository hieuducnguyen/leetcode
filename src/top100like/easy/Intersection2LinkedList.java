/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.easy;

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

	public static ListNode headOfA;
	public static ListNode headOfB;

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
		HashSet<ListNode> set = new HashSet<>();
		ListNode tmpA = headA;
		while (tmpA != null) {
			set.add(tmpA);
			tmpA = tmpA.next;
		}
		ListNode tmpB = headB;
		while (tmpB != null) {
			if (set.contains(tmpB)) {
				return tmpB;
			}
			tmpB = tmpB.next;
		}
		return null;
	}

	public static ListNode process4(ListNode headA, ListNode headB) {
		int lenA = len(headA);
		int lenB = len(headB);
		int diff = lenA - lenB;
		if (diff > 0) {
			for (int i = 0; i < diff; i++) {
				headA = headA.next;
			}
		} else {
			diff = -diff;
			for (int i = 0; i < diff; i++) {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	public static int len(ListNode node) {
		int len = 0;
		while (node != null) {
			++len;
			node = node.next;
		}
		return len;
	}

	public static ListNode process5(ListNode headA, ListNode headB) {
		headOfA = headA;
		headOfB = headB;
		boolean switchA = false, switchB = false;
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			if (headA.next != null || switchA) {
				headA = headA.next;
			} else {
				switchA = true;
				headA = headOfB;
			}
			if (headB.next != null || switchB) {
				headB = headB.next;
			} else {
				switchB = true;
				headB = headOfA;
			}
		}
		return null;
	}

	public static ListNode process6(ListNode nodeA, ListNode nodeB) {
		ListNode headA = nodeA;
		ListNode headB = nodeB;
		while (nodeA != nodeB) {
			nodeA = nodeA.next != null ? nodeA.next : headB;
			nodeB = nodeB.next != null ? nodeB.next : headA;
		}
		return nodeA;
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
		ListNode ret = process6(a, g);
		System.out.println("ret: " + ret.val);
	}

}

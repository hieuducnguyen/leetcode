/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import basic.BasicTest.ListNode;
import java.util.HashSet;

/**
 *
 * @author HieuDucNguyen
 */
public class HasCycle {

	private static boolean process(ListNode node) {
		HashSet<ListNode> set = new HashSet<>();
		while (node != null) {
			if (set.contains(node)) {
				return true;
			} else {
				set.add(node);
			}
			node = node.next;
		}
		return false;
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
		e.next = b;
		boolean hasCycle = process1(a);
		System.out.println("hasCycle: " + hasCycle);
	}

	private static boolean process1(ListNode a) {
		if (a == null || a.next == null) {
			return false;
		}
		ListNode head1 = a;
		ListNode head2 = a.next;
		while (head1 != null && head2 != null && head2.next != null) {
			if (head1.val == head2.val) {
				return true;
			}
			head1 = head1.next;
			head2 = head2.next.next;
		}
		return false;
	}
}

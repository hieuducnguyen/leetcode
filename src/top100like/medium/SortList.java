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
public class SortList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode node = process1(node1);
		basic.BasicTest.printListNode(node);
//		System.out.println("node: " + node.val);
	}

	private static ListNode process(ListNode root) {
		sort(root, null);
		return root;
	}

	private static void sort(ListNode start, ListNode end) {
		if (start != end && start.next != end) {
			ListNode pos = partition(start, end);
			sort(start, pos);
			sort(pos.next, end);
		}
	}

	private static ListNode partition(ListNode start, ListNode end) {
		ListNode i = start;
		ListNode pivote = start;
		ListNode j = start.next;
		while (j != end) {
			if (j.val < pivote.val) {
				i = i.next;
				swap(i, j);
			}
			j = j.next;
		}
		swap(i, pivote);
		return i;
	}

	private static void swap(ListNode node1, ListNode node2) {
		int temp = node2.val;
		node2.val = node1.val;
		node1.val = temp;
	}

	private static ListNode process1(ListNode node) {
		return mergeSort(node);
	}

	private static ListNode mergeSort(ListNode start) {

		if (start == null || start.next == null) {
			return start;
		}
		ListNode fast = start;
		ListNode slow = start;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode newStart = slow.next;
		slow.next = null;
		ListNode left = mergeSort(start);
		ListNode right = mergeSort(newStart);
		ListNode ret = merge(left, right);
		return ret;
	}

	private static ListNode merge(ListNode left, ListNode right) {
		ListNode node = new ListNode(0);
		ListNode head = node;
		ListNode p = left;
		ListNode q = right;
		while (p != null && q != null) {
			if (p.val < q.val) {
				node.next = p;
				p = p.next;
			} else {
				node.next = q;
				q = q.next;
			}
			node = node.next;
		}

		if (p != null) {
			node.next = p;
		}

		if (q != null) {
			node.next = q;
		}
		return head.next;
	}

}

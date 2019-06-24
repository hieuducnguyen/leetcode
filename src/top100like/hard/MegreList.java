/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.hard;

import basic.BasicTest.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author hieund3
 */
public class MegreList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node11 = new ListNode(4);
		ListNode node12 = new ListNode(5);
		node1.next = node11;
		node11.next = node12;

		ListNode node2 = new ListNode(1);
		ListNode node21 = new ListNode(3);
		ListNode node22 = new ListNode(4);
		node2.next = node21;
		node21.next = node22;

		ListNode node3 = new ListNode(1);
		ListNode node31 = new ListNode(6);
		node3.next = node31;

		ListNode[] array = new ListNode[]{node1, node2, node3};
		ListNode result = process2(array);
		basic.BasicTest.printListNode(result);
		System.exit(0);
	}

	private static ListNode process(ListNode[] array) {
		ListNode result = new ListNode(0);
		ListNode phead = result;
		int pos;
		while ((pos = emptyArray(array)) == -1) {
			int minPos = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < array.length; i++) {
				if (array[i] != null && array[i].val < min) {
					minPos = i;
					min = array[i].val;
				}
			}
			result.next = array[minPos];
			array[minPos] = array[minPos].next;
			result = result.next;
		}
		if (pos != -2) {
			result.next = array[pos];
		}
		return phead.next;
	}

	private static int emptyArray(ListNode[] array) {
		int pos = -2;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				if (pos == -2) {
					pos = i;
				} else {
					return -1;
				}
			}
		}
		return pos;
	}

	private static ListNode process2(ListNode[] arr) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.val - o2.val;
		});
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				continue;
			}
			pq.add(arr[i]);
		}
		ListNode node = new ListNode(0);
		ListNode phead = node;
		while (!pq.isEmpty()) {
			ListNode minNode = pq.poll();
			if (minNode == null) {
				continue;
			}
			node.next = minNode;
			node = node.next;
			if (minNode.next != null) {
				pq.add(minNode.next);
			}
		}
		return phead.next;
	}

	public ListNode process3(ListNode[] lists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
			(one, two) -> one.val < two.val ? -1 : 1);
		ListNode dummy = new ListNode(0);
		if (lists == null || lists.length == 0) {
			return dummy.next;
		}
		ListNode cur = dummy;
		for (ListNode each : lists) {
			if (each != null) {
				minHeap.offer(each);
			}
		}
		while (!minHeap.isEmpty()) {
			ListNode next = minHeap.poll();
			if (next.next != null) {
				minHeap.offer(next.next);
			}
			cur.next = next;
			cur = next;
		}

		return dummy.next;
	}

	public ListNode process4(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return sort(lists, 0, lists.length - 1);
	}

	public ListNode sort(ListNode[] lists, int lo, int hi) {
		if (lo > hi) {
			return null;
		}

		if (lo == hi) {
			return lists[lo];
		}

		int mid = (lo + hi) / 2;
		ListNode left = sort(lists, lo, mid);
		ListNode right = sort(lists, mid + 1, hi);

		return merge(left, right);
	}

	ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode preHead = dummy;

		while (a != null && b != null) {
			if (a.val < b.val) {
				dummy.next = a;
				a = a.next;
			} else {
				dummy.next = b;
				b = b.next;
			}
			dummy = dummy.next;
		}

		dummy.next = (a == null) ? b : a;
		return preHead.next;
	}

}

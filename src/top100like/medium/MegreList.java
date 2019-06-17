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
		ListNode result = process(array);
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
}

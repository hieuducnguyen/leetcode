/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import basic.BasicTest.ListNode;

/**
 *
 * @author hieund3
 */
public class OddEvenLinkedList {

	static OddEvenLinkedList INSTANCE = new OddEvenLinkedList();

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode result = INSTANCE.oddEvenList(node1);
		basic.BasicTest.printListNode(node1);
		System.out.println("\nresult: ");
		basic.BasicTest.printListNode(result);
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode headOdd = new ListNode(0);
		ListNode tmpOdd = headOdd;
		ListNode headEven = new ListNode(0);
		ListNode tmpEven = headEven;
		while (head != null && head.next != null) {
//			ListNode tmp = new ListNode(head.val);
//			ListNode nextTmp = new ListNode(head.next.val);
			tmpOdd.next = head;
			tmpEven.next = head.next;
			tmpOdd = tmpOdd.next;
			tmpEven = tmpEven.next;
			head = head.next.next;
		}
		if (head != null) {
//			ListNode tmp = new ListNode(head.val);
			tmpOdd.next = head;
			tmpOdd = tmpOdd.next;
		}
		tmpOdd.next = headEven.next;
		tmpEven.next = null;
		return headOdd.next;
	}
}

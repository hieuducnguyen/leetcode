package top100inteview.easy;

import basic.BasicTest.ListNode;

/*
 * Created by hieund3 on 10/07/2021
 */
public class _206_ReverseLinkedList {
	public static final _206_ReverseLinkedList INSTANCE = new _206_ReverseLinkedList();

	public ListNode reverseList(ListNode node, ListNode previousNode) {
		if (node == null) {
			return previousNode;
		}
		final ListNode newNode = new ListNode(node.val);
		newNode.next = previousNode;
		return reverseList(node.next, newNode);
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		return reverseList(head.next, new ListNode(head.val));
	}
}

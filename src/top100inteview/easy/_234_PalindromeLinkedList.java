package top100inteview.easy;

import basic.BasicTest.ListNode;

/*
 * Created by hieund3 on 10/07/2021
 */
public class _234_PalindromeLinkedList {
	public static final _234_PalindromeLinkedList INSTANCE = new _234_PalindromeLinkedList();

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slowNode = head, fastNode = head;
		ListNode reverseNode = new ListNode(head.val);
		while (fastNode.next != null && fastNode.next.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			final ListNode listNode = new ListNode(slowNode.val);
			listNode.next = reverseNode;
			reverseNode = listNode;
		}
		if (fastNode.next == null) {
			reverseNode = reverseNode.next;
		}
		slowNode = slowNode.next;
		while (slowNode != null) {
			if (slowNode.val != reverseNode.val) {
				return false;
			}
			slowNode = slowNode.next;
			reverseNode = reverseNode.next;
		}
		return true;
	}
}

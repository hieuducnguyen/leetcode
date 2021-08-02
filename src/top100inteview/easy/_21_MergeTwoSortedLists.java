package top100inteview.easy;

import basic.BasicTest.ListNode;

/*
 * Created by hieund3 on 01/07/2021
 */
public class _21_MergeTwoSortedLists {
	public static final _21_MergeTwoSortedLists INSTANCE = new _21_MergeTwoSortedLists();

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode pHead = new ListNode(0), pTemp = pHead;
		while (l1 != null && l2 != null) {
			ListNode listNode;
			if (l1.val > l2.val) {
				int val = l2.val;
				listNode = new ListNode(val);
				l2 = l2.next;
			} else {
				int val = l1.val;
				listNode = new ListNode(val);
				l1 = l1.next;
			}
			pTemp.next = listNode;
			pTemp = pTemp.next;
		}
		ListNode node = l1 != null ? l1 : l2;
		while (node != null) {
			pTemp.next = new ListNode(node.val);
			pTemp = pTemp.next;
			node = node.next;
		}
		return pHead.next;
	}
}

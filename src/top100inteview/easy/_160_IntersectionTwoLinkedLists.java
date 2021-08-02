package top100inteview.easy;

import basic.BasicTest.ListNode;

/*
 * Created by hieund3 on 08/07/2021
 */
public class _160_IntersectionTwoLinkedLists {
	public static final _160_IntersectionTwoLinkedLists INSTANCE = new _160_IntersectionTwoLinkedLists();

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int loop = 0;
		ListNode firstWalker = headA;
		ListNode secondWalker = headB;
		while (loop < 2 && firstWalker != secondWalker) {
			firstWalker = firstWalker.next;
			secondWalker = secondWalker.next;
			if (firstWalker == null) {
				firstWalker = headB;
				loop++;
			}
			if (secondWalker == null) {
				secondWalker = headA;
			}
		}
		if (loop == 2) {
			return null;
		} else {
			return firstWalker;
		}
	}
}

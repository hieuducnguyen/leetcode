package top100inteview.easy;

import basic.BasicTest.ListNode;

/*
 * Created by hieund3 on 07/07/2021
 */
public class _141_LinkedListCycle {
	public static final _141_LinkedListCycle INSTANCE = new _141_LinkedListCycle();

	public boolean hasCycle(ListNode head) {
		ListNode next = head, doubleNext = head;
		while (next != null && doubleNext != null && doubleNext.next != null) {
			next = next.next;
			doubleNext = doubleNext.next.next;
			if (doubleNext == next) {
				return true;
			}
		}
		return false;
	}
}

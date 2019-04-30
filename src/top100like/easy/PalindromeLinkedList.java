/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import basic.BasicTest.ListNode;

/**
 *
 * @author hieund3
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        boolean isPalindrome = process(node1);
        System.out.println("is: " + isPalindrome);
    }

    private static boolean process(ListNode node) {
        if (node == null || node.next == null) {
            return true;
        }
        ListNode head1 = node;
        ListNode head2 = new ListNode(node.val);
        node = node.next;
        while (node != null) {
            ListNode tmpNode = new ListNode(node.val);
            tmpNode.next = head2;
            head2 = tmpNode;
            node = node.next;
        }
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        while (tmp1 != null) {
            if (tmp1.val != tmp2.val) {
                return false;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return true;
    }
}

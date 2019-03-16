/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like;

import java.util.HashSet;

/**
 *
 * @author HieuDucNguyen
 */
public class HasCycle {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean process(ListNode node) {
        HashSet<ListNode> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node)) {
                return true;
            } else {
                set.add(node);
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

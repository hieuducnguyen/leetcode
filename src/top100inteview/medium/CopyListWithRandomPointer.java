/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import basic.Node;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class CopyListWithRandomPointer {

	static CopyListWithRandomPointer INSTANCE = new CopyListWithRandomPointer();

	public static void main(String[] args) {
		Node node1 = new Node();
		node1.val = 1;
		Node node2 = new Node();
		node2.val = 2;
		Node node3 = new Node();
		node3.val = 3;
		Node node4 = new Node();
		node4.val = 4;
		Node node5 = new Node();
		node5.val = 5;

		node1.next = node2;
		node2.random = node1;
//		node1.random = node5;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;

		Node cloneNode = INSTANCE.copyRandomList(node1);
		basic.BasicTest.printListNode(cloneNode);
	}

	public Node copyRandomList(Node head) {
		Node pointer = head;
		Map<Node, Node> map = new HashMap<>();
		Node cloneHead = new Node();
		Node tmpNode = cloneHead;
		while (pointer != null) {
			Node newNode = new Node();
			newNode.val = pointer.val;
			map.put(pointer, newNode);
			tmpNode.next = newNode;
			tmpNode = tmpNode.next;
			pointer = pointer.next;
		}
		pointer = head;
		tmpNode = cloneHead.next;
		System.out.println("map: " + map);
		while (pointer != null) {
			tmpNode.random = map.get(pointer.random);
			tmpNode = tmpNode.next;
			pointer = pointer.next;
		}
		return cloneHead.next;
	}
}

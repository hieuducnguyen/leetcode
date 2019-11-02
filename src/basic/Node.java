/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author hieund3
 */
public class Node {

	public int val;
	public Node next;
	public Node random;

	public Node() {
	}

	public Node(int _val, Node _next, Node _random) {
		val = _val;
		next = _next;
		random = _random;
	}

	@Override
	public String toString() {
		if (this == null) {
			return "null";
		}
		String nextString = next != null ? Integer.toString(next.val) : "null";
		String randomString = random != null ? Integer.toString(random.val) : " null";
		return String.format("node: %s, next: %s, random: %s", val, nextString, randomString);
	}
}

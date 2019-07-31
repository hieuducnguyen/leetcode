/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class TestCacheV4 {

	static class LinkedList {

		private final Map<Integer, NodeList> traceNodeMap = new HashMap<>(); // <key, previousNode in List>
		private final Map<NodeList, Integer> traceKeyMap = new HashMap<>();// <previousNode in List, key>

		private final int capacity;
		private int size;
		private NodeList pTail;
		private NodeList pHead;

		LinkedList(int capacity) {
			this.capacity = capacity;
			size = 0;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("==LinkedList Start==\n");
			NodeList pTmp = pHead;
			while (pTmp != null) {
				sb.append(pTmp.value).append(",");
				pTmp = pTmp.next;
			}
			sb.append("\ntraceNodeMap: ").append(traceNodeMap);
			sb.append("\ntraceKeyMap: ").append(traceKeyMap);
			sb.append("\nsize: ").append(size);
			sb.append("\n==LinkedList End==\n");
			return sb.toString();
		}

		public Integer addOrUpdate(int key) {
			Integer removeValue = null;
			if (traceNodeMap.containsKey(key)) {
				update(key);
			} else {
				removeValue = add(key);
			}
			return removeValue;
		}

		public Integer add(int key) {
			Integer removeValue = null;
			if (size == capacity) {
				removeValue = poll();
			}
			if (size == 0) {
				NodeList node = new NodeList(key);
				traceNodeMap.put(key, null);
				pTail = node;
				pHead = node;
			} else {
				traceNodeMap.put(key, pTail);
				traceKeyMap.put(pTail, key);
				NodeList node = new NodeList(key);
				pTail.next = node;
				pTail = node;
			}
			size++;
			return removeValue;
		}

		public void update(int key) {
			if (key == pHead.value) {
				poll();
				size++;
				traceNodeMap.put(key, pTail);
				traceKeyMap.put(pTail, key);

				NodeList node = new NodeList(key);
				pTail.next = node;
				pTail = node;
			} else if (key != pTail.value) {
				NodeList pre = traceNodeMap.get(key);
				traceNodeMap.remove(key);
				traceKeyMap.remove(pre);
				NodeList nextPre = pre.next;
				Integer nextKey = traceKeyMap.get(nextPre);
				traceKeyMap.remove(nextPre);
				traceNodeMap.put(nextKey, pre);
				traceKeyMap.put(pre, nextKey);
				pre.next = pre.next.next;

				NodeList node = new NodeList(key);
				traceNodeMap.put(key, pTail);
				traceKeyMap.put(pTail, key);
				pTail.next = node;
				pTail = node;
			}
		}

		public Integer poll() {
			if (size > 0) {
				Integer nextKey = traceKeyMap.get(pHead);
				traceNodeMap.remove(pHead.value);
				traceKeyMap.remove(pHead);
				if (nextKey != null) {
					traceNodeMap.put(nextKey, null);
				}
				Integer value = pHead.value;
				if (pHead.next != null) {
					pHead = pHead.next;
				} else {
					pHead = null;
					pTail = null;
				}
				size--;
				return value;
			} else {
				return null;
			}
		}
	}

	static class NodeList {

		NodeList(int value) {
			this.value = value;
		}

		Integer value;
		NodeList next;

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(3);
		list.addOrUpdate(1);
		System.out.println(list);
		list.addOrUpdate(2);
		System.out.println(list);
//		System.out.println(list);
		list.addOrUpdate(3);
		System.out.println(list);
		list.addOrUpdate(1);
		System.out.println(list);
		list.addOrUpdate(4);
		System.out.println(list);
	}
}

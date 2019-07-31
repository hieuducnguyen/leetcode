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
public class TestCacheV3 {

	static class LRUCache {

		Map<Integer, Integer> map = new HashMap<>();
		LinkedList list;
		int capacity;

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("==LRU Cache Start==\n");
			for (Integer key : map.keySet()) {
				sb.append(String.format("key %s value %s \n", key, map.get(key)));
			}
			sb.append("==LRU Cache End==\n");
			return sb.toString();
		}

		public LRUCache(int capacity) {
			this.capacity = capacity;
			list = new LinkedList(capacity);
		}

		public void put(Integer key, Integer value) {
			Integer removeValue = list.addOrUpdate(key);
			map.remove(removeValue);
			map.put(key, value);
		}

		public Integer get(Integer key) {
			if (map.containsKey(key)) {
				list.addOrUpdate(key);
				return map.get(key);
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
//		LRUCache cache = new LRUCache(1);
//		cache.put(1, 1);//1
//		System.out.println(cache);
//		cache.put(2, 2);//2
//		System.out.println(cache);
//		cache.put(3, 3);//3
//		System.out.println(cache);
//		Integer get = cache.get(3); //2
//		System.out.println(get);
//		System.out.println(cache);
//		cache.put(4, 4);
//		System.out.println(cache);
		LRUCache cache = new LRUCache(1);
		cache.put(1, 1);//
		Integer get = cache.get(1);
		System.out.println(get);
	}

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
			if (key == pTail.value) {
				return;
			}
			if (key == pHead.value) {
				poll();
				size++;
				traceNodeMap.put(key, pTail);
				traceKeyMap.put(pTail, key);

				NodeList node = new NodeList(key);
				pTail.next = node;
				pTail = node;
			} else {
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
}

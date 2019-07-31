/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author hieund3
 */
public class TestCacheV2 {

	static class LRUCache {

		Map<Integer, Integer> map = new HashMap<>();
		FixSizeQueue queue;
		int nowNumber;
		int capicility;

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
			this.capicility = capacity;
			queue = new FixSizeQueue(capacity);
		}

		public Integer get(Integer key) {
			if (map.containsKey(key)) {
				if (nowNumber != key) {
					queue.add(key);
					nowNumber = key;
				}
				return map.get(key);
			} else {
				return -1;
			}
		}

		public void put(Integer key, Integer value) {
			if (map.size() < capicility) {
				map.put(key, value);
				queue.add(key);
			} else {
				Integer oldKey = queue.poll();
				map.remove(oldKey);
				map.put(key, value);
			}
		}
	}

	static class FixSizeQueue {

		Integer size;

		public FixSizeQueue(int size) {
			this.size = size;
		}

		Queue<Integer> queue = new LinkedList<>();

		public void add(Integer value) {
			if (queue.size() < size) {
				queue.add(value);
			} else {
				queue.poll();
				queue.add(value);
			}
		}

		public Integer poll() {
			return queue.poll();
		}

		public Integer peek() {
			return queue.peek();
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		System.out.println(cache);
		cache.put(2, 2);
		System.out.println(cache);
		cache.put(2, 3);
		System.out.println(cache);
		System.out.println("cache.get(1): " + cache.get(1));
	}
}

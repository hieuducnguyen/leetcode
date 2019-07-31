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
public class TestCache {

	static class LRUCache {

		Map<Integer, Item> map = new HashMap<>();
		Map<Integer, Integer> frequency = new HashMap<>();
		int offset = 0;
		int counter = -1;
		int capacity;

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("==LRU Cache Start==\n");
			for (Integer key : map.keySet()) {
				sb.append(String.format("key %s value %s \n", key, map.get(key).value));
			}
			sb.append("==LRU Cache End==\n");
			return sb.toString();
		}

		LRUCache(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				Item item = map.get(key);
				int valueItem = item.value;
				int counterItem = item.counter;
				frequency.remove(counterItem);
				counter++;
				frequency.put(counter, key);
				map.put(key, new Item(key, valueItem, counter));
				offset++;
				return valueItem;
			} else {
				return -1;
			}
		}

		public void put(int key, int value) {
			if (map.size() < capacity) {
				counter++;
				frequency.put(counter, key);
				map.put(key, new Item(key, value, counter));
			} else {
				counter++;
				int removeCounter = counter - capacity - offset;
				Integer removeKey = frequency.get(removeCounter);
				map.remove(removeKey);
				map.put(key, new Item(key, value, counter));
				frequency.put(counter, key);
			}
		}
	}

	static class Item {

		int key;
		int value;
		int counter;

		public Item(int key, int value, int counter) {
			this.key = key;
			this.value = value;
			this.counter = counter;
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);//0
		cache.put(2, 2);//1
		cache.get(1);//2
		cache.put(3, 3);//3
		cache.put(4, 4);
		System.out.println(cache);
	}
}

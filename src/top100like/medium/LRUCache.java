/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class LRUCache {

	Map<Integer, Integer> counterKey = new HashMap<>();
	Map<Integer, Item> map = new HashMap<>();
	int capacity;
	int counter = 0;
	int offset = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		Item value = map.get(key);
		if (value != null) {
			offset++;
//			counterKey.remove(value.counter);
			counter++;
			value.counter = counter;
			map.put(key, value);
			counterKey.put(counter, key);
			return value.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		counter++;
		Item item = new Item(key, value, counter);
		Item valueItem = map.get(key);
		if (valueItem != null) {
			offset++;
//			counterKey.remove(valueItem.counter);
			valueItem.counter = counter;
			map.put(key, item);
			counterKey.put(counter, key);
		} else {
			if (map.size() < capacity) {
				counterKey.put(counter, key);
				map.put(key, item);
			} else {
				int oldCounter = counter - (capacity + offset);
				Integer get = counterKey.get(oldCounter);
				map.remove(get);
//				counterKey.remove(oldCounter);
				map.put(key, item);
				counterKey.put(counter, key);
			}
		}
	}

	class Item {

		int key;
		int value;
		int counter;

		Item(int key, int value, int counter) {
			this.key = key;
			this.value = value;
			this.counter = counter;
		}

		@Override
		public String toString() {
			return "key: " + key + ",value: " + value + ",counter: " + counter;
		}

	}

	@Override
	public String toString() {
		return "map: " + map.toString() + " counterMap: " + counterKey.toString();
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		cache.put(2, 1);
		System.out.println(cache);

		cache.put(2, 2);
		System.out.println(cache);

		int value1 = cache.get(2); // returns 1
		System.out.println("value1: " + value1);
		System.out.println(cache);

		cache.put(1, 1);
		System.out.println(cache);

		cache.put(4, 1);
		System.out.println(cache);

		int value2 = cache.get(2); // returns 1
		System.out.println("value1: " + value2);
		System.out.println(cache);

	}
}

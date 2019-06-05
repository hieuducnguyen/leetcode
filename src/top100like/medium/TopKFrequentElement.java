/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author hieund3
 */
public class TopKFrequentElement {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 1, 2, 2, 3};
		int k = 2;
		List<Integer> list = process(nums, k);
		System.out.println("list: " + list);
	}

	private static List<Integer> process(int[] nums, int k) {
		List<Integer> resultList = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			updateMap(map, nums[i]);
		}
		Queue<Item> priorityQueue = new PriorityQueue<>(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return -(o1.value - o2.value);
			}
		});
		map.forEach((t, v) -> {
			priorityQueue.add(new Item(t, v));
		});
		for (int i = 0; i < k; i++) {
			Item item = priorityQueue.poll();
			resultList.add(item.key);
		}
		return resultList;
	}

	private static void updateMap(Map<Integer, Integer> map, int num) {
		if (map.get(num) == null) {
			map.put(num, 1);
		} else {
			Integer value = map.get(num);
			map.put(num, value + 1);
		}
	}

	private static class Item {

		int key;
		int value;

		public Item(Integer t, Integer get) {
			key = t;
			value = get;
		}

		@Override
		public String toString() {
			return "key: " + key + "|value: " + value;
		}

	}

	private static List<Integer> process1(int[] nums, int k) {
		List<Integer> resultList = new ArrayList<>();
		List<Item1> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			updateMap(map, nums[i]);
		}
		map.forEach((t, v) -> {
			list.add(new Item1(t, v));
		});
		Collections.sort(list);
		for (int i = 0; i < k; i++) {
			resultList.add(list.get(i).key);
		}
		return resultList;
	}

	private static class Item1 implements Comparable<Item1> {

		int key;
		int value;

		public Item1(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Item1 item1) {
			return -(this.value - item1.value);
		}
	}

	private static List<Integer> process2(int[] nums, int k) {
		List<Integer> resultList = new ArrayList<>();
		List<Item1> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			updateMap(map, nums[i]);
		}
		map.forEach((t, v) -> {
			list.add(new Item1(t, v));
		});
		Queue<Item1> priorityQueue = new PriorityQueue<>(list);
		for (int i = 0; i < k; i++) {
			Item1 item = priorityQueue.poll();
			resultList.add(item.key);
		}
		return resultList;
	}

	private static List<Integer> process3(int[] nums, int k) {
		List<Integer> resultList = new ArrayList<>();
		List<Item1> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			updateMap(map, nums[i]);
		}
		map.forEach((t, v) -> {
			list.add(new Item1(t, v));
		});
		for (int i = 0; i < k; i++) {
			Integer key = map.entrySet().stream().max((t, v) -> (t.getValue() - v.getValue())).get().getKey();
			resultList.add(key);
			map.remove(key);
		}
		return resultList;
	}

	private static List<Integer> process4(int[] nums, int k) {
		List<Integer> resultList = new ArrayList<>();
		Queue<Item> priorityQueue = new PriorityQueue<>(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return -(o1.value - o2.value);
			}
		});
		Arrays.sort(nums);
		int counter = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				priorityQueue.add(new Item(nums[i], counter + 1));
				counter = 0;
			} else {
				counter++;
			}
		}
		priorityQueue.add(new Item(nums[nums.length - 1], counter + 1));
		for (int i = 0; i < k; i++) {
			resultList.add(priorityQueue.poll().key);
		}
		return resultList;
	}

	private static void createMap(Queue<Item> queue, int[] nums) {
		Arrays.sort(nums);
		int counter = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				queue.add(new Item(nums[i], counter + 1));
				counter = 0;
			} else {
				counter++;
			}
		}
		queue.add(new Item(nums[nums.length - 1], counter + 1));
	}

}

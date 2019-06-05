/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class SubSet {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2};
		List<List<Integer>> ret = process3(nums);
		System.out.println("ret: " + ret);
	}

	private static List<List<Integer>> process(int[] nums) {
		Set<Set<Integer>> resultSet = new HashSet<>();
		resultSet.add(new HashSet<>());

		for (int i = 1; i <= nums.length; i++) {
			Set<Set<Integer>> newResultSet = new HashSet<>(resultSet);
			for (int k = 0; k < nums.length; k++) {
				for (Set<Integer> subSet : resultSet) {
					if (!subSet.contains(nums[k])) {
						HashSet<Integer> hashSet = new HashSet<>(subSet);
						hashSet.add(nums[k]);
						newResultSet.add(hashSet);
					}
				}
			}
			resultSet = newResultSet;
		}

		List<List<Integer>> list = new ArrayList<>();
		for (Set item : resultSet) {
			list.add(new ArrayList<>(item));
		}
		return list;
	}

	private static List<List<Integer>> process2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			List<Integer> arrayList = new ArrayList<>();
			arrayList.add(nums[i]);
			list.add(arrayList);
		}
		List<List<Integer>> newList = new ArrayList<>(list);
		for (int i = 2; i <= nums.length; i++) {
			List<List<Integer>> tempList = new ArrayList<>();
			for (List<Integer> subList : newList) {
				if (!subList.isEmpty()) {
					int value = subList.get(subList.size() - 1);
					int index = map.get(value);
					for (int j = index + 1; j < nums.length; j++) {
						List<Integer> arrayList = new ArrayList<>(subList);
						arrayList.add(nums[j]);
						tempList.add(arrayList);
					}
				}
			}
			list.addAll(tempList);
			newList = tempList;
		}
		return list;
	}

	public static List<List<Integer>> process3(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> temp = new ArrayList<>();
			for (List<Integer> item : list) {
				temp.add(new ArrayList<>(item));
			}
			for (List<Integer> item : temp) {
				item.add(nums[i]);
				list.add(new ArrayList<>(item));
			}
		}
		return list;
	}
}

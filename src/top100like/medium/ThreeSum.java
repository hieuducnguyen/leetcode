/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = new int[]{0, 0, 0, 0};
		List<List<Integer>> ret = process(nums);
		System.out.println("ret: " + ret);
	}

	private static List<List<Integer>> process(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> returnList = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] > 0) {
				break;
			}

			List<List<Integer>> twoSum = twoSum(nums, i + 1, 0 - nums[i], nums[i]);
			returnList.addAll(twoSum);
		}
		return returnList;
	}

	public static List<List<Integer>> twoSum(int[] nums, int start, int sum, int initValue) {
		List<List<Integer>> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int i = start;
		while (i < nums.length) {
			if (map.get(sum - nums[i]) != null) {
				List<Integer> subList = new ArrayList<>();
				subList.add(nums[i]);
				subList.add(nums[map.get(sum - nums[i])]);
				subList.add(initValue);
				list.add(subList);
				if (i == nums.length - 1) {
					break;
				}
				while (nums[i] == nums[i + 1]) {
					i++;
					if (i == nums.length - 1) {
						break;
					}
				}
			}
			map.put(nums[i], i);
			i++;
		}
		return list;
	}
}
